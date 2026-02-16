---
id: 202
title: "Happy Number"
difficulty: Easy
tags: [hash-table, algorithm, floyds-cycle-finding-algorithm]
date: 2026-02-16
link: https://leetcode.com/problems/happy-number
---

## Problem

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false


Constraints:

1 <= n <= 231 - 1

## Approach

This solution uses **Floyd’s Cycle Detection Algorithm (Tortoise and Hare)** to determine whether a number is happy.

A happy number is defined by repeatedly replacing the number with the sum of the squares of its digits:

    n → f(n) → f(f(n)) → ...

If the sequence reaches **1**, the number is happy.
If the sequence enters a cycle that does not include 1, the number is not happy.

To detect a cycle efficiently without extra space:

- `slow` moves one step at a time:
  slow = f(slow)

- `fast` moves two steps at a time:
  fast = f(f(fast))

There are two possible outcomes:

1. If `fast == 1`, the sequence reaches 1 → the number is happy.
2. If `slow == fast`, a cycle is detected → the number is not happy.

This avoids using additional memory like a HashSet and works in constant space.

---

## Complexity

* **Time:** O(log n)

Each transformation processes all digits of `n`, which takes O(log n) time.
The sequence quickly converges to a small bounded cycle (for non-happy numbers),
so the number of iterations is limited.

* **Space:** O(1)

Only two pointers (`slow` and `fast`) are used, regardless of input size.



