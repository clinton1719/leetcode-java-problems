---
id: 167
title: "Two Sum II Input Array Is Sorted"
difficulty: Medium
tags: [array, two-pointers, binary-search]
date: 2026-03-13
link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
---

## Problem

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.



Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].


Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.


## Approach

The array is **sorted in non-decreasing order**, which allows an efficient solution using the **two-pointer technique**.

### Key Idea

Use two pointers:

- `left` starting at the **beginning** of the array
- `right` starting at the **end** of the array

The sum of these two values determines how the pointers move.

---

### Step-by-step reasoning

1. Initialize:

left = 0  
right = numbers.length - 1

2. While `left < right`:

- Compute the sum:

sum = numbers[left] + numbers[right]

3. Compare the sum with `target`:

- If `sum == target`  
  We found the required pair.  
  Return their **1-based indices**:

[left + 1, right + 1]

- If `sum > target`  
  The sum is too large, so decrease it by moving:

right--

- If `sum < target`  
  The sum is too small, so increase it by moving:

left++

4. Continue until the pair is found.

---

### Why This Works

Because the array is **sorted**:

- Moving `right` left decreases the sum.
- Moving `left` right increases the sum.

This guarantees that every possible pair is considered efficiently without revisiting combinations.

---

## Complexity

### Time Complexity
O(n)

Each pointer moves at most `n` times.

### Space Complexity
O(1)

No additional data structures are used.



