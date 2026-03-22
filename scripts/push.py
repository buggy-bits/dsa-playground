"""
  1. Regenerates README.md from all solution files
  2. Stages everything
  3. Commits with a  message
  4. Pushes to GitHub
"""

import os
import sys
import subprocess
from datetime import datetime


def get_repo_root():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    return os.path.dirname(script_dir)


def run(cmd):
    result = subprocess.run(
        cmd, shell=True, capture_output=True, text=True, cwd=get_repo_root()
    )
    return result


def main():
    repo_root = get_repo_root()
    os.chdir(repo_root)

    print()
    print("=" * 50)
    print("   DSA Playground  -  Daily Push")
    print("=" * 50)
    print()

    # Step 1: Regenerate README
    print("  Regenerating README.md ...")
    gen_script = os.path.join("scripts", "generate_readme.py")
    result = subprocess.run(
        [sys.executable, gen_script], capture_output=True, text=True, cwd=repo_root
    )
    if result.stdout.strip():
        print(result.stdout.strip())
    if result.returncode != 0:
        print(f"  README generation error: {result.stderr.strip()}")
        return

    # Step 2: Stage everything
    print("  Staging changes ...")
    run("git add .")

    # Step 3: Check if anything to commit
    status = run("git status --porcelain")
    changed = status.stdout.strip()

    if not changed:
        print()
        print("  Nothing new to commit. You're all caught up!")
        print()
        return

    print()
    print("  Changes detected:")
    print("  " + "-" * 40)
    for line in changed.split("\n"):
        print(f"    {line}")
    print("  " + "-" * 40)
    print()

    # Step 4: Build commit message
    new_solutions = [
        l for l in changed.split("\n")
        if "Solution.java" in l and (l.startswith("A") or l.startswith("?"))
    ]
    n = len(new_solutions)

    date_str = datetime.now().strftime("%Y-%m-%d")
    if n > 0:
        default_msg = f"Solved {n} problem{'s' if n != 1 else ''} - {date_str}"
    else:
        default_msg = f"DSA Update - {date_str}"

    user_msg = input(f"  Commit message [{default_msg}]: ").strip()
    commit_msg = user_msg if user_msg else default_msg

    # Step 5: Commit
    print()
    print("  Committing ...")
    run(f'git commit -m "{commit_msg}"')

    # Step 6: Push
    print("  Pushing to GitHub ...")
    push_result = run("git push origin main")

    if push_result.returncode == 0:
        print()
        print("  " + "=" * 40)
        print(f"  Done!  {commit_msg}")
        print("  " + "=" * 40)
    else:
        print()
        print("  Push failed. Error:")
        print(f"    {push_result.stderr.strip()}")
        print()
        print("  Try manually: git push origin main")

    print()


if __name__ == "__main__":
    main()