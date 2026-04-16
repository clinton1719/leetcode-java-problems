---
id: 3900
title: "Longest Balanced Substring After One Swap"
difficulty: Medium
tags: [hash-table, string, tricky, prefix-sum]
date: 2026-04-12
link: https://leetcode.com/problems/longest-balanced-substring-after-one-swap
---

## Problem

You are given a binary string s consisting only of characters '0' and '1'.

A string is balanced if it contains an equal number of '0's and '1's.

You can perform at most one swap between any two characters in s. Then, you select a balanced substring from s.

Return an integer representing the maximum length of the balanced substring you can select.



Example 1:

Input: s = "100001"

Output: 4

Explanation:

Swap "100001". The string becomes "101000".

Select the substring "101000", which is balanced because it has two '0's and two '1's.

Example 2:


Input: s = "111"


Output: 0

Explanation:

Choose not to perform any swaps.

Select the empty substring, which is balanced because it has zero '0's and zero '1's.


Constraints:

1 <= s.length <= 105
s consists only of the characters '0' and '1'.


## Approach

**Pattern used:** Prefix Sum + HashMap + “One Fix Allowed” (extended zero-sum idea)

### Core Idea

You convert the string into a numeric form:

* `'1' → +1`
* `'0' → -1`

Now:

* A **balanced substring** ⇒ sum = 0
* With **one swap**, you can fix imbalance of **±2**

So you check:

1. **Exact match (sum = 0)** → no swap needed
2. **Near match (sum = ±2)** → fixable with one swap

---

### Step-by-step

1. **Store all prefix sum indices**

* `mpp: sum → list of indices`
* Initialize:
  `sum 0 → [-1]`

---

2. **Precompute total counts**

* `count0`, `count1`
* Used to verify if swap is feasible

---

3. **Traverse string and build prefix sum**

For each index `i`:

* Update:

    * `'1' → sum++`
    * `'0' → sum--`

---

4. **Case 1: Perfect balance (sum seen before)**

* If same sum exists:
  → subarray is balanced
  → length = `i - firstIndex`

---

5. **Case 2: Fixable imbalance (sum ± 2)**

### Why ±2?

* Swap replaces one `0` with `1` (or vice versa)
* Net effect = **±2 change in sum**

---

6. **Validate swap feasibility**

For each candidate index `j`:

* Length = `i - j`
* Balanced substring after swap must satisfy:

    * half 0s, half 1s

You compute:

* `(len - 2) / 2` → how many of one type already used
* Then check if extra needed exists globally:

    * `count0 > usedZeros`
    * `count1 > usedOnes`

👉 This ensures swap is actually possible

---

7. **Store index**

* Add current index to `mpp[sum]`

---

### Key Insights

* Prefix sum reduces problem to **subarray sum analysis**
* Swap introduces **tolerance of ±2**
* Storing all indices allows exploring multiple candidate substrings

---

### Subtle Details

* Using **list of indices** enables exploring multiple valid ranges
* `(len - 2)/2` is derived from:

    * one swap already accounts for 2 imbalance
* Precomputed counts ensure swap doesn’t use nonexistent elements

---

### Edge Cases

* All same characters → answer = 0
* Already balanced → no swap needed
* Very small strings → may not allow valid swap

---

## Complexity

**Time Complexity:** O(n²) worst case

* For each index:

    * Iterating over lists in map

---

**Space Complexity:** O(n)

* Storing prefix indices

---

**Q1:** Can you eliminate the inner loop and still handle the ±2 condition correctly?
**Q2:** Why is ±2 the only imbalance fixable with one swap?
**Q3:** How would the logic change if you were allowed up to k swaps instead of one?
