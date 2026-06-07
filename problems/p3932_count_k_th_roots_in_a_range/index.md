---
id: 3932
title: "Count K-th Roots in a Range"
difficulty: Medium
tags: [math, tricky]
date: 2026-06-07
link: https://leetcode.com/problems/count-k-th-roots-in-a-range
---

## Problem

You are given three integers l, r, and k.

An integer y is said to be a perfect kth power if there exists an integer x such that y = xk.

Return the number of integers y in the range [l, r] (inclusive) that are perfect kth powers.



Example 1:


Input: l = 1, r = 9, k = 3


Output: 2


Explanation:

The perfect cubes in the range [1, 9] are:

1 = 13
8 = 23
Hence, the answer is 2.

Example 2:


Input: l = 8, r = 30, k = 2

Output: 3


Explanation:


The perfect squares in the range [8, 30] are:
9 = 32
16 = 42
25 = 52
Hence, the answer is 3.


Constraints:

0 <= l <= r <= 109
1 <= k <= 30

# Approach

**Pattern used:** Mathematical Observation

### Core Idea

Instead of checking every number in the range `[l, r]`, count how many integers `x` produce a value `x^k` that lies within the range.

We need:

l ≤ x^k ≤ r

Taking the kth root of all sides:

kthRoot(l) ≤ x ≤ kthRoot(r)

Therefore, the problem reduces to counting how many integer values of `x` lie between:

* `ceil(l^(1/k))`
* `floor(r^(1/k))`

Every such integer `x` corresponds to exactly one perfect kth power `x^k` inside the range.

### Step-by-Step

1. Compute the smallest valid base:

   lRoot = ceil(l^(1/k))

2. Compute the largest valid base:

   rRoot = floor(r^(1/k))

3. The valid bases are:

   lRoot, lRoot + 1, ..., rRoot

4. Count them:

   rRoot - lRoot + 1

5. If the range is invalid (`lRoot > rRoot`), return `0`.

### Why the Epsilon is Needed

Floating-point calculations can introduce tiny precision errors.

Example:

Instead of:

64^(1/3) = 4

Java might compute:

3.9999999999999996

Without adjustment:

floor(3.9999999999999996) = 3

which is incorrect.

Adding/subtracting a tiny epsilon (`1e-10`) helps avoid these rounding issues.

### Key Insight

The perfect kth powers in the range are exactly:

x^k where

ceil(l^(1/k)) ≤ x ≤ floor(r^(1/k))

So we count valid bases rather than checking every number in `[l, r]`.

### Edge Cases

* No perfect kth powers in the range → return 0
* Single perfect kth power in the range
* `l = r`
* Very large values where floating-point precision may matter
* Range beginning or ending exactly at a perfect kth power


# Complexity

**Time Complexity:** O(1)

* Only a few mathematical operations are performed.

**Space Complexity:** O(1)

* No extra data structures are used.
