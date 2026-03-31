---
id: 201
title: "Bitwise And Of Numbers Range"
difficulty: Medium
tags: [bit-manipulation, algorithm, brian-kernighans-algorithm]
date: 2026-03-31
link: https://leetcode.com/problems/bitwise-and-of-numbers-range
---

## Problem

Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.



Example 1:

Input: left = 5, right = 7
Output: 4
Example 2:

Input: left = 0, right = 0
Output: 0
Example 3:

Input: left = 1, right = 2147483647
Output: 0


Constraints:

0 <= left <= right <= 231 - 1


## Approach

**Pattern used:** Bit Manipulation (Common Prefix)

### Core Idea

You need the bitwise AND of all numbers in the range [left, right].

Key observation:

* As numbers increase, **lower bits keep flipping**
* Any bit that flips at least once in the range becomes **0 in AND**

So the result is simply:
👉 **the common left-most prefix of left and right**

---

### Step-by-step

1. **Right shift both numbers until they are equal**

    * This removes differing lower bits
    * Count how many shifts you perform

2. **Why this works**

    * When left < right, at least one bit differs
    * That differing bit (and all lower bits) will eventually flip in the range → become 0 in AND

3. **Stop when left == right**

    * Now you’ve found the **common prefix**

4. **Restore shifted bits**

    * Left shift back by the number of shifts
    * This appends zeros to the right

---

### Example

left = 5  → 101
right = 7 → 111

Process:

* Shift → 10, 11
* Shift → 1, 1 (equal)

Common prefix = 1
Shift back → 100 = 4

---

### Key Insights

* You are effectively **removing unstable bits**
* Only **stable (common) prefix bits survive**
* Much faster than iterating through all numbers

---

### Edge Cases

* left == right → return left directly
* left = 0 → result always 0
* Large ranges → quickly collapse to 0

---

## Complexity

**Time Complexity:** O(log n)

* At most 32 shifts for integers

---

**Space Complexity:** O(1)

* No extra space used

---

## Optimization / Alternative

### Using Brian Kernighan’s Trick

Instead of shifting both:

* Keep removing the **rightmost set bit** from `right` until right ≤ left

Example logic:
right = right & (right - 1)

This also converges to the common prefix.

---

**Q1:** Why do all bits after the first differing bit become 0 in the final answer?
**Q2:** Can you visualize this problem using a binary tree of numbers?
**Q3:** How would this change for 64-bit integers or very large ranges?
