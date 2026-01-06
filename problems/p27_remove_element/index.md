---
id: 27
title: "Remove Element"
difficulty: Easy
tags: [array, two-pointers]
date: 2025-12-01
link: https://leetcode.com/problems/remove-element
---

## Problem

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
// It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

## Approach

This problem can be solved using an in-place array partitioning approach with two pointers.
The key observation is that the problem does not require preserving the order of elements. This allows unwanted elements (equal to `val`) to be moved to the end of the array freely.

We use two pointers:

* `left` starts from the beginning of the array and scans forward.
* `right` represents the boundary of valid elements and starts at the array length.

Invariant maintained during execution:

* Elements in the range `[0, left)` do not equal `val`
* Elements in the range `[right, n)` are equal to `val`
* Elements in the range `[left, right)` are unprocessed

Algorithm steps:

* If `nums[left]` equals `val`, replace it with `nums[right - 1]` and decrement `right`.
  The `left` pointer is not incremented because the swapped value still needs to be checked.
* If `nums[left]` does not equal `val`, increment `left`.
* Continue until `left` equals `right`.

When the loop finishes, `right` represents the number of elements that are not equal to `val`, which is returned as the result.

## Complexity

* **Time:** O(n)
  Each element is examined at most once. Both pointers move monotonically toward each other.

* **Space:** O(1)
  The array is modified in place using only constant extra space.
