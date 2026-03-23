---
id: 1863
title: "Sum Of All Subset Xor Totals"
difficulty: Easy
tags: [bit-manipulation, combinatorics, array, math, backtracking]
date: 2026-03-22
link: https://leetcode.com/problems/sum-of-all-subset-xor-totals
---

## Problem

The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.

For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
Given an array nums, return the sum of all XOR totals for every subset of nums.

Note: Subsets with the same elements should be counted multiple times.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.



Example 1:

Input: nums = [1,3]
Output: 6
Explanation: The 4 subsets of [1,3] are:
- The empty subset has an XOR total of 0.
- [1] has an XOR total of 1.
- [3] has an XOR total of 3.
- [1,3] has an XOR total of 1 XOR 3 = 2.
  0 + 1 + 3 + 2 = 6
  Example 2:

Input: nums = [5,1,6]
Output: 28
Explanation: The 8 subsets of [5,1,6] are:
- The empty subset has an XOR total of 0.
- [5] has an XOR total of 5.
- [1] has an XOR total of 1.
- [6] has an XOR total of 6.
- [5,1] has an XOR total of 5 XOR 1 = 4.
- [5,6] has an XOR total of 5 XOR 6 = 3.
- [1,6] has an XOR total of 1 XOR 6 = 7.
- [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
  0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
  Example 3:

Input: nums = [3,4,5,6,7,8]
Output: 480
Explanation: The sum of all XOR totals for every subset is 480.


Constraints:

1 <= nums.length <= 12
1 <= nums[i] <= 20


## Approach

The goal is to compute the **sum of XOR values of all subsets** of the given array.

### Key Idea: Backtracking with Incremental XOR

Instead of generating subsets and recomputing XOR from scratch, we:

- Maintain a running XOR (`currentXor`)
- Update it incrementally when adding/removing elements
- Add to the total sum whenever we form a new subset

---

### Step-by-step reasoning

1. Start with:
   - `currentXor = 0`
   - `index = 0`

2. For each index:
   - Pick an element `nums[i]`
   - Update XOR:
     
     currentXor ^= nums[i]

   - Add this value to `sum` (this represents a valid subset)

3. Recurse:
   - Move to the next index (`i + 1`) to build larger subsets

4. Backtrack:
   - Undo the XOR operation:
     
     currentXor ^= nums[i]

   - This restores the previous state for the next iteration

---

### Important Detail

- The empty subset is not explicitly included  
  (its XOR is 0, so it doesn't affect the final sum)

- Each subset is generated exactly once using the `index` progression

---

### Why This Works

- XOR is reversible:
  
  a ^ b ^ b = a

- This allows efficient backtracking without recomputation

- Each recursive path builds a unique subset

---

## Complexity

### Time Complexity

O(2ⁿ)

- Each subset is generated once
- Each step performs O(1) work (XOR + addition)

---

### Space Complexity

O(n)

- Recursion depth is at most `n`
- No extra data structures are used


