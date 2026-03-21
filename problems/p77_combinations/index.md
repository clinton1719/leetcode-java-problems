---
id: 77
title: "Combinations"
difficulty: Medium
tags: [backtracking]
date: 2026-03-20
link: https://leetcode.com/problems/combinations
---

## Problem

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.



Example 1:

Input: n = 4, k = 2

Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.


Constraints:

1 <= n <= 20
1 <= k <= n


## Approach

The goal is to generate all possible **combinations of `k` numbers from `1` to `n`**.

### Key Idea: Backtracking (Combinations)

We build combinations incrementally and explore all valid choices using **DFS with pruning via `start` index**.

---

### Step-by-step reasoning

1. Maintain:
   - `currentList` → current combination being built
   - `start` → next number to consider (ensures no duplicates and maintains order)

---

2. Base Case

If `currentList.size() == k`:

- We have a valid combination
- Add a **copy** of it to the result
- Return

---

3. Recursive Exploration

Loop from `start` to `n`:

- Choose a number `i`
- Add it to `currentList`
- Recurse with:
  
  start = i + 1  
  (so each number is used only once and combinations remain sorted)

- Backtrack:
  
  Remove the last added element to explore other possibilities

---

### Why This Works

- Each recursive call explores combinations that include a specific number.
- The `start` index prevents:
  - Reusing the same number
  - Generating duplicate combinations

---

### Example (n = 4, k = 2)

Generated combinations:

[1,2], [1,3], [1,4], [2,3], [2,4], [3,4]

---

## Complexity

### Time Complexity

O(C(n, k) × k)

- There are **C(n, k)** combinations
- Each combination takes **O(k)** time to construct (copying list)

---

### Space Complexity

O(k)

- Recursion depth is at most `k`

Output space:

O(C(n, k) × k)


