---
id: 136
title: "Single Number"
difficulty: Easy
tags: [array, bit-manipulation, xor]
date: 2026-02-28
link: https://leetcode.com/problems/single-number
---

## Problem

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,1]

Output: 1

Example 2:

Input: nums = [4,1,2,1,2]

Output: 4

Example 3:

Input: nums = [1]

Output: 1



Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.

## Approach

We use the XOR bitwise operator.

Key XOR properties:

1. a ^ a = 0
2. a ^ 0 = a
3. XOR is commutative and associative

Since every number appears twice except one:

Example:
[4, 1, 2, 1, 2]

Applying XOR:
4 ^ 1 ^ 2 ^ 1 ^ 2

Rearrange:
4 ^ (1 ^ 1) ^ (2 ^ 2)

Which becomes:
4 ^ 0 ^ 0 = 4

All duplicate numbers cancel out.
The remaining number is the answer.

Algorithm:
1. Initialize answer = 0.
2. XOR every number in the array with answer.
3. Return answer.


## Complexity 
Time: O(n)
We iterate through the array once.

Space: O(1)
Only one variable is used.