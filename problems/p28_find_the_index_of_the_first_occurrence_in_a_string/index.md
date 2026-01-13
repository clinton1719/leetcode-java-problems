---
id: 28
title: "Find the Index of the First Occurrence in a String"
difficulty: Easy
tags: [two-pointers, string, string-matching]
date: 2025-01-13
link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
---

## Problem

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.


Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.

## Approach 1

This problem is solved using a **brute-force substring matching strategy** with early termination.

The goal is to find the first index in `haystack` where `needle` occurs as a substring. If `needle` does not occur, return `-1`.

Algorithm reasoning:

* A valid match can only start at positions where there is enough remaining length in `haystack` to fit `needle`.
* For each possible starting index, we compare the substring beginning at that index with `needle`.
* As soon as a match is found, we return the index.

Algorithm steps:

* Compute the lengths of `haystack` and `needle`.
* If `needle` is longer than `haystack`, return `-1` immediately.
* Iterate over possible starting positions `i` in `haystack`:

    * If `i + needleLength` exceeds `haystackLength`, no further matches are possible; return `-1`.
    * If the first characters match, check whether `haystack` starts with `needle` at index `i`.
    * If it does, return `i`.
* If no match is found after the loop, return `-1`.

Invariant maintained during iteration:

* All starting indices before `i` have been checked and do not produce a match.
* Only valid starting positions where `needle` can fully fit are considered.

## Complexity 2

* **Time:** O(n · m)
  In the worst case, for each position in `haystack` (n), a comparison of up to `needle` length (m) may occur.

* **Space:** O(1)
  No additional data structures are used beyond constant extra variables.

