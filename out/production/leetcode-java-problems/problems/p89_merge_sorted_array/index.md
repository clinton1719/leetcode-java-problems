---
id: 1
title: "Merge Sorted Array"
difficulty: Easy
tags: [array, two-pointers, sorting]
date: 2025-12-01
link: https://leetcode.com/problems/merge-sorted-array/description
---

## Problem

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

## Approach

Use a two-pointer technique starting from the end of both arrays.

Since `nums1` has extra space at the end (of size `n`), merging from the back prevents overwriting valid elements in `nums1`. Maintain three pointers:
- One at the last valid element of `nums1` (`m - 1`)
- One at the last element of `nums2` (`n - 1`)
- One at the last index of `nums1` (`m + n - 1`)

At each step, compare the elements pointed to in `nums1` and `nums2`, place the larger one at the current position in `nums1`, and move the corresponding pointer backward. Continue until one array is exhausted. If any elements remain in `nums2`, copy them into `nums1`. Remaining elements in `nums1` are already in the correct position.

This approach merges the arrays in place without using additional memory.

## Complexity

- **Time:** O(m + n)
- **Space:** O(1)
