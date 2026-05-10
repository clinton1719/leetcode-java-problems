---
id: 3919
title: "Minimum Cost to Move Between Indices"
difficulty: Medium
tags: [prefix-sum, greedy, array, suffix-array]
date: 2026-05-03
link: https://leetcode.com/problems/minimum-cost-to-move-between-indices
---

## Problem

You are given an integer array nums where nums is strictly increasing.

For each index x, let closest(x) be the adjacent index such that abs(nums[x] - nums[y]) is minimized. If both adjacent indices exist and give the same difference, choose the smaller index.

From any index x, you can move in two ways:

To any index y with cost abs(nums[x] - nums[y]), or
To closest(x) with cost 1.
You are also given a 2D integer array queries, where each queries[i] = [li, ri].

For each query, calculate the minimum total cost to move from index li to index ri.

Return an integer array ans, where ans[i] is the answer for the ith query.

An array is said to be strictly increasing if each element is strictly greater than its previous one.

The absolute difference between two values x and y is defined as abs(x - y).



Example 1:

Input: nums = [-5,-2,3], queries = [[0,2],[2,0],[1,2]]

Output: [6,2,5]

Explanation:​​​​​​​​​​​​​​​​​​​​

The closest indices are [1, 0, 1] respectively.
For [0, 2], the path 0 → 1 → 2 uses a closest move from index 0 to 1 with cost 1 and a move from index 1 to 2 with cost |-2 - 3| = 5, giving total 1 + 5 = 6.
For [2, 0], the path 2 → 1 → 0 uses two closest moves from index 2 to 1 and from index 1 to 0, each with cost 1, giving total 2.
For [1, 2], the direct move from index 1 to index 2 has cost |-2 - 3| = 5, which is optimal.
Thus, ans = [6, 2, 5].

Example 2:

Input: nums = [0,2,3,9], queries = [[3,0],[1,2],[2,0]]

Output: [4,1,3]

Explanation:

The closest indices are [1, 2, 1, 2] respectively.
For [3, 0], the path 3 → 2 → 1 → 0 uses closest moves from index 3 to 2 and from 2 to 1, each with cost 1, and a move from 1 to 0 with cost |2 - 0| = 2, giving total 1 + 1 + 2 = 4.
For [1, 2], the closest move from index 1 to 2 has cost 1.
For [2, 0], the path 2 → 1 → 0 uses a closest move from index 2 to 1 with cost 1 and a move from 1 to 0 with cost |2 - 0| = 2, giving total 1 + 2 = 3.
Thus, ans = [4, 1, 3].



Constraints:

2 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is strictly increasing
1 <= queries.length <= 105
queries[i] = [li, ri]​​​​​​​
0 <= li, ri < nums.length



## Approach

**Pattern used:** Greedy + Prefix Sum Precomputation

---

### Core Idea

At each index, you have **two choices**:

1. Jump to **any index** → cost = absolute difference
2. Jump to **closest neighbor** → cost = 1

Since the array is **strictly increasing**, the best strategy reduces to:

* Only consider **moving step-by-step (adjacent indices)**
* At each step, choose:

    * **Cost = 1** if closest move points in that direction
    * Else **cost = difference**

So instead of exploring all paths, we precompute the **minimum cost to move linearly**.

---

### Step-by-step

### 1. Compute `closest[]`

For each index:

* Compare distance to left and right neighbor
* Pick the smaller one
* If equal → pick left (smaller index)

Edge cases:

* `0 → 1`
* `n-1 → n-2`

---

### 2. Build `forward[]`

`forward[i] = min cost to reach i from 0`

For each step `i-1 → i`:

* If `closest[i-1] == i` → cost = 1
* Else → cost = `nums[i] - nums[i-1]`

---

### 3. Build `backward[]`

`backward[i] = min cost to reach i from n-1`

For each step `i+1 → i`:

* If `closest[i+1] == i` → cost = 1
* Else → cost = `nums[i+1] - nums[i]`

---

### 4. Answer Queries

* If `l < r` → use forward:
  `cost = forward[r] - forward[l]`

* If `l > r` → use backward:
  `cost = backward[r] - backward[l]`

---

### Key Insights

* Optimal path is always **monotonic (no zig-zag)**
  → because:

    * Direct jumps are expensive (difference grows)
    * Closest jumps are only between adjacent indices

* So problem reduces to:
  → **choosing best cost per adjacent step**

---

### Subtle Detail

* You are NOT doing shortest path per query
* You are precomputing **best transitions once**
* Queries become **O(1)**

---

### Edge Cases

* Adjacent indices → handled naturally
* Equal distance case → tie goes left
* Large queries → efficient due to prefix sums

---

## Complexity

**Time Complexity:**

* Preprocessing: O(n)
* Queries: O(q)
  → Total: **O(n + q)**

---

**Space Complexity:** O(n)

* closest + forward + backward arrays

---

## Optimization Insight

Brute-force (like Dijkstra per query) would be:

* O(q * n log n) → too slow

This works because:

* Graph is **implicitly linear**
* Only adjacent transitions matter

---

## Final Take

* Very strong optimization using structure of sorted array
* Converts graph problem → prefix sum problem
* Ideal for large constraints

---

**Q1:** Why is it never optimal to skip intermediate indices using direct jumps?
**Q2:** Can this approach work if the array is not strictly increasing?
**Q3:** How would you solve this if closest moves could jump beyond adjacent indices?

