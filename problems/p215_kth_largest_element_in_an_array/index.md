---
id: 215
title: "Kth Largest Element In An Array"
difficulty: Medium
tags: [heap, array, sorting, quickselect, divide-and-conquer]
date: 2026-03-29
link: https://leetcode.com/problems/kth-largest-element-in-an-array
---

## Problem

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?



Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4


Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104


## Approach

The goal is to find the **k-th largest element** in an unsorted array.

### Key Idea: Min-Heap of Size k

Instead of sorting the entire array, we maintain a **min-heap of size k** that always stores the **k largest elements seen so far**.

---

### Step-by-step reasoning

1. Initialize a **min-heap**.

2. Iterate through each element in the array:

   - Add the element to the heap:
     
     heap.offer(num)

   - If heap size exceeds `k`:
     
     heap.poll()

     (removes the smallest element)

---

3. Final Result

- After processing all elements:
  
  The heap contains the **k largest elements**

- The top of the heap (`heap.peek()`) is:

  👉 the **k-th largest element**

---

### Why This Works

- The heap always keeps only the **k largest elements**
- Any smaller elements are discarded immediately
- The smallest among these k elements is the answer

---

### Example

nums = [3,2,1,5,6,4], k = 2

Steps:

Add 3 → [3]  
Add 2 → [2,3]  
Add 1 → remove 1 → [2,3]  
Add 5 → remove 2 → [3,5]  
Add 6 → remove 3 → [5,6]  
Add 4 → remove 4 → [5,6]  

Result → 5

---

## Complexity

### Time Complexity

O(n log k)

- Each insertion/removal takes O(log k)
- Done for `n` elements

---

### Space Complexity

O(k)

- Heap stores at most `k` elements



