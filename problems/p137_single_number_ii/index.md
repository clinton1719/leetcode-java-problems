---
id: 137
title: "Single Number II"
difficulty: Medium
tags: [bit-manipulation, array]
date: 2026-03-25
link: https://leetcode.com/problems/single-number-ii
---

## Problem

Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,3,2]

Output: 3

Example 2:

Input: nums = [0,1,0,1,0,1,99]

Output: 99


Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.


## Approach

The goal is to find the **single number** in an array where every other number appears **exactly 3 times**.

### Key Idea: Bit Manipulation (Count Bits)

Instead of tracking numbers directly, we analyze **each bit position (0–31)** independently.

---

### Step-by-step reasoning

1. Initialize `result = 0`.

2. For each bit position `i` from `0` to `31`:

   - Count how many numbers have the **i-th bit set**.

   count += (num >> i) & 1

---

3. Key Observation

- Numbers appearing 3 times contribute bits in multiples of **3**.
- The unique number contributes bits **once**.

So:

count % 3 → gives the bit of the unique number

---

4. Reconstruct the result

If:

count % 3 != 0

→ set the i-th bit in result:

result |= (1 << i)

---

### Example

nums = [2, 2, 3, 2]

Binary:

2 → 010  
3 → 011  

Bit counts:

Bit 0 → 1 → 1 % 3 = 1  
Bit 1 → 4 → 4 % 3 = 1  

Result → 011 → **3**

---

### Why This Works

- Bit contributions from triplets cancel out (mod 3)
- Only the unique number's bits remain

---

### Important Detail

This works correctly even for **negative numbers** because:

- We process all 32 bits (including sign bit)
- Bit reconstruction preserves sign

---

## Complexity

### Time Complexity

O(32 × n) → O(n)

- 32 is constant (number of bits in an integer)

---

### Space Complexity

O(1)

- Only a few variables are used
