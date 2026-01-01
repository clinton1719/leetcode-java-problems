# 🧠 LeetCode Java Solutions

This repo contains my curated Java solutions for LeetCode problems. Each problem includes:

- ✅ Clean Java code
- 🧠 Approach + time & space complexity
- 🏷️ Tags for searching

## 🗂 Structure

```
problems/
  0001-two-sum/
    README.md         # Problem explanation with frontmatter
    solution.java      # Java solution
tags/
  array.md            # Tag-based index (auto-generated)
```

## 🛠 How to Regenerate Tag Indexes

Run the following in your terminal:

```bash
javac GenerateTagsIndex.java
java GenerateTagsIndex
```

2. Recommended Improvements for your Repo
To make this a "pro" LeetCode repository, consider these additions:

A. Main README Dashboard
Modify your Java script to also generate a main README.md in the root that acts as a Table of Contents. It could include:

A Summary Table (Total solved, Easy/Medium/Hard counts).

A Tag Cloud (Links to all files in the /tags folder).

B. GitHub Actions Optimization
Your current action triggers on every push. If you have many problems, you might want to add a step to clean the tags/ folder before running the Java script so that if you rename a tag, the old .md file doesn't hang around. Add this line to your workflow before running Java:

YAML

      - name: Clean old tags
        run: rm -rf tags/*.md
C. Pre-commit Hook
Running the script locally is easy to forget. You can add a simple pre-commit hook so the tags update automatically before you even push.

D. Difficulty Labels
In your generated tag files, it would be very helpful to see the difficulty at a glance.

Update ProblemInfo to store difficulty.

Update the output line to: - [1. Merge Sorted Array](../problems/p89) <kbd>Easy</kbd>