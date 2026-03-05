---
id: 70
title: "Climbing Stairs"
difficulty: Easy
tags: [math, fibonacci, dynamic-programming]
date: 2026-03-04
link: https://leetcode.com/problems/climbing-stairs
---

## Problem

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
   Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Constraints:

1 <= n <= 45


## Approach

This problem asks for the number of distinct ways to reach the top of a staircase with `n` steps, where at each step you can climb either **1 step or 2 steps**.

### Key Insight

To reach step `n`, there are only two possibilities:

- You came from step `n - 1` (by taking 1 step).
- You came from step `n - 2` (by taking 2 steps).

So the recurrence becomes:

ways(n) = ways(n - 1) + ways(n - 2)

This is exactly the same recurrence as the **Fibonacci sequence**.

### Implementation Idea

Instead of storing the entire DP array, we only keep track of the last two results:

- `first` → ways to reach the previous step
- `second` → ways to reach the step before that

Steps:

1. Handle base cases:
   - If `n ≤ 2`, return `n`.

2. Initialize:
   - `first = 2` (ways to reach step 2)
   - `second = 1` (ways to reach step 1)

3. Iterate from step `3` to `n`:
   - Compute `sum = first + second`
   - Shift the window:
     - `second = first`
     - `first = sum`

4. After the loop, `first` contains the number of ways to reach step `n`.

This approach optimizes the Fibonacci calculation by using **constant space**.

---

## Complexity

### Time Complexity
O(n)

We iterate once from `3` to `n`.

### Space Complexity
O(1)

Only two variables are used to store previous results.


