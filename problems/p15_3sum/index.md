---
id: 15
title: "3Sum"
difficulty: Medium
tags: [arrays, sorting, two-pointers]
date: 2026-04-16
link: https://leetcode.com/problems/3sum
---

## Problem

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]

Output: [[-1,-1,2],[-1,0,1]]

Explanation:

nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.

nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.

nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.

The distinct triplets are [-1,0,1] and [-1,-1,2].

Notice that the order of the output and the order of the triplets does not matter.

Example 2:


Input: nums = [0,1,1]

Output: []

Explanation: The only possible triplet does not sum up to 0.

Example 3:


Input: nums = [0,0,0]

Output: [[0,0,0]]

Explanation: The only possible triplet sums up to 0.



Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105


## Approach

**Pattern used:** Sorting + Two Pointers

### Core Idea

You want all **unique triplets** such that:
`nums[i] + nums[j] + nums[k] = 0`

Steps:

1. Sort the array
2. Fix one element (`i`)
3. Use **two pointers** (`j`, `k`) to find pairs that sum to `-nums[i]`

---

### Step-by-step

1. **Sort array**

* Helps:

    * Use two pointers
    * Skip duplicates easily

---

2. **Fix first element (`i`)**

* Loop through array
* Skip duplicates:

    * If `nums[i] == nums[i-1]` → continue

---

3. **Two pointer search**

* `j = i + 1`, `k = n - 1`

While `j < k`:

* Compute sum

---

4. **Adjust pointers**

* If sum > 0 → decrease `k`
* If sum < 0 → increase `j`
* If sum == 0:

    * Add triplet
    * Move `j` forward (skip duplicates)

---

### ❌ Bug in your code

You only skip duplicates for `j`, but **not for `k`**

Also:

* Your `do-while` condition is unsafe:

    * `nums[j] == nums[j - 1]` before checking bounds → risk

---

### Fix

After finding a valid triplet:

1. Skip duplicates for BOTH pointers:

while (j < k && nums[j] == nums[j + 1]) j++;
while (j < k && nums[k] == nums[k - 1]) k--;

2. Then move both:

j++;
k--;

---

### Corrected Logic (clean)

* After adding result:

    * Skip duplicates on both sides
    * Move both pointers

---

### Key Insights

* Sorting enables two-pointer optimization
* Avoid duplicates at:

    * `i`
    * `j`
    * `k`
* Each triplet must be unique

---

### Edge Cases

* Array size < 3 → return empty
* All zeros → only one triplet [0,0,0]
* Large duplicates → must skip carefully

---

## Complexity

**Time Complexity:** O(n²)

* Outer loop → O(n)
* Two pointer scan → O(n)

---

**Space Complexity:** O(1) (excluding output)

---

## Optimization

Already optimal for this problem.

---

### Small Improvement

You can early break:

* If `nums[i] > 0` → break
  👉 No triplet can sum to 0

---

**Q1:** Why do we need to skip duplicates at all three positions (i, j, k)?
**Q2:** How does sorting enable the two-pointer approach here?
**Q3:** Can this be solved without sorting, and what would be the trade-offs?


