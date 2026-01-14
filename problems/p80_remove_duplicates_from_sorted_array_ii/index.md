---
id: 80
title: "Remove Duplicates from Sorted Array II"
difficulty: Medium
tags: [array, two-pointers]
date: 2026-01-14
link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
---

## Problem

Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

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



Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

## Approach

This solution uses an **in-place two-pointer technique** that leverages the fact that the input array is **sorted in non-decreasing order**.

The goal is to allow **at most two occurrences** of each element while modifying the array in place.

We maintain two pointers:

* `i` is the write pointer that tracks the length of the valid prefix.
* `j` is the read pointer that scans through the array.

Key insight:

* Since the array is sorted, allowing at most two duplicates means that any element equal to the one at position `i - 2` would create more than two occurrences.
* Therefore, we only keep `nums[j]` if it is **strictly greater than** `nums[i - 2]`.

Invariant maintained during iteration:

* Elements in the range `[0, i)` satisfy the condition that no number appears more than twice.
* Index `j` scans the array from left to right.

Algorithm steps:

* If the array length is less than or equal to 2, return the length immediately.
* Initialize `i = 2`, since the first two elements are always valid.
* Iterate `j` from index 2 to the end of the array:

    * If `nums[j] > nums[i - 2]`, write `nums[j]` to index `i` and increment `i`.
* After the loop, return `i` as the new length.

This approach is efficient, concise, and avoids any extra data structures.

## Complexity

* **Time:** O(n)
  Each element is processed exactly once.

* **Space:** O(1)
  The array is modified in place using constant extra space.


