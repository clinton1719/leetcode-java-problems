---
id: 33
title: "Search In Rotated Sorted Array"
difficulty: Medium
tags: [array, binary-search]
date: 2025-04-15
link: https://leetcode.com/problems/search-in-rotated-sorted-array
---

## Problem

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0

Output: 4

Example 2:


Input: nums = [4,5,6,7,0,1,2], target = 3

Output: -1

Example 3:


Input: nums = [1], target = 0

Output: -1



Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104

## Approach

**Pattern used:** Modified Binary Search (Rotated Sorted Array)

### Core Idea

The array is **sorted but rotated**, so normal binary search doesn’t directly apply.

Key observation:
👉 At least **one half (left or right) is always sorted**

You use this property to decide:

* Which half is sorted
* Whether the target lies in that half

---

### Step-by-step

1. **Initialize pointers**

    * `left = 0`, `right = n - 1`

---

2. **Binary search loop**

While `left < right`:

* Compute `mid`

---

3. **Check if found**

* If `nums[mid] == target` → return mid

---

4. **Decide which half to explore**

### Case 1: nums[mid] > target

* Target is smaller than mid

Check:

* If left side is rotated and target is not in left:

    * `nums[left] > target && nums[mid] > nums[right]`
      → search right:
      `left = mid + 1`

* Else:
  → search left:
  `right = mid`

---

### Case 2: nums[mid] < target

* Target is larger than mid

Check:

* If rotation affects left and target is in left:

    * `nums[mid] < nums[left] && nums[left] <= target`
      → search left:
      `right = mid`

* Else:
  → search right:
  `left = mid + 1`

---

5. **Final check**

* After loop:
  `nums[left] == target ? left : -1`

---

### Key Insights

* Rotated array breaks global order but preserves **partial order**
* One side of mid is always sorted
* You must carefully decide which side to discard

---

### Subtle Details

* Using `left < right` (not ≤) requires final check
* Conditions are slightly complex due to rotation detection
* Comparisons involve both `left`, `mid`, and `right`

---

### Edge Cases

* Single element → handled by final check
* Target not present → returns -1
* No rotation → behaves like normal binary search
* Fully rotated (same as sorted) → still works

---

## Complexity

**Time Complexity:** O(log n)

* Standard binary search behavior

---

**Space Complexity:** O(1)

* No extra space used

---

## Optimization (Cleaner Approach)

More intuitive version:

1. Check which half is sorted:

    * If `nums[left] <= nums[mid]` → left sorted
    * Else → right sorted

2. Then check if target lies in sorted half

👉 Leads to simpler and more readable conditions

---

**Q1:** How do you reliably detect which half is sorted in a rotated array?
**Q2:** What changes if the array contains duplicate elements?
**Q3:** Can you find the rotation pivot first and then do normal binary search?
