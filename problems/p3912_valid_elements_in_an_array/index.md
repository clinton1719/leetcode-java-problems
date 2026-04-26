---
id: 3912
title: "Valid Elements in an Array"
difficulty: Easy
tags: [prefix-sum, suffix-array]
date: 2026-04-26
link: https://leetcode.com/problems/valid-elements-in-an-array
---

## Problem

You are given an integer array nums.

An element nums[i] is considered valid if it satisfies at least one of the following conditions:

It is strictly greater than every element to its left.
It is strictly greater than every element to its right.
The first and last elements are always valid.

Return an array of all valid elements in the same order as they appear in nums.



Example 1:


Input: nums = [1,2,4,2,3,2]


Output: [1,2,4,3,2]


Explanation:

nums[0] and nums[5] are always valid.

nums[1] and nums[2] are strictly greater than every element to their left.

nums[4] is strictly greater than every element to its right.

Thus, the answer is [1, 2, 4, 3, 2].

Example 2:


Input: nums = [5,5,5,5]


Output: [5,5]


Explanation:

The first and last elements are always valid.

No other elements are strictly greater than all elements to their left or to their right.

Thus, the answer is [5, 5].

Example 3:


Input: nums = [1]

Output: [1]


Explanation:

Since there is only one element, it is always valid. Thus, the answer is [1].




Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100


## Approach

**Pattern used:** Prefix Max + Suffix Max (Optimized)

### Core Idea

* An element is valid if:

    * `nums[i] > maxLeft`
    * OR `nums[i] > maxRight`

We:

* Precompute **suffix max**
* Maintain **prefix max on the fly**

---

## Complexity

**Time Complexity:** O(n)

* One pass for suffix max
* One pass for result

---

**Space Complexity:** O(n)

* Suffix array

---

## Optional Optimization

You can reduce space to **O(1)** by:

* Traversing from right and storing maxRight dynamically
* But readability decreases

---

**Q1:** Why are raw types (`List`) dangerous in Java compared to `List<Integer>`?
**Q2:** Can you modify this to return indices instead of values?
**Q3:** How would the logic change if duplicates were allowed (≥ instead of >)?
