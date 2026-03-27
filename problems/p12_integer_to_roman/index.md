---
id: 12
title: "Integer To Roman"
difficulty: Medium
tags: [string, math, hash-table]
date: 2026-03-24
link: https://leetcode.com/problems/integer-to-roman
---

## Problem

Seven different symbols represent Roman numerals with the following values:

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000
Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:

If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
Given an integer, convert it to a Roman numeral.



Example 1:

Input: num = 3749

Output: "MMMDCCXLIX"

Explanation:

3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
700 = DCC as 500 (D) + 100 (C) + 100 (C)
40 = XL as 10 (X) less of 50 (L)
9 = IX as 1 (I) less of 10 (X)
Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
Example 2:

Input: num = 58

Output: "LVIII"

Explanation:

50 = L
8 = VIII
Example 3:

Input: num = 1994

Output: "MCMXCIV"

Explanation:

1000 = M
900 = CM
90 = XC
4 = IV


Constraints:

1 <= num <= 3999


## Approach

The goal is to convert an integer into its **Roman numeral representation**.

### Key Idea: Greedy Algorithm

We always subtract the **largest possible Roman value** from the number and append its corresponding symbol.

---

### Step-by-step reasoning

1. Maintain two arrays:

values  → numerical values in descending order  
symbols → corresponding Roman numerals  

Example:

1000 → M  
900  → CM  
500  → D  
...  
1    → I  

---

2. Iterate through the arrays:

For each index `i`:

- While `num >= values[i]`:
  
  - Append `symbols[i]` to result
  - Subtract `values[i]` from `num`

---

3. Continue until `num == 0`

---

### Why This Works

Roman numerals follow a **greedy structure**:

- Always use the largest possible symbol
- Special cases (like 900 → CM, 4 → IV) are already included in the arrays

This guarantees a correct and optimal representation.

---

### Example (num = 3749)

3749 → 3000 + 700 + 40 + 9  

Breakdown:

3000 → MMM  
700  → DCC  
40   → XL  
9    → IX  

Final: **MMMDCCXLIX**

---

## Complexity

### Time Complexity

O(1)

- The number of Roman symbols is fixed (13)
- Loop runs a constant number of times

---

### Space Complexity

O(1)

- Only a StringBuilder is used
- Output size is bounded (max ~15 characters)
