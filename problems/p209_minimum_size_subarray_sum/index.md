---
id: 209
title: "Minimum Size Subarray Sum"
difficulty: Medium
tags: [array, sliding-window]
date: 2026-03-06
link: https://leetcode.com/problems/minimum-size-subarray-sum
---

## Problem

Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).

## Approach

The goal is to find the **minimum length of a contiguous subarray** whose sum is **greater than or equal to `target`**.

### Key Idea: Sliding Window

Since all numbers in the array are **positive**, we can use the **sliding window technique** to efficiently maintain a subarray whose sum we track dynamically.

### Step-by-step reasoning

1. Initialize:
   - `left = 0`
   - `right = 0`
   - `sum = nums[0]`
   - `minLength = Integer.MAX_VALUE`

2. Expand the window:
   - Move `right` forward and add elements to `sum`.

3. When `sum >= target`:
   - Update the minimum length:
     
     minLength = min(minLength, right - left + 1)

   - Then **shrink the window from the left** to try finding a smaller valid subarray:
     - Subtract `nums[left]`
     - Increment `left`

4. Continue expanding and shrinking the window until `right` reaches the end of the array.

5. Special optimization:
   - If `minLength` becomes `1`, we can immediately return since no smaller subarray is possible.

6. If no valid subarray is found:
   - `minLength` remains `Integer.MAX_VALUE`
   - Return `0`.

### Why Sliding Window Works

Because all numbers are **positive**, increasing the window always increases the sum, and shrinking it always decreases the sum. This guarantees we don't miss any valid subarray.

---

## Complexity

### Time Complexity
O(n)

Each element is visited at most **twice**:
- once when expanding `right`
- once when shrinking `left`

So the total operations remain linear.

### Space Complexity
O(1)

Only a few variables are used regardless of input size.



