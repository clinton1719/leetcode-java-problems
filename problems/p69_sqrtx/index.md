---
id: 69
title: "Sqrt(x)"
difficulty: Easy
tags: [math, binary-search]
date: 2026-03-03
link: https://leetcode.com/problems/sqrtx
---

## Problem

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.


Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.


Constraints:

0 <= x <= 231 - 1

## Approach

This problem computes the integer square root of a non-negative number `x`, meaning we return the largest integer `r` such that `r² ≤ x`.

### Key Idea: Binary Search on Answer Space

Instead of searching in the array, we search in the **range of possible square roots**.

### Step-by-step reasoning:

1. If `x < 2`, return `x` directly (since √0 = 0 and √1 = 1).

2. The square root of `x` must lie between:
    - `1` and `x / 2` (for x ≥ 2).

3. Apply binary search:
    - Compute `mid`
    - Calculate `mid * mid`
    - Compare it with `x`

4. Three cases:
    - If `mid² == x` → return `mid`
    - If `mid² < x` → move right (`left = mid + 1`)
    - If `mid² > x` → move left (`right = mid - 1`)

5. When the loop ends, `right` will be the largest value whose square is ≤ `x`.  
   So we return `right`.

### Important Detail

We cast `mid` to `long` before squaring to prevent integer overflow when `mid * mid` exceeds the range of `int`.

---

## Complexity

### Time Complexity:
O(log x)

Binary search reduces the search space by half each iteration.

### Space Complexity:
O(1)

Only constant extra variables are used.

