"""
Creates a new problem folder + Solution.java template.
Run this for every problem you solve.
Does NOT commit - that happens in push.py at end of day.
"""

import os
import re
from datetime import datetime

PLATFORMS = {
    "1": ("leetcode", "LeetCode"),
    "2": ("gfg", "GeeksForGeeks"),
    "3": ("codeforces", "Codeforces"),
    "4": ("hackerrank", "HackerRank"),
    "5": ("neetcode", "NeetCode"),
}


def get_repo_root():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    return os.path.dirname(script_dir)


def slugify(title):
    slug = title.lower().strip()
    slug = re.sub(r"[^a-z0-9]+", "-", slug)
    slug = slug.strip("-")
    return slug


def main():
    repo_root = get_repo_root()
    os.chdir(repo_root)

    print()
    print("=" * 50)
    print("   DSA Playground  -  New Problem")
    print("=" * 50)
    print()

    print("  Select platform:")
    for key, (_, display) in PLATFORMS.items():
        print(f"    {key}. {display}")
    print(f"    0. Other (custom)")
    print()

    choice = input("  Platform [1]: ").strip() or "1"

    if choice in PLATFORMS:
        platform_folder, platform_display = PLATFORMS[choice]
    else:
        platform_folder = input("  Folder name (lowercase): ").strip().lower()
        platform_display = input("  Display name: ").strip()

    print()
    num_input = input("  Problem Number: ").strip()
    num = int(num_input) if num_input.isdigit() else 0

    title = input("  Problem Title: ").strip()
    url = input("  Problem URL: ").strip()
    difficulty = input("  Difficulty (Easy/Medium/Hard) [Medium]: ").strip().capitalize() or "Medium"
    topics = input("  Topics (comma separated) [-]: ").strip() or "-"

    slug = slugify(title)
    if num > 0:
        folder_name = f"{num:04d}-{slug}"
    else:
        folder_name = slug

    folder_path = os.path.join(platform_folder, folder_name)

    if os.path.exists(folder_path):
        print(f"\n  Warning: Folder exists: {folder_path}")
        overwrite = input("  Overwrite? (y/N): ").strip().lower()
        if overwrite != "y":
            print("  Aborted.")
            return

    os.makedirs(folder_path, exist_ok=True)

    solution_path = os.path.join(folder_path, "Solution.java")
    date_str = datetime.now().strftime("%Y-%m-%d")

    template = f"""\
// Problem: {title}
// Platform: {platform_display}
// URL: {url}
// Difficulty: {difficulty}
// Topics: {topics}
// Date Solved: {date_str}
//
// Time Complexity: O(?)
// Space Complexity: O(?)

class Solution {{
    // TODO: Paste your solution here

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