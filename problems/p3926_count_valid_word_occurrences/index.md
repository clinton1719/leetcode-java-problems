---
id: 3926
title: "Count Valid Word Occurrences"
difficulty: Medium
tags: [string, hash-table]
date: 2026-05-10
link: https://leetcode.com/problems/count-valid-word-occurrences
---

## Problem

You are given an array of strings chunks. The strings are concatenated in order to form a single string s.

You are also given an array of strings queries.

A word is defined as a substring of s that:

consists of lowercase English letters ('a' to 'z'),
may include hyphens ('-') only if each hyphen is surrounded by lowercase English letters, and
is not part of a longer substring that also satisfies the above conditions.
Any character that is not a lowercase English letter or a valid hyphen acts as a separator.

Return an integer array ans such that ans[i] is the number of occurrences of queries[i] as a word in s.

A substring is a contiguous non-empty sequence of characters within a string.



Example 1:

Input: chunks = ["hello wor","ld hello"], queries = ["hello","world","wor"]

Output: [2,1,0]

Explanation:

Concatenating all strings in chunks gives s = "hello world hello".
The valid words in s are "hello" which appears twice and "world" which appears once.
Thus, the ans = [2, 1, 0].
Example 2:

Input: chunks = ["a--b a-","-c"], queries = ["a","b","c"]

Output: [2,1,1]

Explanation:

Concatenating all strings in chunks gives s = "a--b a--c".
The valid words in s are "a" which appears twice, "b" which appears once, and "c" which appears once.
Thus, the ans = [2, 1, 1].
Example 3:

Input: chunks = ["hello"], queries = ["hello","ell"]

Output: [1,0]

Explanation:

The valid word in s is "hello" which appears once.
Thus, the ans = [1, 0].


Constraints:

1 <= chunks.length <= 105
1 <= chunks[i].length <= 105​​​​​​​
chunks[i] may consist of lowercase English letters, spaces, and hyphens.
The total length of all strings in chunks does not exceed 105
1 <= queries.length <= 105
1 <= queries[i].length <= 105​​​​​​​
queries[i] is a valid word
The total length of all strings in queries does not exceed 105



## Approach

**Pattern used:** Regex Parsing + Frequency Counting

---

### Core Idea

1. Concatenate all chunks into one string
2. Extract all valid words using regex
3. Count frequencies using a hashmap
4. Answer each query in O(1)

---

### Step-by-step

### 1. Build the full string

All chunks together form the original string `s`.

Example:

* `["hello wor", "ld hello"]`
  → `"hello world hello"`

---

### 2. Extract valid words using regex

Regex used:

[a-z]+(-[a-z]+)*

This means:

* Starts with lowercase letters
* Can contain hyphen groups
* Every hyphen must be surrounded by letters

So:

* `"hello"` ✅
* `"a-b"` ✅
* `"a--b"` ❌
* `"-abc"` ❌
* `"abc-"` ❌

---

### 3. Count occurrences

For every regex match:

* Increment frequency in hashmap

---

### 4. Resolve queries

For each query:

* Return frequency from map
* Default to 0 if absent

---

### Why the Regex Works

[a-z]+

* Matches initial word portion

(-[a-z]+)*

* Allows:

    * `-abc`
    * `-xyz`
* repeated zero or more times

This guarantees:

* Hyphens only appear between valid lowercase sequences

---

### Key Insights

* Regex naturally handles separators
* Invalid hyphen placements automatically split words

Example:
"a--b"

Matches:

* `"a"`
* `"b"`

because `"--"` breaks validity

---

### Edge Cases

* Multiple spaces → handled
* Consecutive hyphens → handled
* Query not present → returns 0
* Single-letter words → valid

---

## Complexity

**Time Complexity:** O(N + Q)

Where:

* N = total length of chunks
* Q = total length of queries

Regex traversal and hashmap operations are linear overall.

---

**Space Complexity:** O(W)

* W = number of distinct words

---

## Optimization Insight

Your solution is already optimal for given constraints.

Alternative manual parsing:

* Character-by-character tokenizer
* Avoids regex overhead
* But regex is cleaner and sufficiently efficient here

---

## Final Take

* Clean and elegant use of regex
* Correct handling of hyphen rules
* Efficient query answering using hashmap frequencies

---

**Q1:** How would you implement the parser manually without regex?
**Q2:** Why does `"a--b"` become two separate valid words instead of one invalid word?
**Q3:** How would the regex change if uppercase letters were also allowed?



