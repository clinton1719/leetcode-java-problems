---
id: 2099
title: "Find Subsequence of Length K With the Largest Sum"
difficulty: Easy
tags: [sorting, heap, array]
date: 2026-03-29
link: https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum
---

## Problem

You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: nums = [2,1,3,3], k = 2

Output: [3,3]

Explanation:

The subsequence has the largest sum of 3 + 3 = 6.

Example 2:


Input: nums = [-1,-2,3,4], k = 3

Output: [-1,3,4]

Explanation:

The subsequence has the largest sum of -1 + 3 + 4 = 6.

Example 3:


Input: nums = [3,4,3,3], k = 2

Output: [3,4]

Explanation:

The subsequence has the largest sum of 3 + 4 = 7.

Another possible subsequence is [4, 3].


Constraints:

1 <= nums.length <= 1000
-105 <= nums[i] <= 105
1 <= k <= nums.length

## Approach

**Pattern used:** Min Heap (Top K elements) + Sorting

### Core Idea

You want the **subsequence of size k with the largest sum**, while preserving **original order**.

So:

* Use a **min heap of size k** to keep track of the top k largest elements
* Then **sort those k elements by index** to restore subsequence order

---

### Step-by-step

1. **Maintain top k elements using min heap**

    * Heap stores: (value, index)
    * Comparator: smallest value at top
    * Iterate through array:

        * Add (nums[i], i)
        * If heap size > k → remove smallest element

   👉 Ensures heap always contains **k largest elements**

---

2. **Convert heap to array**

    * Now you have k elements, but:

        * They are NOT in original order

---

3. **Restore original order**

    * Sort by index (a[1])
    * This ensures subsequence property is maintained

---

4. **Build result**

    * Extract only values into result array

---

### Key Insights

* Min heap of size k → efficient way to track top k elements
* Storing index is critical → needed to reconstruct order
* Sorting after heap → restores subsequence constraint

---

### Edge Cases

* k == nums.length → return original array
* k == 1 → return max element
* Duplicate values → handled naturally
* Negative numbers → no issue (heap still works)

---

## Complexity

**Time Complexity:** O(n log k + k log k)

* Heap operations for n elements → O(n log k)
* Sorting k elements → O(k log k)

**Space Complexity:** O(k)

* Heap stores k elements
* Additional array for result

---

## Optimization

**Alternative (Sorting approach):**

1. Create array of (value, index)
2. Sort by value descending
3. Take top k
4. Sort those k by index

Same complexity: O(n log n), but:

* Simpler logic
* Slightly worse than heap when k << n

---

