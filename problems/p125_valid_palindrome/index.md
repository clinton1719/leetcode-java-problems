---
id: 125
title: "valid-palindrome"
difficulty: Easy
tags: [two-pointers, string]
date: 2026-02-10
link: https://leetcode.com/problems/valid-palindrome
---

## Problem
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

## Approach

This solution uses a two-pointer technique to check whether the string is a palindrome while ignoring non-alphanumeric characters.
The string is first converted to lowercase to ensure case-insensitive comparison.

Two pointers, `left` and `right`, start from the beginning and end of the string respectively.
Each pointer moves inward while skipping characters that are not alphanumeric.
When both pointers point to valid characters, their values are compared.
If they differ, the string is not a palindrome.
If they match, both pointers move inward and the process continues until they meet or cross.

If no mismatches are found, the string is a valid palindrome.

## Complexity

* **Time:** O(n)
* **Space:** O(1)
