---
id: 17
title: "Letter Combinations Of A Phone Number"
difficulty: Medium
tags: [string, backtracking, hash-table]
date: 2026-03-16
link: https://leetcode.com/problems/letter-combinations-of-a-phone-number
---

## Problem

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
![img.png](img.png)


Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

1 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].


## Approach

This problem generates all possible **letter combinations** that a given digit string could represent based on a **phone keypad mapping**.

### Key Idea: Backtracking (DFS)

Each digit maps to multiple characters.  
We explore all possible combinations by building strings **one character at a time**.

---

### Mapping

Digits `2–9` map to:

2 → abc  
3 → def  
4 → ghi  
5 → jkl  
6 → mno  
7 → pqrs  
8 → tuv  
9 → wxyz  

---

### Step-by-step reasoning

1. **Base Case**

If the input string is empty → return empty result.

---

2. **Recursive Backtracking**

We maintain:

- `combination` → current string being built
- `digitsRem` → remaining digits to process

---

3. **At each recursive step**

- Take the **first digit** from `digitsRem`
- Get its corresponding characters from `phone_map`
- For each character:
  - Append it to `combination`
  - Recurse with remaining digits

---

4. **Termination Condition**

When `digitsRem` becomes empty:

- A complete combination is formed
- Add it to the result list

---

### Example (digits = "23")

- Start with ""
- Choose from "abc"
- For each, choose from "def"

Generated:

ad, ae, af, bd, be, bf, cd, ce, cf

---

### Why Backtracking Works

At each digit, we branch into multiple possibilities, forming a **tree of choices**.  
Backtracking explores all paths in this tree.

---

## Complexity

### Time Complexity

O(4ⁿ)

- Each digit can map to at most **4 letters** (like '7' and '9')
- Total combinations ≈ 4ⁿ

---

### Space Complexity

O(n)

- Recursion depth is at most `n`
- Excluding the output list

Output space:

O(4ⁿ × n) (to store all combinations)

