---
id: 6
title: "Zigzag Conversion"
difficulty: Medium
tags: [array, string]
date: 2026-04-14
link: https://leetcode.com/problems/zigzag-conversion
---

## Problem

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3

Output: "PAHNAPLSIIGYIR"

Example 2:


Input: s = "PAYPALISHIRING", numRows = 4

Output: "PINALSIGYAHRPI"

Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:


Input: s = "A", numRows = 1

Output: "A"

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000

## Approach

**Pattern used:** Simulation (Zigzag Traversal)

### Core Idea

You simulate writing characters in a **zigzag pattern row by row**, then concatenate rows.

Instead of building a 2D grid, you:

* Maintain `numRows` string builders
* Traverse rows in a **down → up zigzag manner**

---

### Step-by-step

1. **Handle edge case**

    * If `numRows == 1` → return original string
      👉 No zigzag possible

---

2. **Initialize rows**

    * Create `numRows` StringBuilders
    * Each represents one row

---

3. **Traverse characters**

Maintain:

* `currRow` → current row index
* `isDown` → direction flag

For each character:

* Append to `rows[currRow]`

---

4. **Change direction**

* If at top (`currRow == 0`) OR bottom (`currRow == numRows - 1`)
  → flip direction:
  `isDown = !isDown`

---

5. **Move row pointer**

* If going down → `currRow++`
* Else → `currRow--`

---

6. **Build result**

* Concatenate all rows

---

### Key Insights

* Zigzag is just **row movement simulation**
* No need to build full matrix
* Direction change happens only at boundaries

---

### Subtle Details

* `isDown` flips at both ends (top and bottom)
* Initial direction starts correctly due to first flip at row 0
* Efficient because each character is processed once

---

### Example

Input:
s = "PAYPALISHIRING", numRows = 3

Rows:
P   A   H   N
A P L S I I G
Y   I   R

Output:
"PAHNAPLSIIGYIR"

---

### Edge Cases

* numRows = 1 → return original string
* numRows ≥ length of string → behaves like no zigzag
* Empty string → return ""

---

## Complexity

**Time Complexity:** O(n)

* Each character processed once

---

**Space Complexity:** O(n)

* Rows store all characters

---

## Optimization

This is already optimal:

* No redundant work
* Minimal space for required transformation

---

### Alternative (Index Pattern Math)

You can compute indices directly using cycle length:

* `cycleLen = 2 * (numRows - 1)`

But:

* Harder to implement
* Less intuitive

---

**Q1:** Why does the zigzag pattern repeat every `2 × (numRows - 1)` characters?
**Q2:** How would you print the actual zigzag matrix instead of just the string?
**Q3:** Can you solve this without using extra row storage (pure index math)?


