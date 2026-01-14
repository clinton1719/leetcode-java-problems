---
id: 169
title: "Majority Element"
difficulty: Easy
tags: [array, two-pointers, hash-table, divide-and-conquer, sorting, counting, boyer–moore-voting-algorithm, algorithm]
date: 2025-12-01
link: https://leetcode.com/problems/majority-element
---

## Problem

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
The input is generated such that a majority element will exist in the array.


Follow-up: Could you solve the problem in linear time and in O(1) space?

## Approach

This problem is solved using the **Boyer–Moore Voting Algorithm**.

The key guarantee in the problem is that a majority element always exists, meaning an element appears more than ⌊n / 2⌋ times. This allows us to eliminate pairs of different elements without losing the true majority.

We maintain two variables:

* `currentVal` stores the current candidate for the majority element.
* `count` tracks the balance of votes for the current candidate.

Invariant maintained during iteration:

* `count` represents the net votes for `currentVal` after canceling out different elements.
* If `count` becomes zero, the current candidate has been fully canceled by other values, so a new candidate is chosen.

Algorithm steps:

* Initialize `currentVal` to the first element and `count` to 1.
* Iterate through the array starting from index 1.
* If the current element equals `currentVal`, increment `count`.
* If it does not equal `currentVal`, decrement `count`.
* When `count` reaches zero, select the current element as the new candidate and reset `count` to 1.

Because the majority element appears more than all other elements combined, it cannot be completely canceled out. After the loop finishes, `currentVal` is guaranteed to be the majority element.

## Complexity

* **Time:** O(n)
  The array is traversed once.

* **Space:** O(1)
  Only constant extra variables are used.
