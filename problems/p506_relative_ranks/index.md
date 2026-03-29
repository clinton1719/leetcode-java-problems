---
id: 506
title: "Relative Ranks"
difficulty: Easy
tags: [heap, sorting, array]
date: 2026-03-29
link: https://leetcode.com/problems/relative-ranks
---

## Problem

You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.



Example 1:

Input: score = [5,4,3,2,1]

Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]

Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].

Example 2:


Input: score = [10,3,8,9,4]

Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]

Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].




Constraints:

n == score.length
1 <= n <= 104
0 <= score[i] <= 106
All the values in score are unique.


## Approach

**Pattern used:** Heap (Priority Queue) + Greedy

### Core Idea

Use a max heap to always pick the highest score first, assign ranks, and place them back using original indices.

### Steps

1. Store (score, index) pairs.
2. Build a max heap using comparator (b[0] - a[0]).
3. Insert all elements into heap.
4. Pop elements one by one:

    * Rank 1 → Gold Medal
    * Rank 2 → Silver Medal
    * Rank 3 → Bronze Medal
    * Others → rank number
5. Place result using original index.

### Key Insight

Heap gives sorted order without losing index mapping.

### Edge Cases

* Single element → Gold Medal
* Duplicate scores → still get unique ranks

---

## Complexity

**Time Complexity:** O(n log n)

* Heap insert + remove operations

**Space Complexity:** O(n)

* Heap + result array

 



