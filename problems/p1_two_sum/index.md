---
id: 1
title: "Two Sum"
difficulty: Easy
tags: [hash-table, array]
date: 2026-02-16
link: https://leetcode.com/problems/two-sum
---

## Problem
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.


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



