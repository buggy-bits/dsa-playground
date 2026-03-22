"""
Scans every tracked folder, reads Solution.java metadata,
and generates README.md with per-folder tables.
Clean and simple.
"""

import os
import re
import json
from datetime import datetime

SKIP = {".git", ".github", "scripts", "__pycache__", ".vscode", ".idea", "node_modules"}
FOLDERS_FILE = os.path.join(os.path.dirname(os.path.abspath(__file__)), "folders.json")


def parse_solution(filepath):
    meta = {}
    try:
        with open(filepath, "r", encoding="utf-8") as f:
            for line in f:
                line = line.strip()
                if not line.startswith("//"):
                    break
                m = re.match(r"//\s*([^:]+):\s*(.+)", line)
                if m:
                    key = m.group(1).strip().lower().replace(" ", "_")
                    val = m.group(2).strip()
                    meta[key] = val
    except Exception:
        pass
    return meta


def difficulty_badge(d):
    dl = d.lower()
    if "easy" in dl:
        return "🟢 Easy"
    if "medium" in dl:
        return "🟡 Medium"
    if "hard" in dl:
        return "🔴 Hard"
    return d


def discover_folders(root="."):
    # Find all folders at root level that contain problem sub-folders.
    folders = {}
    for item in sorted(os.listdir(root)):
        if item in SKIP or item.startswith("."):
            continue
        path = os.path.join(root, item)
        if not os.path.isdir(path):
            continue
        for sub in os.listdir(path):
            sub_path = os.path.join(path, sub)
            if os.path.isdir(sub_path) and os.path.isfile(
                os.path.join(sub_path, "Solution.java")
            ):
                display = item.replace("-", " ").title()
                folders[item] = display
                break
    return folders


def scan_problems(folder_dir):
    problems = []
    for folder in sorted(os.listdir(folder_dir)):
        fp = os.path.join(folder_dir, folder)
        sf = os.path.join(fp, "Solution.java")
        if not os.path.isdir(fp) or not os.path.isfile(sf):
            continue

        meta = parse_solution(sf)
        parts = folder.split("-", 1)
        try:
            num = int(parts[0])
        except ValueError:
            num = 0

        fallback_title = (
            parts[1].replace("-", " ").title() if len(parts) > 1 else folder.replace("-", " ").title()
        )

        problems.append(
            {
                "number": num,
                "title": meta.get("problem", fallback_title),
                "url": meta.get("url", "#"),
                "difficulty": meta.get("difficulty", "Unknown"),
                "date": meta.get("date_solved", "-"),
                "folder": folder,
            }
        )

    problems.sort(key=lambda p: (p["number"], p["title"]))
    return problems


def generate():
    folders = discover_folders()

    if not folders:
        with open("README.md", "w", encoding="utf-8") as f:
            f.write(
                "# 🚀 DSA Playground\n\n"
                "_No problems solved yet. Run `python scripts/solve.py` to start!_\n"
            )
        print("  README.md created (empty - no problems found yet)")
        return

    all_data = {}
    total = 0

    for fname, display in folders.items():
        probs = scan_problems(fname)
        all_data[fname] = {"name": display, "problems": probs}
        total += len(probs)

    lines = []

    # Header
    lines.append("# 🚀 DSA Playground\n")
    lines.append("> My DSA journey — one problem at a time.")
    lines.append(">")
    lines.append("> **Language:** Java")
    lines.append("")
    lines.append("---\n")

    # Per-folder sections
    for fname, data in all_data.items():
        display_name = data["name"]
        probs = data["problems"]
        count = len(probs)

        lines.append(f"## 📂 {display_name} — {count} problem{'s' if count != 1 else ''}\n")
        lines.append("| S.No | Problem | Difficulty | Problem  | My Solution |")
        lines.append("|:----:|---------|:----------:|:--------:|:-----------:|")

        for i, p in enumerate(probs, 1):
            if p["url"] and p["url"] != "#":
                prob_link = f"[Link]({p['url']})"
            else:
                prob_link = "-"

            sol_link = f"[Solution](./{fname}/{p['folder']}/Solution.java)"

            lines.append(
                f"| {i} "
                f"| {p['title']} "
                f"| {difficulty_badge(p['difficulty'])} "
                f"| {prob_link} "
                f"| {sol_link} |"
            )

        lines.append("")
        lines.append("---\n")

    # Footer
    now = datetime.now().strftime("%Y-%m-%d %H:%M")
    lines.append(f'<p align="center"><i>Last updated: {now}</i></p>\n')

    with open("README.md", "w", encoding="utf-8") as f:
        f.write("\n".join(lines))

    print(f"  README.md updated - {total} problems across {len(folders)} folder(s)")


if __name__ == "__main__":
    generate()