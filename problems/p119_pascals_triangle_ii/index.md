---
id: 119
title: "Pascals Triangle II"
difficulty: Easy
tags: [array, dynamic-programming]
date: 2026-03-28
link: https://leetcode.com/problems/pascals-triangle-ii
---

## Problem

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

![img.png](img.png)


Example 1:


Input: rowIndex = 3

Output: [1,3,3,1]

Example 2:

Input: rowIndex = 0

Output: [1]

Example 3:

Input: rowIndex = 1

Output: [1,1]


Constraints:

0 <= rowIndex <= 33


Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?


## Approach

This solution computes the **k-th row of Pascal’s Triangle** using an **in-place dynamic programming approach**.

### Key Idea: Single List + Right-to-Left Update

We maintain a single list `row` and build it iteratively.

For each iteration `i`:
- Append `1` (since every row ends with 1)
- Update the **middle elements** using previously computed values

---

### Step-by-step reasoning

1. Start with an empty list.

2. For each row `i` from `0 → rowIndex`:

   - Add `1` at the end:
     
     row.add(1)

   - Update elements from **right to left**:

     for (j = i - 1 → 1):

     row[j] = row[j] + row[j - 1]

---

### Why Right-to-Left?

Because:

- We rely on values from the **previous row**
- Updating left-to-right would overwrite values needed later

Right-to-left ensures:
- `row[j - 1]` is still from the previous iteration

---

### Example (rowIndex = 4)

Start:

[]

i = 0 → [1]  
i = 1 → [1, 1]  
i = 2 → [1, 2, 1]  
i = 3 → [1, 3, 3, 1]  
i = 4 → [1, 4, 6, 4, 1]

---

### Why This Works

Each value is computed using:

row[j] = previousRow[j] + previousRow[j - 1]

By iterating backward, we simulate the previous row **in-place**.

---

## Complexity

### Time Complexity

O(n²)

- Total updates across all iterations

---

### Space Complexity

O(n)

- Only one list is used



