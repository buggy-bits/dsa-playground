"""
Creates a new problem folder + Solution.java template.
Run this for every problem.
"""

import os
import re
import json
from datetime import datetime

FOLDERS_FILE = os.path.join(os.path.dirname(os.path.abspath(__file__)), "folders.json")


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


def main():
    repo_root = get_repo_root()
    os.chdir(repo_root)

    print()
    print("=" * 50)
    print("   DSA Playground  -  New Problem")
    print("=" * 50)
    print()

    # ── Pick or create folder ─────────────────────────────
    existing = load_folders()

    if existing:
        print("  Your folders:")
        for i, name in enumerate(existing, 1):
            print(f"    {i}. {name}")
        print(f"    0. Create new folder")
        print()

        choice = input("  Select folder [0]: ").strip() or "0"

        if choice.isdigit() and 1 <= int(choice) <= len(existing):
            folder_name = existing[int(choice) - 1]
        else:
            folder_name = input("  New folder name (e.g. leetcode-150): ").strip()
            folder_name = slugify(folder_name)

            if not folder_name:
                print("  Folder name cannot be empty. Aborted.")
                return

            existing.append(folder_name)
            save_folders(existing)
            print(f"  Saved '{folder_name}' — it will show up next time.")
    else:
        print("  No folders yet. Let's create your first one.")
        print()
        folder_name = input("  Folder name (e.g. leetcode-150): ").strip()
        folder_name = slugify(folder_name)

        if not folder_name:
            print("  Folder name cannot be empty. Aborted.")
            return

        existing.append(folder_name)
        save_folders(existing)
        print(f"  Saved '{folder_name}' — it will show up next time.")

    # ── Problem details ───────────────────────────────────
    print()
    num_input = input("  Problem Number: ").strip()
    num = int(num_input) if num_input.isdigit() else 0

    title = input("  Problem Title: ").strip()
    url = input("  Problem URL: ").strip()
    difficulty = input("  Difficulty (Easy/Medium/Hard) [Medium]: ").strip().capitalize() or "Medium"

    # ── Create folder ─────────────────────────────────────
    slug = slugify(title)
    if num > 0:
        problem_folder = f"{num:04d}-{slug}"
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

    # ── Create Solution.java ────────────────────────────────
    solution_path = os.path.join(folder_path, "Solution.java")
    date_str = datetime.now().strftime("%Y-%m-%d")

    template = f"""\
// Problem: {title}
// URL: {url}
// Difficulty: {difficulty}
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