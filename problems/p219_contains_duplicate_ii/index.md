---
id: 219
title: "Contains Duplicate II"
difficulty: Easy
tags: [array. hash-table, sliding-window]
date: 2026-02-16
link: https://leetcode.com/problems/contains-duplicate-ii
---

## Problem

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105

## Approach

We use a sliding window of size at most `k` with a HashSet.

The idea:
If two equal elements exist within distance `k`, they must both
appear inside the same window of the last `k` elements.

Algorithm:

1. Maintain a HashSet called `window`.
2. Iterate through the array.
3. If the current index `i` is greater than `k`,
   remove the element that is now out of range:
   nums[i - k - 1]
4. Try to add nums[i] to the set.
    - If it already exists, `add()` returns false,
      meaning a duplicate within distance `k` was found.
5. If we finish iterating, return false.

The window never grows larger than `k` elements.

## Complexity
Time: O(n)
Each element is added and removed at most once.

Space: O(k)
The set stores at most k elements.


