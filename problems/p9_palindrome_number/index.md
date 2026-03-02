---
id: 9
title: "Palindrome Number"
difficulty: Easy
tags: [math]
date: 2026-03-01
link: https://leetcode.com/problems/palindrome-number
---

## Problem

Given an integer x, return true if x is a palindrome, and false otherwise.



Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


Constraints:

-231 <= x <= 231 - 1


Follow up: Could you solve it without converting the integer to a string?

## Approach

We determine whether an integer is a palindrome **without reversing the entire number**.

### 1️⃣ Early Rejections

- If `x < 0` → return `false`  
  Negative numbers cannot be palindromes because of the leading `-`.

- If `x % 10 == 0 && x != 0` → return `false`  
  Numbers ending in `0` (except `0` itself) cannot be palindromes.
  Example: `10 → 01` (leading zero disappears).

---

### 2️⃣ Reverse Only Half

Instead of reversing the full number (which may overflow),  
we reverse digits until we've processed half of them.

We maintain:

- `x` → remaining left half
- `reversedHalf` → reversed right half

Each iteration:
1. Extract last digit → `x % 10`
2. Append to `reversedHalf`
3. Remove last digit from `x`

We stop when:
x <= reversedHalf

This guarantees we've processed half the digits.

---

### 3️⃣ Final Comparison

Two cases:

- **Even number of digits**
  x == reversedHalf
  Example: `12321`
  We drop the middle digit using `/ 10`.

---

## Why This Works

A palindrome mirrors around its center.

By reversing only half, we compare:
- Left half
- Reversed right half

If they match → it's a palindrome.

This avoids:
- Full reversal
- Integer overflow

---

## Complexity

Time: **O(log n)**  
We process half the digits.  
Number of digits ≈ log₁₀(n).

Space: **O(1)**  
Only constant extra variables are used.