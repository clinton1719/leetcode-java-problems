---
id: 130
title: "Surrounded Regions"
difficulty: Medium
tags: []
date: 2026-04-18
link: https://leetcode.com/problems/surrounded-regions
---

## Problem

You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: A region is surrounded if none of the 'O' cells in that region are on the edge of the board. Such regions are completely enclosed by 'X' cells.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.



Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:


In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]



Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.


## Approach

**Pattern used:** DFS / Flood Fill (Boundary Traversal)

### Core Idea

You need to flip only those `'O'` regions that are **completely surrounded by `'X'`**.

👉 Key observation:

* Any `'O'` connected to the **boundary** can NEVER be surrounded

So instead of finding surrounded regions directly:
👉 Mark all **boundary-connected 'O' as safe**, then flip the rest

---

### Step-by-step

### 1. Traverse boundaries

* Run DFS on:

    * First and last column
    * First and last row

👉 For every `'O'` on boundary:

* Mark it (and all connected `'O'`) as `'#'` (safe)

---

### 2. DFS (Flood Fill)

For each boundary `'O'`:

* Recursively visit all 4 directions
* Mark all connected `'O'` → `'#'`

---

### 3. Final pass

Traverse entire board:

* `'O'` → `'X'` (these are surrounded)
* `'#'` → `'O'` (restore safe ones)

---

### Key Insights

* You don’t find surrounded regions directly
* You **eliminate non-surrounded regions first**

👉 This inversion simplifies the problem

---

### Example

Input:
X X X X
X O O X
X X O X
X O X X

Boundary DFS marks:
X X X X
X O O X
X X O X
X # X X

Final:
X X X X
X X X X
X X X X
X O X X

---

### Subtle Details

* Must mark before flipping, otherwise info is lost
* DFS ensures entire connected component is preserved
* Order of traversal doesn’t matter

---

### Edge Cases

* All `'O'` → none flipped (all connected to boundary)
* All `'X'` → no change
* Single row/column → no surrounded region possible
* Large grid → recursion depth risk

---

## Complexity

**Time Complexity:** O(m × n)

* Each cell visited at most once

---

**Space Complexity:** O(m × n) (worst case recursion stack)

* DFS recursion depth

---

## Optimization

### Iterative BFS (Safer)

* Replace DFS with queue
* Avoid stack overflow on large grids

---

### Space Optimization

* No extra visited array needed
* Reuse board with `'#'` marking

---

**Q1:** Why is it easier to mark boundary-connected regions instead of directly finding surrounded ones?
**Q2:** How would you convert this DFS solution into BFS using a queue?
**Q3:** What happens if diagonal connections were also considered valid adjacency?
