---
id: 58
title: "Length of Last Word"
difficulty: Easy
tags: [string]
date: 2026-01-10
link: https://leetcode.com/problems/remove-duplicates-from-sorted-array
---

## Problem

Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.



Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.


Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.

## Approach

This problem is solved using a **reverse linear scan** of the string.

The goal is to find the length of the last word, where a word is defined as a maximal substring consisting of non-space characters. Trailing spaces should be ignored.

We scan the string from right to left to avoid extra passes or string splitting.

Invariant maintained during iteration:

* `length` stores the length of the current word being counted from the end.
* Characters to the right of the current index have already been correctly processed.

Algorithm steps:

* Initialize `length` to 0.
* Traverse the string from the last character to the first:

    * If the current character is not a space, increment `length`.
    * If the current character is a space and `length` is greater than 0, the last word has ended; return `length`.
* If the loop finishes, return `length` (handles cases with no trailing spaces).

This approach efficiently skips trailing spaces and stops as soon as the last word is fully counted.

## Complexity

* **Time:** O(n)
  The string is scanned once from right to left.

* **Space:** O(1)
  Only a constant amount of extra space is used.

