---
id: 35
title: "Search Insert Position"
difficulty: Easy
tags: [array, binary-search]
date: 2026-03-05
link: https://leetcode.com/problems/search-insert-position
---

## Problem

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104


```md
## Approach

The goal is to find the index where `target` exists in a **sorted array**, or the position where it should be inserted to maintain sorted order.

### Key Idea: Binary Search

Since the array is sorted, we can efficiently locate the position using **binary search** instead of scanning linearly.

### Step-by-step reasoning

1. Initialize two pointers:
   - `left = 0`
   - `right = nums.length - 1`

2. While `left < right`:
   - Compute the middle index:
     
     middle = left + (right - left) / 2
     
   - Compare `nums[middle]` with `target`.

3. Three cases:
   - If `nums[middle] == target`
     - The element exists → return `middle`.

   - If `nums[middle] < target`
     - The target must be in the **right half**.
     - Move `left` to `middle + 1`.

   - If `nums[middle] > target`
     - The target must be in the **left half**.
     - Move `right` to `middle - 1`.

4. When the loop ends, `left` points to the smallest index where the target could be placed.

5. Final check:
   - If `nums[left] >= target`, return `left`.
   - Otherwise return `left + 1` because the target should be inserted after it.

### Key Insight

Binary search narrows the search range until only one possible position remains.  
The final conditional determines whether the target belongs **at `left` or just after it**.

---

## Complexity

### Time Complexity
O(log n)

Binary search halves the search space each iteration.

### Space Complexity
O(1)

Only a few variables are used regardless of input size.
```



