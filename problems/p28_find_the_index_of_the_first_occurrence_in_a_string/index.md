---
id: 28
title: "Find the Index of the First Occurrence in a String"
difficulty: Easy
tags: [two-pointers, string, string-matching, kmp-algorithm, algorithm]
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

## Approach 2

This solution uses the **Knuth–Morris–Pratt (KMP) string matching algorithm**.

Unlike brute-force matching, KMP avoids re-checking characters in the haystack by preprocessing the pattern (`needle`) to build an LPS (Longest Prefix Suffix) array. The LPS array tells us how far we can shift the pattern when a mismatch occurs.

### LPS Array

The LPS array stores, for each position in the pattern, the length of the longest proper prefix that is also a suffix ending at that position.

Invariant while building LPS:

* `lps[i]` is the length of the longest prefix of `needle` that matches a suffix ending at index `i`.
* Characters before index `i` have already been correctly processed.

### Pattern Matching Phase

We scan the haystack and needle simultaneously using two pointers:

* `i` points to the current character in the haystack.
* `j` points to the current character in the needle.

Invariant during matching:

* Characters in `needle[0 .. j)` match characters in `haystack[i - j .. i)`.
* When a mismatch occurs, the LPS array determines the next valid position of `j` without moving `i` backward.

Algorithm steps:

* Precompute the LPS array for the needle.
* Traverse the haystack:

    * If characters match, advance both pointers.
    * If a mismatch occurs:

        * If `j > 0`, update `j` to `lps[j - 1]`.
        * Otherwise, advance `i`.
* If `j` reaches the length of the needle, a match is found; return the starting index.
* If the haystack is fully scanned without a match, return `-1`.

KMP guarantees linear time by ensuring that each character in the haystack is processed at most once.

## Complexity 2

* **Time:** O(n + m)
  Building the LPS array takes O(m), and pattern matching takes O(n), where n is the length of the haystack and m is the length of the needle.

* **Space:** O(m)
  Additional space is used to store the LPS array of the needle.

