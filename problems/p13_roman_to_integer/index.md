---
id: 13
title: "Roman to Integer"
difficulty: Easy
tags: [string, hash-table, math]
date: 2025-12-06
link: https://leetcode.com/problems/roman-to-integer
---

## Problem

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

## Approach

This problem is solved using a **left-to-right scan with value comparison**.

Roman numerals follow two rules:

* Normally, symbols are added from left to right.
* If a smaller-value symbol appears before a larger-value symbol, it represents subtraction.

We map each Roman symbol to its integer value and process the string one character at a time.

Invariant maintained during iteration:

* `total` represents the correct integer value of all characters processed so far.
* At each position, the current symbol contributes either positively or negatively based on the next symbol.

Algorithm steps:

* Create a mapping from Roman characters to their integer values.
* Iterate through the string from left to right.
* For the current character:

    * If its value is less than the value of the next character, subtract it from `total`.
    * Otherwise, add it to `total`.
* Continue until all characters are processed.

This works because every subtractive pair (e.g., IV, IX, XL) is handled by subtracting the smaller value once and adding the larger value later.

## Complexity

* **Time:** O(n)
  The string is traversed once, where n is the length of the Roman numeral.

* **Space:** O(1)
  The map contains a fixed number of Roman symbols and does not grow with input size.

