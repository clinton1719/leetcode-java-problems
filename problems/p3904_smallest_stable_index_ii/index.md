---
id: 3904
title: "Smallest Stable Index II"
difficulty: Medium
tags: [prefix-sum, array]
date: 2026-04-19
link: https://leetcode.com/problems/smallest-stable-index-ii
---

## Problem

You are given an integer array nums of length n and an integer k.

For each index i, define its instability score as max(nums[0..i]) - min(nums[i..n - 1]).

In other words:

max(nums[0..i]) is the largest value among the elements from index 0 to index i.
min(nums[i..n - 1]) is the smallest value among the elements from index i to index n - 1.
An index i is called stable if its instability score is less than or equal to k.

Return the smallest stable index. If no such index exists, return -1.



Example 1:

Input: nums = [5,0,1,4], k = 3

Output: 3

Explanation:

At index 0: The maximum in [5] is 5, and the minimum in [5, 0, 1, 4] is 0, so the instability score is 5 - 0 = 5.
At index 1: The maximum in [5, 0] is 5, and the minimum in [0, 1, 4] is 0, so the instability score is 5 - 0 = 5.
At index 2: The maximum in [5, 0, 1] is 5, and the minimum in [1, 4] is 1, so the instability score is 5 - 1 = 4.
At index 3: The maximum in [5, 0, 1, 4] is 5, and the minimum in [4] is 4, so the instability score is 5 - 4 = 1.
This is the first index with an instability score less than or equal to k = 3. Thus, the answer is 3.
Example 2:

Input: nums = [3,2,1], k = 1

Output: -1

Explanation:

At index 0, the instability score is 3 - 1 = 2.
At index 1, the instability score is 3 - 1 = 2.
At index 2, the instability score is 3 - 1 = 2.
None of these values is less than or equal to k = 1, so the answer is -1.
Example 3:

Input: nums = [0], k = 0

Output: 0

Explanation:

At index 0, the instability score is 0 - 0 = 0, which is less than or equal to k = 0. Therefore, the answer is 0.



Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109
0 <= k <= 109


## Approach

**Pattern used:** Prefix Max + Suffix Min (Optimized)

### Core Idea

You’re finding the **first index `i`** such that:

👉 max(nums[0..i]) − min(nums[i..n−1]) ≤ k

Instead of storing both prefix and suffix arrays:

* You **precompute suffix minimum**
* Maintain **prefix maximum on the fly**

👉 This reduces space while keeping logic clean

---

### Step-by-step

### 1. Build suffix min array

* `minArray[i] = min(nums[i..n-1])`

Traverse from right:

* Keep updating `currentMin`
* Store at each index

---

### 2. Traverse from left with prefix max

* Maintain:
  `currentMax = max(nums[0..i])`

For each index `i`:

* Update `currentMax`
* Check:
  `currentMax - minArray[i] <= k`

---

### 3. Return first valid index

* As soon as condition is satisfied:
  → return `i`

👉 Guarantees smallest index

---

### Key Insights

* Prefix max grows monotonically
* Suffix min shrinks monotonically
* First valid index is optimal → no need to check further

---

### Why this works efficiently

Instead of:

* Recomputing max/min for every index (O(n²))

You:

* Precompute once
* Query in O(1)

---

### Subtle Details

* `i` is included in both:

  * Prefix (left side)
  * Suffix (right side)
* This is correct because condition allows overlap

---

### Example

nums = [3, 1, 5, 2], k = 2

minArray = [1, 1, 2, 2]

Check:

* i=0 → 3-1=2 ✅ → return 0

---

### Edge Cases

* Single element → always valid if 0 ≤ k
* No valid index → return -1
* Large k → likely return 0
* Strict patterns → still works due to monotonic tracking

---

## Complexity

**Time Complexity:** O(n)

* One pass for suffix min
* One pass for prefix max

---

**Space Complexity:** O(n)

* Only suffix array used

---

## Optimization

### Further Space Optimization (True O(1)?)

Not fully possible because:

* You need future information (`minArray[i]`)

But:

* You already reduced from O(2n) → O(n) ✔️

---

### Why this is optimal

* Linear time
* Minimal memory for required lookahead

---

**Q1:** Why can’t we compute suffix min on the fly without extra space?
**Q2:** What happens if we reverse the condition to use suffix max instead?
**Q3:** Can this pattern be generalized to solve partitioning problems like “valid split index”?
