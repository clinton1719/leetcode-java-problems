---
id: 15
title: "Longest Common Prefix"
difficulty: Easy
tags: [string, array, trie]
date: 2026-01-12
link: https://leetcode.com/problems/longest-common-prefix
---

## Problem

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".


Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.

## Approach 1

This problem is solved using a **lexicographical sorting observation**.

When all strings are sorted lexicographically, the longest common prefix of the entire array must be the common prefix between the **first** and **last** strings in the sorted order. Any mismatch between these two bounds implies a mismatch somewhere in the array.

Algorithm reasoning:

* After sorting, strings with similar prefixes are grouped together.
* The maximum possible common prefix is constrained by the smallest and largest strings lexicographically.
* Therefore, comparing only the first and last strings is sufficient.

Algorithm steps:

* Handle edge cases: empty array or a single string.
* Sort the array of strings.
* Take the first and last strings from the sorted array.
* Compare characters from left to right until a mismatch occurs or one string ends.
* Return the substring from index 0 to the last matching position.

Invariant maintained during comparison:

* Characters in the range `[0, i)` are equal for both the first and last strings.
* Once a mismatch is found, no longer common prefix can exist for the entire array.

## Complexity 1

* **Time:** O(n log n + m)
  Sorting the array of n strings takes O(n log n). Comparing the first and last strings takes O(m), where m is the length of the shortest string.

* **Space:** O(1) (excluding sorting overhead)
  Only constant extra space is used. Sorting may use additional space depending on the implementation.


## Approach 2

This solution uses **horizontal scanning with prefix reduction**.

The idea is to treat the first string as the initial candidate prefix and progressively shrink it until it is a prefix of every other string in the array.

Algorithm reasoning:

* Any longest common prefix must be a prefix of the first string.
* If the current prefix does not match a string, it must be shortened.
* This process continues until the prefix matches all strings or becomes empty.

Algorithm steps:

* Handle edge cases where the input array is null or empty.
* Initialize `prefix` to the first string.
* For each remaining string:

    * While the current string does not start with `prefix`, shorten `prefix` by one character from the end.
    * If `prefix` becomes empty, return an empty string.
* After all strings are processed, return the remaining `prefix`.

Invariant maintained during iteration:

* `prefix` is always a valid prefix of all strings processed so far.
* Any removed character from `prefix` cannot be part of the longest common prefix

## Complexity 2

* **Time:** O(n · m)
  In the worst case, each string comparison may reduce the prefix character by character. Here, n is the number of strings and m is the length of the shortest string.

* **Space:** O(1)
  Only constant extra space is used. The prefix is modified in place via substring operations.

 

