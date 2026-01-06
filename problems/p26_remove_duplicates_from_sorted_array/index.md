---
id: 26
title: "Remove Duplicates from Sorted Array"
difficulty: Easy
tags: [array, two-pointers]
date: 2025-12-06
link: https://leetcode.com/problems/remove-duplicates-from-sorted-array
---

## Problem

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k​​​​​​​​​​​​​​. After removing duplicates, return the number of unique elements k.

The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

## Approach

This problem can be solved using the **two-pointer technique** (also known as the slow–fast pointer approach).

Since the input array is sorted, all duplicate elements appear consecutively. The goal is to keep only one occurrence of each unique value and return the count of unique elements.

We use two pointers:

* `i` (slow pointer) tracks the position where the next unique element should be placed.
* `j` (fast pointer) scans through the array to find new unique elements.

Invariant maintained during iteration:

* Elements in the range `[0, i)` are unique and sorted.
* Elements in the range `[i, j)` are processed but ignored duplicates.
* Elements in the range `[j, n)` are unprocessed.

Algorithm steps:

* Initialize `i = 1` because the first element is always unique.
* Iterate `j` from index `1` to the end of the array.
* If `nums[j]` is greater than `nums[i - 1]`, it means a new unique element is found.

    * Assign `nums[i] = nums[j]` and increment `i`.
* Continue until all elements are processed.

At the end of the loop, `i` represents the number of unique elements in the array.

## Complexity

* **Time:** O(n)
  Each element is visited exactly once.

* **Space:** O(1)
  The array is modified in place using constant extra space.
