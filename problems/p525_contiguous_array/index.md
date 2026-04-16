---
id: 525
title: "Contiguous Array"
difficulty: Medium
tags: [string, tricky, sliding-window, hash-table, prefix-sum]
date: 2026-04-14
link: https://leetcode.com/problems/contiguous-array
---

## Problem

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.



Example 1:


Input: nums = [0,1]

Output: 2

Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:


Input: nums = [0,1,0]

Output: 2

Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Example 3:


Input: nums = [0,1,1,1,1,1,0,0,0]

Output: 6

Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.



Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.

## Approach

**Pattern used:** Prefix Sum + HashMap

### Core Idea

You want the **longest subarray with equal number of 0s and 1s**.

Convert:

* `0 → -1`
* `1 → +1`

Then:
👉 Problem becomes finding **longest subarray with sum = 0**

---

### What your code is trying to do

* Maintain a running `count`
* Store first occurrence of each `count` in map
* If same `count` appears again → subarray in between has sum 0

---

### Critical Bug ❌

This line is wrong:

count = nums[i] == 1 ? 1 : -1;

👉 You are **resetting** count each time
Instead of accumulating

---

### Fix ✅

It should be:

count += nums[i] == 1 ? 1 : -1;

---

### Correct Logic

1. **Initialize**

    * `count = 0`
    * map stores: `count → first index`
    * `map.put(0, -1)` → handles full prefix case

---

2. **Traverse array**

For each index `i`:

* Update count
* If count seen before:

    * subarray sum = 0
    * length = `i - firstIndex`
* Else:

    * store index

---

3. **Track max length**

---

### Example

nums = [0,1,0]

After conversion:
[-1, +1, -1]

Prefix sums:
-1 → 0 → -1

At index 2:

* count = -1 seen before at index 0
* length = 2 - 0 = 2

---

### Key Insights

* Same prefix sum ⇒ zero-sum subarray in between
* Store **first occurrence only** for max length
* Classic prefix sum pattern

---

### Edge Cases

* No valid subarray → return 0 (not MIN_VALUE)
* All 0s or all 1s → result = 0
* Entire array balanced → length = n

---

## Complexity

**Time Complexity:** O(n)

* Single pass

---

**Space Complexity:** O(n)

* Map stores prefix sums

---

## Optimization

Already optimal.

---

### Small Fixes

* Initialize:
  `int maxLength = 0;`
  (not Integer.MIN_VALUE)

---

**Q1:** Why do we store only the first occurrence of a prefix sum?
**Q2:** How would this change if we wanted equal number of 0s, 1s, and 2s?
**Q3:** Can this technique be extended to find subarrays with sum = k?


 



