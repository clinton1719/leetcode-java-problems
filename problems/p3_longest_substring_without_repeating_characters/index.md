---
id: 3
title: "Longest Substring Without Repeating Characters"
difficulty: Medium
tags: [sliding-window, string, hash-table]
date: 2026-04-17
link: https://leetcode.com/problems/longest-substring-without-repeating-characters
---

## Problem

Given a string s, find the length of the longest substring without duplicate characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

## Approach

**Pattern used:** Sliding Window + HashSet

### Core Idea

You need the **longest substring without repeating characters**.

Use a **sliding window**:

* Expand window using `right`
* Shrink window using `left` when duplicate appears

👉 Maintain a set of **unique characters in current window**

---

### Step-by-step

1. **Initialize**

* `left = 0`
* `charSet` → stores current window characters

---

2. **Expand window (right pointer)**

For each `right`:

* Check if character already exists in set

---

3. **Handle duplicate (key part)**

If duplicate found:

* Shrink window from left:

    * Remove characters until duplicate is gone

while (charSet.contains(s.charAt(right)))
→ remove `s[left]`, move `left++`

---

4. **Add current character**

* Now safe to add (no duplicates)

---

5. **Update max length**

* `right - left + 1`

---

### Example

s = "abcabcbb"

Process:

* "abc" → length 3
* hit duplicate 'a' → shrink window
* continue...

Final answer = 3

---

### Key Insights

* Window always contains **unique characters**
* `while` loop ensures:
  👉 duplicates are fully removed before continuing
* Each character is added and removed at most once

---

### Subtle Detail (Important)

Why **while** and not **if**?

👉 Because:

* Duplicate might not be at `left`
* You must remove multiple characters until duplicate is gone

Example:
"abba"

At second 'b':

* Need to remove both 'a' and first 'b'

---

### Edge Cases

* Empty string → 0
* All same characters → 1
* All unique → length = n

---

## Complexity

**Time Complexity:** O(n)

* Each character visited at most twice

---

**Space Complexity:** O(k)

* k = unique characters (at most 256 or n)

---

## Optimization

### Alternative (Better constant factor)

Use **HashMap (char → last index)**

Instead of removing one-by-one:

* Jump `left` directly:
  `left = max(left, lastIndex + 1)`

👉 Avoids repeated removals

---

**Q1:** Why does each character get processed at most twice in this approach?
**Q2:** How does the HashMap version improve over the HashSet approach?
**Q3:** Can this pattern be extended to allow at most k distinct characters?


