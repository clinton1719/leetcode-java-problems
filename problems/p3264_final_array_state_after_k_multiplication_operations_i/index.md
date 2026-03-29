---
id: 2331
title: "Final Array State After K Multiplication Operations I"
difficulty: Easy
tags: [heap, array, math]
date: 2026-03-23
link: https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i
---

## Problem

You are given an integer array nums, an integer k, and an integer multiplier.

You need to perform k operations on nums. In each operation:

Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that appears first.
Replace the selected minimum value x with x * multiplier.
Return an integer array denoting the final state of nums after performing all k operations.



Example 1:

Input: nums = [2,1,3,5,6], k = 5, multiplier = 2


Output: [8,4,6,5,6]


Explanation:

Operation	Result
After operation 1	[2, 2, 3, 5, 6]
After operation 2	[4, 2, 3, 5, 6]
After operation 3	[4, 4, 3, 5, 6]
After operation 4	[4, 4, 6, 5, 6]
After operation 5	[8, 4, 6, 5, 6]
Example 2:

Input: nums = [1,2], k = 3, multiplier = 4

Output: [16,8]

Explanation:

Operation	Result
After operation 1	[4, 2]
After operation 2	[4, 8]
After operation 3	[16, 8]


Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
1 <= k <= 10
1 <= multiplier <= 5

## Approach

**Pattern used:** Min Heap (Priority Queue) + Simulation

### Core Idea

At each step, you must:

* Pick the **smallest element**
* Multiply it by `multiplier`
* Put it back and repeat `k` times

A **min heap** is ideal because it always gives the smallest element efficiently.

---

### Step-by-step

1. **Build min heap**

    * Store (value, index)
    * Comparator:

        * First by value (ascending)
        * If tie → by index (to ensure stable ordering)

---

2. **Insert all elements**

    * Push (nums[i], i) for all indices

---

3. **Repeat k operations (Simulation)**

   For each operation:

    * Extract smallest element from heap
    * Multiply its value by `multiplier`
    * Update original array:
      nums[index] *= multiplier
    * Push updated value back into heap

---

4. **Return nums**

    * Since updates were done directly on `nums`, it already reflects final state

---

### Key Insights

* Heap ensures **correct element selection each time**
* Index tracking is necessary to update original array
* This is a **step-by-step simulation problem**, not a one-pass optimization
* Tie-breaking by index ensures deterministic behavior

---

### Subtle Details

* You correctly reinsert the updated value into heap → critical
* Using nums[index] instead of item[0] avoids stale values
* Comparator handles duplicates safely

---

### Edge Cases

* k = 0 → return original array
* multiplier = 1 → no change, but still k heap ops happen
* Large k → repeated updates on same element possible
* Negative numbers → smallest (most negative) keeps getting picked

---

## Complexity

**Time Complexity:** O((n + k) log n)

* Building heap → O(n)
* k operations → each poll + offer → O(log n)

---

**Space Complexity:** O(n)

* Heap stores all elements

---

## Optimization

### When k is very large

This solution may become slow due to repeated heap operations.

Possible improvement:

* Track how many times each index gets updated
* Batch updates instead of simulating step-by-step

However:

* Because the "smallest element" changes dynamically after each operation,
  **true optimization is non-trivial**
* Heap-based simulation is the most reliable general solution

---



