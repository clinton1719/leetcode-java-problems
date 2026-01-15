---
id: 189
title: "Rotate Array"
difficulty: Medium
tags: [array, math, two-pointers]
date: 2026-01-15
link: https://leetcode.com/problems/rotate-array
---

## Problem
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105


Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?

## Approach

This solution rotates the array to the **right by `k` steps** using the **reverse technique**, which performs the operation **in-place** without extra memory.

### Key idea
A right rotation by `k` positions can be broken into **three reversals**:

1. **Normalize `k`**
    - `k %= nums.length` ensures we don’t rotate more than the array size.

2. **Reverse the entire array**
    - This brings the elements that should end up at the front closer to their final positions.

3. **Reverse the first `k` elements**
    - This restores the correct order of the rotated prefix.

4. **Reverse the remaining `n - k` elements**
    - This restores the correct order of the remaining elements.

Each reversal is done using a two-pointer swap approach.

---

## Complexity

* **Time:** `O(n)`
    - Each element is visited a constant number of times across the three reversals.

* **Space:** `O(1)`
    - The rotation is done in-place using only a temporary variable.
