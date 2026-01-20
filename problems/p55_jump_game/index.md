---
id: 55
title: "Jump Game"
difficulty: Medium
tags: [array, dynamic-programming, greedy]
date: 2026-01-20
link: https://leetcode.com/problems/jump-game
---

## Problem
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105

## Approach

This is a **greedy reachability** solution solved **backwards**.

### Core insight
You do not need to simulate all jumps.  
Instead, track whether each position can eventually reach the end.

### Strategy
- Start from the **last index**, which is trivially reachable.
- Move **backwards** through the array.
- For each index `i`, check:
    - If `i + nums[i] >= lastIndex`, then index `i` can reach the current “good” position.
    - If so, update `lastIndex = i`.

At the end:
- If index `0` becomes the last reachable position, the jump is possible.
- Otherwise, it is not.

This approach works because reachability is **monotonic**: once a position can reach a valid index, it is itself valid.

---

## Complexity

* **Time:** `O(n)`
    - Single backward pass.

* **Space:** `O(1)`
    - Constant extra memory.
