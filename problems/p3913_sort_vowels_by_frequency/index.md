---
id: 3913
title: "Sort Vowels by Frequency"
difficulty: Medium
tags: [sorting, hash-table]
date: 2026-04-26
link: https://leetcode.com/problems/sort-vowels-by-frequency
---

## Problem

You are given a string s consisting of lowercase English characters.

Rearrange only the vowels in the string so that they appear in non-increasing order of their frequency.

If multiple vowels have the same frequency, order them by the position of their first occurrence in s.

Return the modified string.

Vowels are 'a', 'e', 'i', 'o', and 'u'.

The frequency of a letter is the number of times it occurs in the string.



Example 1:

Input: s = "leetcode"

Output: "leetcedo"

Explanation:​​​​​​​

Vowels in the string are ['e', 'e', 'o', 'e'] with frequencies: e = 3, o = 1.
Sorting in non-increasing order of frequency and placing them back into the vowel positions results in "leetcedo".
Example 2:

Input: s = "aeiaaioooa"

Output: "aaaaoooiie"

Explanation:​​​​​​​

Vowels in the string are ['a', 'e', 'i', 'a', 'a', 'i', 'o', 'o', 'o', 'a'] with frequencies: a = 4, o = 3, i = 2, e = 1.
Sorting them in non-increasing order of frequency and placing them back into the vowel positions results in "aaaaoooiie".
Example 3:

Input: s = "baeiou"

Output: "baeiou"

Explanation:

Each vowel appears exactly once, so all have the same frequency.
Thus, they retain their relative order based on first occurrence, and the string remains unchanged.


Constraints:

1 <= s.length <= 105
s consists of lowercase English letters


## Approach

**Pattern used:** Frequency Count + Sorting + Greedy Reconstruction

### Core Idea

* Only vowels need rearrangement
* Extract vowel positions and count frequencies
* Sort unique vowels by:

    1. Frequency (descending)
    2. First occurrence (ascending)
* Expand sorted vowels and place them back into original positions

---

### Step-by-step

1. Traverse string:

    * Track indices of vowels
    * Build `freqMap`
    * Track first occurrence using `orderMap`

2. Sort unique vowels:

    * Higher frequency first
    * If equal → earlier occurrence first

3. Expand sorted vowels:

    * Repeat each vowel based on its frequency

4. Place back:

    * Replace characters at vowel positions sequentially

---

### Key Insight

* Since vowel set size ≤ 5, sorting is constant time
* This avoids unnecessary heap complexity
* Greedy placement works because order is already globally decided

---

### Edge Cases

* No vowels → return original string
* All vowels same → no change
* All frequencies equal → preserves original relative order

---

## Complexity

**Time Complexity:** O(n)

* One pass to collect
* One pass to rebuild
* Sorting ≤ 5 elements → O(1)

---

**Space Complexity:** O(n)

* Stores vowel positions and rebuilt sequence

---

**Q1:** Can you eliminate the extra list used for expanded vowels and fill directly?
**Q2:** How would the approach change if all characters (not just vowels) were allowed?
**Q3:** What modification is needed if tie-breaker becomes last occurrence instead of first?
