---
id: 20
title: "Valid Parentheses"
difficulty: Easy
tags: [string, stack]
date: 2026-02-17
link: https://leetcode.com/problems/valid-parentheses
---

## Problem

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false



Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

## Approach

We use a stack to validate matching brackets.

Algorithm:

1. Traverse the string character by character.
2. If the character is an opening bracket, push it onto the stack.
3. If it is a closing bracket:
    - If the stack is empty → return false.
    - Pop the top element from the stack.
    - Check whether it matches the corresponding opening bracket.
4. After processing all characters:
    - If the stack is empty → valid.
    - Otherwise → invalid.

The stack ensures brackets are closed in the correct order.

## Complexity

Time: O(n)
Each character is processed once.

Space: O(n)
In the worst case (all opening brackets), the stack stores all characters.


