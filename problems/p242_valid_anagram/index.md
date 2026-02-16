---
id: 242
title: "Valid Anagram"
difficulty: Easy
tags: [hash-table, string]
date: 2026-02-16
link: https://leetcode.com/problems/valid-anagram
---

## Problem
Given two strings s and t, return true if t is an anagram of s, and false otherwise.



Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false



Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

## Approach

This solution uses a frequency counting approach with a fixed-size array for lowercase English letters.

First, we iterate through string `s` and increment the count of each character in a 26-length array.
We also track the total number of characters using a counter.

Then, we iterate through string `t` and decrement the corresponding character counts.
If at any point a character count becomes negative, it means `t` contains more occurrences of a character than `s`, so the strings cannot be anagrams.

Simultaneously, we decrement the overall counter.
At the end, if the counter reaches zero, both strings contain exactly the same characters with the same frequencies, confirming they are anagrams.

## Complexity

* **Time:** O(n)
* **Space:** O(1)

