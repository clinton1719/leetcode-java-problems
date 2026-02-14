---
id: 205
title: "Isomorphic strings"
difficulty: Easy
tags: [hash-table, string]
date: 2026-02-14
link: https://leetcode.com/problems/isomorphic-strings
---

## Problem
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "f11", t = "b23"

Output: false

Explanation:

The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.

Example 3:

Input: s = "paper", t = "title"

Output: true



Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.

## Approach

First, if the two strings have different lengths, they cannot be isomorphic.

Two integer arrays of size 256 are used to store the last seen positions of characters from each string.
As we iterate through both strings simultaneously, we compare the stored values for the current characters.
If the previously recorded positions do not match, it means the mapping is inconsistent and the strings are not isomorphic.

If they match, we update both arrays with the current index plus one.
Using `i + 1` instead of `i` helps distinguish between characters that have not been seen yet (default value 0) and those seen at index 0.

If the loop completes without conflicts, the strings are isomorphic.

## Complexity

* **Time:** O(n)
* **Space:** O(1)

