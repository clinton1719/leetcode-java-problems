---
id: 67
title: "Add Binary"
difficulty: Easy
tags: [math, string, bit-manipulation]
date: 2026-02-22
link: https://leetcode.com/problems/add-binary
---

## Problem

Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

## Approach

We simulate binary addition from right to left,
just like manual addition.

Algorithm:

1. Initialize two pointers:
   i → end of string a
   j → end of string b
2. Maintain a variable `carry`.
3. While either string still has digits:
    - Start with sum = carry.
    - If i is valid, add (a.charAt(i) - '0').
    - If j is valid, add (b.charAt(j) - '0').
    - Append (sum % 2) to the result.
    - Update carry = sum / 2.
    - Move both pointers left.
4. After the loop, if carry remains, append it.
5. Reverse the result (since we built it backwards).

This directly mimics binary addition rules.

## Complexity

Time: O(max(n, m))
We iterate once over the longer string.

Space: O(max(n, m))
The result string stores at most max(n, m) + 1 characters.

