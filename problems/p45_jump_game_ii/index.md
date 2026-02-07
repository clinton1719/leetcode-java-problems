---
id: 45
title: "Jump Game II"
difficulty: Medium
tags: [array, dynamic-programming, greedy]
date: 2026-02-07
link: https://leetcode.com/problems/jump-game-ii
---

## Problem
You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].

## Approach

This is a **greedy level-based traversal** solution.

### Core idea
Each jump lets you reach a *range* of indices.  
Within that range, you choose the position that allows you to reach **farthest** in the next jump.

### How it works
- `currentEnd` marks the **end of the current jump range**.
- `farthest` tracks the **maximum index reachable** from the current range.
- Iterate through the array (excluding the last index):
    - Update `farthest = max(farthest, i + nums[i])`
    - When `i` reaches `currentEnd`:
        - You must make a jump
        - Increment `jumps`
        - Set `currentEnd = farthest` (next range)

The loop ends once the last index is guaranteed reachable.

### Why it’s optimal
Each jump expands the reachable boundary as much as possible, ensuring the **minimum number of jumps**.

---

## Complexity

* **Time:** `O(n)`
    - Single pass through the array.

* **Space:** `O(1)`
    - Uses only constant extra variables.

