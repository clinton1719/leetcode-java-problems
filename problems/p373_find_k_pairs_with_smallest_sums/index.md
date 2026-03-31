---
id: 373
title: "Find K Pairs With Smallest Sums"
difficulty: Medium
tags: [heap, array]
date: 2026-03-31
link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums
---

## Problem

You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.



Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]


Constraints:

1 <= nums1.length, nums2.length <= 105
-109 <= nums1[i], nums2[i] <= 109
nums1 and nums2 both are sorted in non-decreasing order.
1 <= k <= 104
k <= nums1.length * nums2.length


## Approach

**Pattern used:** Min Heap (Best-First Search) + Visited Set

### Core Idea

You need the **k pairs with smallest sums** from two sorted arrays.

Think of this as exploring a **2D grid**:

* Each cell (i, j) represents pair (nums1[i], nums2[j])
* Value = nums1[i] + nums2[j]

Since arrays are sorted:

* Moving right (j+1) → increases sum
* Moving down (i+1) → increases sum

So you use a **min heap** to always expand the next smallest pair — similar to BFS on a grid.

---

### Step-by-step

1. **Initialize heap**

    * Store (sum, i, j)
    * Start from (0,0) → smallest possible sum

2. **Visited set**

    * Prevent pushing same (i, j) multiple times
    * Store as string: "i,j"

---

3. **Process k smallest pairs**

While k > 0:

* Pop smallest pair from heap
* Add corresponding values to result

From current (i, j), explore:

* (i+1, j) → move down
* (i, j+1) → move right

Push them into heap **only if not visited**

---

### Key Insights

* This is **not brute force (n × m)** — you only explore needed cells
* Heap ensures you always expand the next smallest sum
* Visited set avoids duplicate work
* This is essentially **Dijkstra-like traversal on a grid**

---

### Subtle Details

* Starting at (0,0) is critical → guarantees smallest starting point
* Without visited set → duplicates flood the heap
* Using sum in heap avoids recomputing repeatedly

---

### Edge Cases

* One of the arrays is empty → return empty list
* k > n × m → loop stops when heap is empty
* Duplicate values → still works correctly
* Very small arrays → behaves like simple pairing

---

## Complexity

**Time Complexity:** O(k log k)

* Each pop → O(log k)
* At most ~2k pushes into heap

---

**Space Complexity:** O(k)

* Heap stores up to O(k) elements
* Visited set also O(k)

---

## Optimization

### Better Approach (No Visited Set)

You can avoid the visited set entirely:

* Push only (i, 0) for i in [0, min(k, n))
* Each time you pop (i, j), push (i, j+1)

This works because:

* You expand row-wise in a controlled manner
* No duplicates are generated

This reduces:

* Extra space (no visited set)
* String overhead

---

**Q1:** Why does pushing only (i, 0) initially eliminate the need for a visited set?
**Q2:** How would this approach change if arrays were NOT sorted?
**Q3:** Can you extend this idea to 3 arrays (k smallest triplets)?
