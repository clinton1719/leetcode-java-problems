---
id: 383
title: "Ransom Note"
difficulty: Easy
tags: [counting, hash-table, string]
date: 2026-02-13
link: https://leetcode.com/problems/ransom-note
---

## Problem
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true


Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.

## Approach

This solution uses a frequency counting technique to determine whether the ransom note can be constructed from the magazine.

First, an array of size 26 is used to count how many times each character appears in the ransom note.
Then, we iterate through the magazine and decrement the corresponding count for each character.
If a character from the magazine was needed (its count was positive before decrementing), we reduce the remaining character requirement.

We keep track of how many characters from the ransom note are still needed.
As soon as this count reaches zero, we return true.
If the magazine is fully processed and some characters are still needed, we return false.

Since the alphabet size is fixed (26 lowercase letters), the extra space remains constant.

## Complexity

* **Time:** O(n + m)
* **Space:** O(1)

