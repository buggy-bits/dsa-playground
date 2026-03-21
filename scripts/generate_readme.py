"""
Scans every platform folder, reads Solution.java metadata,
and generates a complete README.md with per-platform tables.
"""

import os
import re
from datetime import datetime

SKIP = {".git", ".github", "scripts", "__pycache__", ".vscode", ".idea", "node_modules"}

DISPLAY_NAMES = {
    "leetcode": "LeetCode",
    "gfg": "GeeksForGeeks",
    "geeksforgeeks": "GeeksForGeeks",
    "codeforces": "Codeforces",
    "hackerrank": "HackerRank",
    "neetcode": "NeetCode",
    "interviewbit": "InterviewBit",
}


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


def discover_platforms(root="."):
    platforms = {}
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
                display = DISPLAY_NAMES.get(item, item.replace("-", " ").title())
                platforms[item] = display
                break
    return platforms


def scan_problems(platform_dir):
    problems = []
    for folder in sorted(os.listdir(platform_dir)):
        fp = os.path.join(platform_dir, folder)
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
                "topics": meta.get("topics", "-"),
                "date": meta.get("date_solved", "-"),
                "folder": folder,
            }
        )

    problems.sort(key=lambda p: (p["number"], p["title"]))
    return problems


def generate():
    platforms = discover_platforms()

    if not platforms:
        with open("README.md", "w", encoding="utf-8") as f:
            f.write(
                "# 🚀 DSA Playground\n\n"
                "_No problems solved yet. Run `python scripts/solve.py` to start!_\n"
            )
        print("  README.md created (empty - no problems found yet)")
        return

    all_data = {}
    total, easy, med, hard = 0, 0, 0, 0

    for pfolder, pname in platforms.items():
        probs = scan_problems(pfolder)
        all_data[pfolder] = {"name": pname, "problems": probs}
        for p in probs:
            total += 1
            dl = p["difficulty"].lower()
            if "easy" in dl:
                easy += 1
            elif "medium" in dl:
                med += 1
            elif "hard" in dl:
                hard += 1

    lines = []

    lines.append("# 🚀 DSA Playground\n")
    lines.append("> My DSA journey — one problem at a time.")
    lines.append(">")
    lines.append("> **Language:** Java &nbsp;|&nbsp; **Platforms:** " + ", ".join(
        all_data[pf]["name"] for pf in all_data
    ))
    lines.append("")

    lines.append("---\n")
    lines.append("## 📊 Progress\n")
    lines.append("| Total Solved | 🟢 Easy | 🟡 Medium | 🔴 Hard |")
    lines.append("|:---:|:---:|:---:|:---:|")
    lines.append(f"| **{total}** | **{easy}** | **{med}** | **{hard}** |")
    lines.append("")

    lines.append("---\n")

    for pfolder, data in all_data.items():
        pname = data["name"]
        probs = data["problems"]
        count = len(probs)

        lines.append(f"## 📂 {pname} — {count} problem{'s' if count != 1 else ''}\n")
        lines.append("| S.No | Problem | Difficulty | Problem Link | My Solution |")
        lines.append("|:----:|---------|:----------:|:------------:|:-----------:|")

        for i, p in enumerate(probs, 1):
            if p["url"] and p["url"] != "#":
                prob_link = f"[🔗 Link]({p['url']})"
            else:
                prob_link = "-"

            sol_link = f"[Solution](./{pfolder}/{p['folder']}/Solution.java)"

            lines.append(
                f"| {i} "
                f"| {p['title']} "
                f"| {difficulty_badge(p['difficulty'])} "
                f"| {prob_link} "
                f"| {sol_link} |"
            )

        lines.append("")

    lines.append("---\n")
    now = datetime.now().strftime("%Y-%m-%d %H:%M")
    lines.append(f'<p align="center"><i>Last updated: {now}</i></p>\n')

    with open("README.md", "w", encoding="utf-8") as f:
        f.write("\n".join(lines))

    print(f"  README.md updated - {total} problems across {len(platforms)} platform(s)")


if __name__ == "__main__":
    generate()