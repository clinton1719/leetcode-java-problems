---
id: 3895
title: "Count Digit Appearances"
difficulty: Medium
tags: [math, array]
date: 2026-04-11
link: https://leetcode.com/problems/count-digit-appearances
---

## Problem

You are given an integer array nums and an integer digit.


Return the total number of times digit appears in the decimal representation of all elements in nums.



Example 1:

Input: nums = [12,54,32,22], digit = 2

Output: 4

Explanation:

The digit 2 appears once in 12 and 32, and twice in 22. Thus, the total number of times digit 2 appears is 4.

Example 2:

Input: nums = [1,34,7], digit = 9

Output: 0

Explanation:

The digit 9 does not appear in the decimal representation of any element in nums, so the total number of times digit 9 appears is 0.



Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 106
0 <= digit <= 9

## Approach

**Pattern used:** Digit Extraction (Math Simulation)

### Core Idea

You need to count how many times a given **digit appears in all numbers**.

For each number:

* Extract digits using `% 10` and `/ 10`
* Compare each digit with target
* Accumulate total count

---

### Step-by-step

1. **Midway variable (as required)**

    * Store input array:
      `int[] solqaviren = nums;`

---

2. **Traverse each number**

For each `num` in array:

* Call `findCount(num, digit)`

---

3. **Count digits in a number**

Inside `findCount`:

* While number ≠ 0:

    * Extract last digit: `rem = number % 10`
    * Remove last digit: `number /= 10`
    * If match → increment count

---

4. **Accumulate result**

* Add counts from all numbers

---

### Key Insights

* `% 10` gives last digit
* `/ 10` removes last digit
* Works for any integer size (within bounds)

---

### Edge Cases

* Number = 0 → must handle separately
* Digit = 0 → tricky due to leading zeros (ignored)
* Negative numbers → not handled (can take absolute if needed)

---

## Complexity

**Time Complexity:** O(n × d)

* n = number of elements
* d = number of digits per number

---

**Space Complexity:** O(1)

* No extra space used

---

## Optimization

### Mathematical Digit Counting (Advanced)

For very large inputs:

* Count occurrences using positional math (place value technique)
* Avoid scanning every digit individually

But:

* Overkill for typical constraints

---

### Minor Improvement

Instead of function call:

* Inline logic to reduce overhead (micro optimization)

---

**Q1:** How would you handle negative numbers correctly in this approach?
**Q2:** Can you count digit occurrences from 1 to N without iterating each number?
**Q3:** Why is counting digit 0 trickier than other digits?


