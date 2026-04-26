---
id: 50
title: "Pow(x, n)"
difficulty: Medium
tags: [math, divide-and-conquer, recursion]
date: 2026-04-26
link: https://leetcode.com/problems/powx-n
---

## Problem

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104

## Approach

**Pattern used:** Divide & Conquer (Binary Exponentiation)

### Core Idea

Instead of multiplying `x` repeatedly `n` times, reduce the problem size by half each time:

* If `n` is even:
  ( x^n = (x^{n/2})^2 )

* If `n` is odd:
  ( x^n = x \cdot (x^{n/2})^2 )

This gives logarithmic recursion depth.

---

### Step-by-step

1. Handle base cases:

    * `n == 0` → return 1
    * `x == 0` → return 0

2. Recursively compute:

    * `half = recursion(x, n / 2)`

3. Square the result:

    * `half * half`

4. If `n` is odd:

    * multiply one extra `x`

5. Handle negative exponent:

    * ( x^{-n} = 1 / x^n )

---

### Key Insights

* Reduces time from O(n) → O(log n)
* Squaring avoids repeated multiplications
* Handling `Integer.MIN_VALUE` requires `long`

---

### Edge Cases

* `x = 0`, `n > 0` → 0
* `n = 0` → 1
* `n < 0` → reciprocal
* Large negative exponent → must avoid overflow

---

## Complexity

**Time Complexity:** O(log n)

* Each step halves `n`

**Space Complexity:** O(log n)

* Recursion stack depth

---

## Optimization

You can convert to iterative (removes recursion stack):

* Use bit manipulation
* Same logic, constant space

---

**Q1:** How would you convert this into an iterative solution using bit manipulation?
**Q2:** Why does `Integer.MIN_VALUE` cause overflow with `Math.abs()`?
**Q3:** Can this be extended to compute matrix exponentiation efficiently?



