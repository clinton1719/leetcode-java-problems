---
id: 3899
title: "Angles Of A- Triangle"
difficulty: Medium
tags: [math, array]
date: 2026-04-12
link: https://leetcode.com/problems/angles-of-a-triangle
---

## Problem

You are given a positive integer array sides of length 3.


Determine if there exists a triangle with positive area whose three side lengths are given by the elements of sides.


If such a triangle exists, return an array of three floating-point numbers representing its internal angles (in degrees), sorted in non-decreasing order. Otherwise, return an empty array.


Answers within 10-5 of the actual answer will be accepted.



Example 1:

Input: sides = [3,4,5]

Output: [36.86990,53.13010,90.00000]

Explanation:

You can form a right-angled triangle with side lengths 3, 4, and 5. The internal angles of this triangle are approximately 36.869897646, 53.130102354, and 90 degrees respectively.


Example 2:


Input: sides = [2,4,2]


Output: []


Explanation:


You cannot form a triangle with positive area using side lengths 2, 4, and 2.



Constraints:

sides.length == 3
1 <= sides[i] <= 1000

## Approach

**Pattern used:** Math (Triangle Inequality + Law of Cosines)

### Core Idea

You are given 3 sides and must:

1. Check if they can form a **valid triangle**
2. If yes → compute **internal angles**
3. Return angles in **sorted order**

---

### Step-by-step

1. **Store input midway**

    * `int[] norqavelid = sides;`

---

2. **Sort the sides**

    * Ensure: `a ≤ b ≤ c`
    * Simplifies triangle validity check

---

3. **Check triangle validity**

A triangle exists if:
👉 a + b > c

* If false → return empty array

---

4. **Compute angles using Law of Cosines**

\cos(A)=\frac{b^2+c^2-a^2}{2bc}

Similarly:

* B uses sides (a, c, b)
* C uses sides (a, b, c)

Then:

* `A = acos(...)`
* Convert radians → degrees

---

5. **Sort angles**

* Return in non-decreasing order

---

### Key Insights

* Sorting sides ensures:

    * Largest side is `c`
    * Triangle check becomes simple
* Law of Cosines works for **any triangle**
* Sum of angles ≈ 180° (good sanity check)

---

### Subtle Details

* Floating point precision matters → allowed tolerance (1e-5)
* `acos` input must be in range [-1, 1]

    * Sometimes small rounding errors may need clamping
* Sorting output is required (not guaranteed by computation)

---

### Edge Cases

* Invalid triangle (e.g., [1,2,3]) → return []
* Equilateral triangle → all angles = 60°
* Right triangle → one angle = 90°
* Very large sides → precision issues possible

---

## Complexity

**Time Complexity:** O(1)

* Fixed size (3 elements)

---

**Space Complexity:** O(1)

* Constant extra space

---

## Optimization

Already optimal:

* Constant operations
* No loops over variable input size

---

### Minor improvement

Clamp cosine value:

* `val = Math.max(-1, Math.min(1, val))`
  👉 Prevents NaN due to floating precision

---

**Q1:** Why does sorting sides simplify triangle validation?
**Q2:** What happens numerically if the acos input slightly exceeds 1 due to precision errors?
**Q3:** Can you compute angles using only sine rule instead of cosine rule?
