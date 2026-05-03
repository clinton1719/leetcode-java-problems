---
id: 3917
title: "Count Indices With Opposite Parity"
difficulty: Easy
tags: [math, array, counting, suffix-array]
date: 2026-05-03
link: https://leetcode.com/problems/count-indices-with-opposite-parity
---

## Problem

You are given an integer array nums of length n.

The score of an index i is defined as the number of indices j such that:

i < j < n, and
nums[i] and nums[j] have different parity (one is even and the other is odd).

Return an integer array answer of length n, where answer[i] is the score of index i.




Example 1:


Input: nums = [1,2,3,4]

Output: [2,1,1,0]

Explanation:

nums[0] = 1, which is odd. Thus, the indices j = 1 and j = 3 satisfy the conditions, so the score of index 0 is 2.

nums[1] = 2, which is even. Thus, the index j = 2 satisfies the conditions, so the score of index 1 is 1.

nums[2] = 3, which is odd. Thus, the index j = 3 satisfies the conditions, so the score of index 2 is 1.

nums[3] = 4, which is even. Thus, no index satisfies the conditions, so the score of index 3 is 0.

Thus, the answer = [2, 1, 1, 0].


Example 2:


Input: nums = [1]


Output: [0]


Explanation:


There is only one element in nums. Thus, the score of index 0 is 0.



Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100


## Approach

**Pattern used:** Reverse Traversal + Counting (Suffix Aggregation)

---

### Core Idea

For each index `i`, you need to count how many elements to the **right** have **opposite parity**.

Instead of checking every pair (which would be slow), you:

* Traverse from **right → left**
* Maintain:

    * `evenCount` → number of even elements seen so far (to the right)
    * `oddCount` → number of odd elements seen so far (to the right)

---

### Step-by-step

1. Initialize:

    * `evenCount = 0`
    * `oddCount = 0`

2. Traverse from `n-1 → 0`

3. For each element:

    * If `nums[i]` is even:

        * Opposite parity = odd
        * `answer[i] = oddCount`
        * Increment `evenCount`
    * If `nums[i]` is odd:

        * Opposite parity = even
        * `answer[i] = evenCount`
        * Increment `oddCount`

---

### Key Insights

* You only care about elements **to the right**
* By going backwards, you already know all future elements
* This avoids nested loops completely

---

### Why this works

At index `i`:

* All elements `j > i` are already processed
* Counts (`evenCount`, `oddCount`) represent exactly what you need

---

### Edge Cases

* Last element → always `0` (nothing to the right)
* All elements same parity → all answers `0`
* Alternating array → increasing counts

---

## Complexity

**Time Complexity:** O(n)

* Single pass through array

---

**Space Complexity:** O(1) (excluding output array)

---

## Optimization Insight

Brute-force approach:

* O(n²) → check all pairs

Your approach:

* Optimal O(n) using suffix counting

---

## Final Take

* Clean and optimal solution
* Perfect use of reverse traversal
* Classic “count future elements” pattern

---

**Q1:** How would you solve this if the condition was `i < j < k` (triplets)?
**Q2:** Can this be solved using prefix counts instead of suffix? How would logic change?
**Q3:** What if parity condition was replaced with “difference > k”? Would this approach still work?
