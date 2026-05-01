---
id: 34
title: "Find First and Last Position of Element in Sorted Array"
difficulty: Medium
tags: [binary-search, array]
date: 2025-05-01
link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
---

## Problem

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

## Approach

**Pattern used:** Binary Search (Lower Bound & Upper Bound)

### Core Idea

Instead of finding any occurrence first, directly compute:

* **First occurrence (left boundary)**
* **Last occurrence (right boundary)**

This is done using two modified binary searches.

---

### Step-by-step

### 1. First Occurrence (Lower Bound)

Goal:

* Find the **leftmost index** where `nums[i] == target`

Logic:

* If `nums[mid] >= target` → move left (`high = mid - 1`)
* Else → move right (`low = mid + 1`)
* When `nums[mid] == target`, store index but keep searching left

---

### 2. Last Occurrence (Upper Bound)

Goal:

* Find the **rightmost index** where `nums[i] == target`

Logic:

* If `nums[mid] <= target` → move right (`low = mid + 1`)
* Else → move left (`high = mid - 1`)
* When `nums[mid] == target`, store index but keep searching right

---

### 3. Combine Results

* If `firstOccurrence == -1` → target not present
* Else return `[firstOccurrence, lastOccurrence]`

---

### Key Insights

* You are effectively implementing:

    * Lower bound → first valid position
    * Upper bound → last valid position

* Storing `ans` ensures:

    * You don’t lose valid indices while narrowing search

---

### Edge Cases

* Empty array → returns `[-1, -1]`
* Target not present → returns `[-1, -1]`
* Single element → handled correctly
* All elements same as target → returns full range

---

## Complexity

**Time Complexity:** O(log n)

* Two binary searches

---

**Space Complexity:** O(1)

---

## Optimization Insight

You can reduce duplication by writing a single function:

* Pass a flag:

    * `true` → find first occurrence
    * `false` → find last occurrence

---

## Final Take

* Clean, optimal, and interview-standard solution
* No redundant work
* Handles all edge cases correctly

---

**Q1:** Can you implement both searches using a single helper function with a boolean flag?
**Q2:** How does this relate to lower_bound and upper_bound in C++ STL?
**Q3:** What changes if the array is rotated instead of sorted?



