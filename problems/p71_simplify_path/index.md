---
id: 71
title: "Simplify Path"
difficulty: Medium
tags: [string, stack]
date: 2026-05-03
link: https://leetcode.com/problems/simplify-path
---

## Problem

You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.

The rules of a Unix-style file system are as follows:

A single period '.' represents the current directory.

A double period '..' represents the previous/parent directory.

Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.

Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.

The simplified canonical path should follow these rules:

The path must start with a single slash '/'.

Directories within the path must be separated by exactly one slash '/'.

The path must not end with a slash '/', unless it is the root directory.

The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.

Return the simplified canonical path.



Example 1:

Input: path = "/home/"

Output: "/home"

Explanation:

The trailing slash should be removed.

Example 2:

Input: path = "/home//foo/"

Output: "/home/foo"

Explanation:

Multiple consecutive slashes are replaced by a single one.

Example 3:

Input: path = "/home/user/Documents/../Pictures"

Output: "/home/user/Pictures"

Explanation:

A double period ".." refers to the directory up a level (the parent directory).

Example 4:

Input: path = "/../"

Output: "/"

Explanation:

Going one level up from the root directory is not possible.

Example 5:

Input: path = "/.../a/../b/c/../d/./"

Output: "/.../b/d"

Explanation:

"..." is a valid name for a directory in this problem.



Constraints:

1 <= path.length <= 3000
path consists of English letters, digits, period '.', slash '/' or '_'.
path is a valid absolute Unix path.



## Approach

**Pattern used:** Stack (Simulation of File System Navigation)

---

### Core Idea

The path is processed component by component, simulating how a Unix file system resolves paths:

* `"."` → stay in current directory (ignore)
* `".."` → go to parent directory (pop from stack)
* valid name → move into directory (push to stack)

---

### Step-by-step

### 1. Split path

* Use `split("/")` to break into components

Example:
`"/a/./b/../c/" → ["", "a", ".", "b", "..", "c", ""]`

---

### 2. Process each component

For each `comp`:

* `""` or `"."` → ignore
* `".."` → pop from stack if not empty
* otherwise → push directory name

---

### 3. Build final path

* Pop all elements from stack
* Construct path in reverse order using `insert(0, ...)`

---

### Key Insights

* Stack naturally models directory traversal:

    * Push → go deeper
    * Pop → go back

* Ignoring empty strings handles multiple `/`

## Complexity

**Time Complexity:**
O(n) for processing + O(n²) for string building (due to repeated insert at index 0)

---

**Space Complexity:** O(n)

* Stack + result string


## Final Take

* Correct and clean stack-based solution
* Slight inefficiency in string construction
* Easily optimized to linear time

---

**Q1:** Why is `insert(0, …)` inefficient compared to append?
**Q2:** Can this be solved without using a stack explicitly?
**Q3:** How would you handle relative paths instead of absolute ones?

 

