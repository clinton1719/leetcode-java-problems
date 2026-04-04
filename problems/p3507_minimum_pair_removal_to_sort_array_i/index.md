---
id: 3507
title: "Minimum Pair Removal To Sort Array I"
difficulty: Easy
tags: [linked-list]
date: 2026-04-04
link: https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i
---

## Problem

Given an array nums, you can perform the following operation any number of times:

Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
Replace the pair with their sum.
Return the minimum number of operations needed to make the array non-decreasing.

An array is said to be non-decreasing if each element is greater than or equal to its previous element (if it exists).



Example 1:

Input: nums = [5,2,3,1]

Output: 2

Explanation:

The pair (3,1) has the minimum sum of 4. After replacement, nums = [5,2,4].
The pair (2,4) has the minimum sum of 6. After replacement, nums = [5,6].
The array nums became non-decreasing in two operations.

Example 2:

Input: nums = [1,2,2]

Output: 0

Explanation:

The array nums is already sorted.



Constraints:

1 <= nums.length <= 50
-1000 <= nums[i] <= 1000

## Approach

**Pattern used:** Simulation (Greedy + Brute Force)

### Core Idea

You repeatedly:

1. Check if the array is **already non-decreasing**
2. If not → find the **adjacent pair with minimum sum**
3. Merge that pair
4. Count the operation

This continues until the list becomes sorted.

---

### Step-by-step

1. **Convert array → List**

    * Needed because you dynamically remove elements

---

2. **Repeat until size > 1**

For each iteration:

#### a. Check if already sorted

* Traverse list:

    * If any `list[i] > list[i+1]` → not sorted
* If fully sorted → break early

---

#### b. Find minimum sum pair

* Iterate all adjacent pairs:

    * Compute `sum = list[i] + list[i+1]`
    * Track:

        * smallest sum
        * index of that pair

---

#### c. Merge the pair

* Replace `list[targetIndex] = minSum`
* Remove next element (`targetIndex + 1`)

---

#### d. Increment count

---

3. **Return count**

---

### Key Insights

* Greedy choice: always merge **minimum adjacent sum**
* This reduces disorder while minimizing impact on future merges
* However, this is **not proven optimal**, just brute-force simulation

---

### Subtle Details

* You check sorted condition **before merging**
  → avoids unnecessary operations
* Merging reduces list size → guarantees termination
* Adjacent-only constraint simplifies choices

---

### Edge Cases

* Already sorted → returns 0
* Single element → returns 0
* All decreasing → maximum merges
* Negative numbers → min sum may become more negative

---

## Complexity

**Time Complexity:** O(n³) (worst case)

Why:

* Outer loop runs ~O(n) times
* Each iteration:

    * Check sorted → O(n)
    * Find min pair → O(n)
    * Remove from list → O(n)

👉 Total ≈ O(n × n × n)

---

**Space Complexity:** O(n)

* List copy of array

---

## Optimization

### Better Approach (Using Heap or Monotonic Strategy)

You can improve by:

* Tracking adjacent pairs in a **min heap**
* Updating only affected neighbors after merge

This reduces:
👉 Time complexity to ~O(n log n)

But complexity increases due to:

* Maintaining valid neighbors
* Handling stale heap entries

---

**Q1:** Why might choosing the minimum sum pair not always lead to the globally optimal result?
**Q2:** How would you design a heap-based solution to avoid recomputing all pairs each time?
**Q3:** Can this problem be framed as a variation of interval merging or Huffman coding?


