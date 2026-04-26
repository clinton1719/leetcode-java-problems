---
id: 3908
title: "Valid Digit Number"
difficulty: Easy
tags: [math]
date: 2026-04-26
link: https://leetcode.com/problems/valid-digit-number
---

## Problem

You are given an integer n and a digit x.

A number is considered valid if:

It contains at least one occurrence of digit x, and
It does not start with digit x.
Return true if n is valid, otherwise return false.



Example 1:

Input: n = 101, x = 0

Output: true

Explanation:

The number contains digit 0 at index 1. It does not start with 0, so it satisfies both conditions. Thus, the answer is true​​​​​​​.

Example 2:

Input: n = 232, x = 2

Output: false

Explanation:

The number starts with 2, which violates the condition. Thus, the answer is false.

Example 3:

Input: n = 5, x = 1

Output: false

Explanation:

The number does not contain digit 1. Thus, the answer is false.



Constraints:

0 <= n <= 105​​​​​​​
0 <= x <= 9

## Approach

**Pattern used:** Digit Extraction (Math Simulation)

### Core Idea

Validate two independent conditions:

1. The number contains digit `x` at least once
2. The **first digit** is NOT `x`

---

### Step-by-step

1. **Traverse digits from right to left**

* Use `% 10` to extract last digit
* Use `/ 10` to remove last digit

---

2. **Track occurrence**

* If any digit equals `x` → `foundX = true`

---

3. **Track first digit**

* During traversal, keep updating:
  `firstDigit = rem`
* After loop ends:
  👉 `firstDigit` holds the **most significant digit**

---

4. **Final condition**

Return:

* `foundX && firstDigit != x`

---

### Why this works

* Loop processes digits in reverse order
* The **last assigned remainder** is the **first digit**
* Clean separation of:

  * presence check
  * leading digit constraint

---

### Example

n = 1234, x = 2

Digits processed: 4 → 3 → 2 → 1

* foundX = true
* firstDigit = 1

Result → true

---

n = 2123, x = 2

* foundX = true
* firstDigit = 2

Result → false

---

### Key Insights

* No string conversion needed
* Constant space solution
* Efficient digit traversal

---

### Edge Cases

* Single digit:

  * n == x → false
* No occurrence of x → false
* Leading digit == x → false

---

## Complexity

**Time Complexity:** O(d)

* d = number of digits

---

**Space Complexity:** O(1)

---

**Q1:** Why is it safe to rely on the last remainder as the first digit?
**Q2:** How would you handle this if negative numbers were allowed?
**Q3:** Can you compute the first digit in O(1) using logarithms?
