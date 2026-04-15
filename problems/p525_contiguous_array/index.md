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

 



