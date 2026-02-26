---
id: 190
title: "Add Binary"
difficulty: Easy
tags: [bit-manipulation]
date: 2026-02-26
link: https://leetcode.com/problems/reverse-bits
---

## Problem

Reverse bits of a given 32 bits signed integer.


Example 1:

Input: n = 43261596

Output: 964176192

Explanation:

Integer	Binary
43261596	00000010100101000001111010011100
964176192	00111001011110000010100101000000
Example 2:

Input: n = 2147483644

Output: 1073741822

Explanation:

Integer	Binary
2147483644	01111111111111111111111111111100
1073741822	00111111111111111111111111111110


Constraints:

0 <= n <= 231 - 2
n is even.


Follow up: If this function is called many times, how would you optimize it?

## Approach

We reverse the 32 bits of an integer by processing one bit at a time.

Key Idea:
At each step:
- Extract the least significant bit (LSB) from `n`.
- Shift `result` left to make room.
- Append the extracted bit to `result`.

Algorithm:

1. Initialize `result = 0`.
2. Repeat 32 times (since an integer has 32 bits):
   - Left shift `result` by 1.
   - Extract last bit of `n` using:
     (n & 1)
   - If it is 1, increment `result`.
   - Right shift `n` by 1.
3. Return `result`.

This builds the reversed bit pattern from left to right.

">>>" is logical right shift (fills with 0).
">>" is arithmetic right shift (keeps sign bit).

## Complexity
Time: O(1)
Always runs exactly 32 iterations.

Space: O(1)
Only uses a few integer variables.

