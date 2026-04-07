---
id: 151
title: "Reverse Words in a String"
difficulty: Medium
tags: [two-pointers, string]
date: 2026-04-07
link: https://leetcode.com/problems/reverse-words-in-a-string
---

## Problem

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.


Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?

## Approach

**Pattern used:** Two Pointers + String Reversal

### Core Idea

You want to:

1. Reverse the **order of words**
2. Remove extra spaces

Instead of splitting strings, you:

* Reverse the entire string
* Then reverse each word individually

👉 This restores word order but in reversed sequence

---

### Step-by-step

1. **Trim and convert to char array**

    * Removes leading/trailing spaces
    * Allows in-place operations

---

2. **Reverse entire string**

    * Example:
      "the sky is blue" → "eulb si yks eht"

---

3. **Process words one by one**

Use two pointers:

* `left` → start of word
* `right` → end of word

---

4. **Extract and reverse each word**

For each word:

* Move `right` until space
* Reverse characters from `right-1 → left`
* Append to result

---

5. **Skip spaces**

* Handle multiple spaces between words

---

6. **Clean up**

* Remove trailing space from result

---

### Example

Input:
"  hello   world  "

Process:

* Trim → "hello   world"
* Reverse → "dlrow   olleh"
* Reverse words:
  → "world hello"

---

### Key Insights

* Double reversal technique:
  👉 Reverse whole string + reverse each word
* Avoids using split() → more efficient
* Handles multiple spaces cleanly

---

### Subtle Details

* Skipping spaces is critical to avoid empty words
* `result.append(' ')` adds extra space → removed later
* You build a clean output instead of modifying in-place fully

---

### Edge Cases

* Multiple spaces → handled correctly
* Single word → unchanged
* All spaces → returns empty string
* Trailing/leading spaces → removed via trim()

---

## Complexity

**Time Complexity:** O(n)

* Reverse entire string → O(n)
* Process each character once → O(n)

---

**Space Complexity:** O(n)

* Char array + result string

---

## Optimization

### More Optimal (In-place approach)

You can:

1. Reverse entire char array
2. Reverse each word in-place
3. Clean spaces in-place

👉 Reduces extra space usage

---

### Simpler Approach (Built-in)

* Split by regex `"\\s+"`
* Reverse array
* Join with space

But:

* Uses extra space
* Slightly slower

---

**Q1:** Why does reversing twice give correct word order?
**Q2:** How would you modify this to preserve original spacing between words?
**Q3:** Can you do the entire operation in-place without using StringBuilder?
