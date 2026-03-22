"""
Creates a new problem folder + Solution.java template.
Supports auto-fetching problem info from LeetCode URLs.
For non-LeetCode URLs, falls back to manual input.
"""

import os
import re
import json
import http.cookiejar
import urllib.request
from datetime import datetime

FOLDERS_FILE = os.path.join(os.path.dirname(os.path.abspath(__file__)), "folders.json")

# ── Browser-like headers so LeetCode doesn't reject us ───
USER_AGENT = (
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
    "AppleWebKit/537.36 (KHTML, like Gecko) "
    "Chrome/131.0.0.0 Safari/537.36"
)


def get_repo_root():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    return os.path.dirname(script_dir)


def slugify(title):
    slug = title.lower().strip()
    slug = re.sub(r"[^a-z0-9]+", "-", slug)
    slug = slug.strip("-")
    return slug


def load_folders():
    if os.path.exists(FOLDERS_FILE):
        with open(FOLDERS_FILE, "r", encoding="utf-8") as f:
            return json.load(f)
    return []


def save_folders(folders):
    with open(FOLDERS_FILE, "w", encoding="utf-8") as f:
        json.dump(sorted(set(folders)), f, indent=2)


def extract_leetcode_slug(url):
    match = re.search(r"leetcode\.com/problems/([^/]+)", url)
    if match:
        return match.group(1)
    return None


def fetch_leetcode_info(slug):
    """
    Two-step fetch:
      1. GET the problem page → grab csrftoken cookie
      2. POST GraphQL with that token → get problem details
    """

    # ── Step 1: Visit problem page to get CSRF cookie ─────
    cookie_jar = http.cookiejar.CookieJar()
    opener = urllib.request.build_opener(
        urllib.request.HTTPCookieProcessor(cookie_jar)
    )

    page_request = urllib.request.Request(
        f"https://leetcode.com/problems/{slug}/",
        headers={
            "User-Agent": USER_AGENT,
            "Accept": "text/html",
        }
    )
    opener.open(page_request, timeout=15)

    # Extract csrftoken from cookies
    csrf_token = None
    for cookie in cookie_jar:
        if cookie.name == "csrftoken":
            csrf_token = cookie.value
            break

    # ── Step 2: GraphQL request with CSRF token ───────────
    query = {
        "query": """
        query getQuestionDetail($titleSlug: String!) {
            question(titleSlug: $titleSlug) {
                questionFrontendId
                title
                difficulty
            }
        }
        """,
        "variables": {"titleSlug": slug}
    }

    headers = {
        "Content-Type": "application/json",
        "User-Agent": USER_AGENT,
        "Referer": f"https://leetcode.com/problems/{slug}/",
        "Origin": "https://leetcode.com",
        "Accept": "application/json",
        "Accept-Language": "en-US,en;q=0.9",
    }

    if csrf_token:
        headers["X-Csrftoken"] = csrf_token

    api_request = urllib.request.Request(
        "https://leetcode.com/graphql",
        data=json.dumps(query).encode("utf-8"),
        headers=headers,
    )

    response = opener.open(api_request, timeout=15)
    data = json.loads(response.read().decode())
    question = data["data"]["question"]

    return {
        "number": int(question["questionFrontendId"]),
        "title": question["title"],
        "difficulty": question["difficulty"],
    }


def pick_folder():
    existing = load_folders()

    if existing:
        print("  Your folders:")
        for i, name in enumerate(existing, 1):
            print(f"    {i}. {name}")
        print(f"    0. Create new folder")
        print()

        choice = input("  Select folder [0]: ").strip() or "0"

        if choice.isdigit() and 1 <= int(choice) <= len(existing):
            return existing[int(choice) - 1]

    if not existing:
        print("  No folders yet. Let's create your first one.")
        print()

    folder_name = input("  New folder name (e.g. leetcode-150): ").strip()
    folder_name = slugify(folder_name)

    if not folder_name:
        return None

    existing.append(folder_name)
    save_folders(existing)
    print(f"  Saved '{folder_name}' - it will show up next time.")
    return folder_name


def get_problem_info():
    print()
    url = input("  Problem URL: ").strip()

    # ── Try LeetCode auto-fetch ───────────────────────────
    slug = extract_leetcode_slug(url)

    if slug:
        print()
        print(f"  LeetCode detected. Fetching info for '{slug}' ...")

        try:
            info = fetch_leetcode_info(slug)
            print(f"  Found: {info['number']}. {info['title']} [{info['difficulty']}]")
            print()

            confirm = input("  Correct? (Y/n): ").strip().lower()
            if confirm not in ("n", "no"):
                info["url"] = url
                return info
            else:
                print("  OK, enter details manually.")

        except Exception as e:
            print(f"  Could not fetch from LeetCode: {e}")
            print("  Falling back to manual input.")

    # ── Manual fallback ───────────────────────────────────
    print()
    num_input = input("  Problem Number: ").strip()
    num = int(num_input) if num_input.isdigit() else 0
    title = input("  Problem Title: ").strip()
    difficulty = input("  Difficulty (Easy/Medium/Hard) [Medium]: ").strip().capitalize() or "Medium"

    return {
        "number": num,
        "title": title,
        "difficulty": difficulty,
        "url": url,
    }


def main():
    repo_root = get_repo_root()
    os.chdir(repo_root)

    print()
    print("=" * 50)
    print("   DSA Playground  -  New Problem")
    print("=" * 50)
    print()

    # Step 1: Pick folder
    folder_name = pick_folder()
    if not folder_name:
        print("  Folder name cannot be empty. Aborted.")
        return

    # Step 2: Get problem info
    info = get_problem_info()

    if not info["title"]:
        print("  Problem title cannot be empty. Aborted.")
        return

    # Step 3: Create folder
    slug = slugify(info["title"])
    if info["number"] > 0:
        problem_folder = f"{info['number']:04d}-{slug}"
    else:
        problem_folder = slug

    folder_path = os.path.join(folder_name, problem_folder)

    if os.path.exists(folder_path):
        print(f"\n  Warning: Folder exists: {folder_path}")
        overwrite = input("  Overwrite? (y/N): ").strip().lower()
        if overwrite != "y":
            print("  Aborted.")
            return

    os.makedirs(folder_path, exist_ok=True)

    # Step 4: Create Solution.java
    solution_path = os.path.join(folder_path, "Solution.java")
    date_str = datetime.now().strftime("%Y-%m-%d")

    template = f"""\
// Problem: {info['title']}
// URL: {info['url']}
// Difficulty: {info['difficulty']}
// Date Solved: {date_str}

class Solution {{
    // TODO: Paste solution here

}}
"""

    with open(solution_path, "w", encoding="utf-8") as f:
        f.write(template)

    abs_path = os.path.abspath(solution_path)
    print()
    print(f"  Created: {solution_path}")
    print()
    print(f"  Next steps:")
    print(f"      1. Open  {abs_path}")
    print(f"      2. Paste your solution code")
    print(f"      3. Save the file")
    print()
    print(f"  When done for the day, run:")
    print(f"      python scripts/push.py")
    print()


if __name__ == "__main__":
    main()