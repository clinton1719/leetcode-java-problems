---
id: 46
title: "Permutations"
difficulty: Medium
tags: [backtracking, array]
date: 2026-03-20
link: https://leetcode.com/problems/permutations
---

## Problem

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.


## Approach

**Pattern used:** Backtracking (DFS)

### Core Idea

You are generating **all permutations** of the array.

At each step:

* Choose an unused element
* Add it to the current permutation
* Recurse
* Undo the choice (backtrack)

---

### Step-by-step

1. **Start recursion**

    * Empty `currentList`
    * Target size = `n`

---

2. **Base case**

    * If `currentList.size() == n`
    * Add a copy to result
    * Return

---

3. **Explore choices**

For each index `i`:

* If `nums[i]` is already in `currentList` → skip
* Else:

    * Add it to current list
    * Recurse
    * Remove last element (backtrack)

---

### Key Insights

* This builds permutations as a **decision tree**
* Each level represents a position in permutation
* `currentList.contains(...)` ensures no duplicates in a permutation

---

### Subtle Details

* You must create a **new copy** when adding to result
* Backtracking step (`removeLast`) is critical
* `contains()` check ensures correctness but is inefficient

---

### Example

nums = [1, 2, 3]

Tree structure:

* Start []

    * [1]

        * [1,2]

            * [1,2,3]
        * [1,3]

            * [1,3,2]
    * [2] ...
    * [3] ...

---

### Edge Cases

* Empty array → returns [[]]
* Single element → [[x]]
* Duplicate values → this code produces duplicate permutations

---

## Complexity

**Time Complexity:** O(n! × n)

* n! permutations
* Each permutation takes O(n) to build and check `contains`

---

**Space Complexity:** O(n)

* Recursion stack depth = n
* Current list size = n
* (Result storage excluded)

---

## Optimization

### Better Approach (Using boolean[] visited)

Instead of:
`currentList.contains(nums[i])` → O(n)

Use:

* `boolean[] visited`

This reduces check to O(1)

---

### Even Better (In-place swapping)

Swap elements instead of tracking visited:

* Fix one position at a time
* Swap back after recursion

👉 Reduces extra space and improves performance

---

**Q1:** Why does using `contains()` make this solution slower than necessary?
**Q2:** How does the in-place swapping approach eliminate the need for extra space?
**Q3:** How would you modify this to handle duplicate numbers without generating duplicate permutations?




