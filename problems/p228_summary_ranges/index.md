---
id: 228
title: "Summary Ranges"
difficulty: Easy
tags: [array, intervals]
date: 2026-02-17
link: https://leetcode.com/problems/summary-ranges
---

## Problem
You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b


Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"


Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.
nums is sorted in ascending order.

## Approach

The array is sorted and contains distinct integers.

We iterate through the array and group consecutive numbers into ranges.

1. If the array is empty, return an empty list.
2. Use a variable `previousNum` to mark the start of the current range.
3. Traverse the array starting from index 1.
4. If the difference between the current number and the previous number
   is greater than 1, the current range ends:
    - If the range contains only one number,
      add it as a single value.
    - Otherwise, add it in the format "start->end".
5. Update `previousNum` to begin a new range.
6. After the loop, handle the final range separately.

The `(long)` cast prevents integer overflow when calculating
`nums[i] - nums[i - 1]`.


## Complexity

Time: O(n)
We iterate through the array once.

Space: O(1) auxiliary space
(ignoring the output list, which in the worst case can contain O(n) elements).


