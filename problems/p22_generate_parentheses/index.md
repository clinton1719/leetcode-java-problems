---
id: 22
title: "Generate Parentheses"
difficulty: Medium
tags: [backtracking, string, dynamic-programming]
date: 2026-03-23
link: https://leetcode.com/problems/generate-parentheses
---

## Problem

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8


## Approach

The goal is to generate all combinations of **well-formed parentheses** for `n` pairs.

### Key Idea: Backtracking with Constraints

We build the string step-by-step while ensuring it **never becomes invalid**.

We track:

- `leftPar` → number of `'('` used
- `rightPar` → number of `')'` used

---

### Rules for Valid Parentheses

1. We can add `'('` if:
   
   leftPar < maxPar

2. We can add `')'` if:
   
   rightPar < leftPar

   (ensures we never close more parentheses than opened)

---

### Step-by-step reasoning

1. Start with an empty string.

2. At each step:

   - Try adding `'('` if allowed
   - Try adding `')'` if allowed

3. Use `StringBuilder`:
   - Append character
   - Recurse
   - Remove last character (backtrack)

---

### Base Case

When:

leftPar == maxPar AND rightPar == maxPar

- A valid combination is formed
- Add it to the result list

---

### Why This Works

- The constraints ensure:
  - No invalid sequences are ever generated
  - No need to validate afterward

- This prunes a huge number of invalid combinations early

---

### Example (n = 3)

Generated:

((()))  
(()())  
(())()  
()(())  
()()()  

---

## Complexity

### Time Complexity

O(Cₙ)

Where `Cₙ` is the **nth Catalan number**:

Cₙ = (1 / (n + 1)) × (2n choose n)

Approximation:

O(4ⁿ / √n)

---

### Space Complexity

O(n)

- Recursion depth is at most `2n`
- `StringBuilder` holds up to `2n` characters

Output space:

O(Cₙ × n)
