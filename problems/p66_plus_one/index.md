---
id: 66
title: "Plus One"
difficulty: Easy
tags: [math, array]
date: 2026-03-01
link: https://leetcode.com/problems/plus-one
---

## Problem

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].


Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.

## Approach

This problem simulates adding 1 to a number represented as an array of digits (most significant digit at index 0).

### Step-by-step reasoning:

1. Start iterating from the last index (least significant digit).
2. If the current digit is less than 9:
  - Increment it by 1.
  - Return the array immediately (no carry needed).
3. If the digit is 9:
  - Set it to 0 (since 9 + 1 = 10 → write 0, carry 1).
  - Continue moving left to propagate the carry.
4. If the loop completes, it means all digits were 9 (e.g., 999 → 1000).
  - Create a new array of size n + 1.
  - Set the first element to 1.
  - Remaining elements are 0 by default.
  - Return this new array.

### Key Insight

Carry propagation stops as soon as we find a digit less than 9.  
Only in the worst case (all 9s) do we traverse the entire array.

---

## Complexity

### Time Complexity:
O(n)  
In the worst case (e.g., [9,9,9]), we traverse all digits once.

### Space Complexity:
O(1)  
No extra space is used in the normal case.

O(n) in the worst case  
When all digits are 9, we create a new array of size n + 1.
