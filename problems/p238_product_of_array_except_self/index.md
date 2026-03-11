---
id: 238
title: "Product Of Array Except Self"
difficulty: Medium
tags: [array, prefix-sum]
date: 2026-03-11
link: https://leetcode.com/problems/product-of-array-except-self
---

## Problem

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)


## Approach

The goal is to construct an array where each element at index `i` contains the **product of all elements in the array except `nums[i]`**, without using division.

### Key Idea

For every index `i`, the result can be split into two parts:

productExceptSelf[i] = (product of elements to the left of i) × (product of elements to the right of i)

Instead of computing these separately with extra arrays, we compute them using **two passes**.

---

### Step 1 — Compute Left Products

We build the prefix product directly inside the result array.

- `result[i]` stores the product of all elements **to the left of `i`**.

Example logic:

result[0] = 1  
result[i] = nums[0] × nums[1] × ... × nums[i-1]

We maintain a running product:

currentProduct = currentProduct × nums[i-1]

---

### Step 2 — Multiply Right Products

Now traverse the array from **right to left**.

Maintain another running product that represents the **product of elements to the right**.

For each index:

result[i] = result[i] × rightProduct

Then update:

rightProduct = rightProduct × nums[i+1]

This effectively multiplies the stored **left product** with the **right product**, producing the final answer.

---

### Why This Works

Each index gets:

(left side product) × (right side product)

without ever including the element itself.

This avoids division and only uses constant extra memory.

---

## Complexity

### Time Complexity
O(n)

The array is traversed twice.

### Space Complexity
O(1)

No extra arrays are used apart from the output array (which does not count as extra space).



