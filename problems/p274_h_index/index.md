---
id: 274
title: "H-Index"
difficulty: Medium
tags: [array, sorting, counting-sort]
date: 2026-02-08
link: https://leetcode.com/problems/h-index
---

## Problem
Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.



Example 1:

Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:

Input: citations = [1,3,1]
Output: 1


Constraints:

n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000


## Approach

The array of citation counts is first sorted in ascending order.
After sorting, for each index `i`, the number of papers that have at least `citations[i]` citations is `n - i`.
If `citations[i]` is greater than or equal to `n - i`, then there are at least `n - i` papers with at least `n - i` citations, which satisfies the definition of the H-index.
The first position where this condition holds gives the maximum possible H-index, so it is returned immediately.

If no such position exists, the H-index is `0`.

## Complexity

* **Time:** O(n log n)
* **Space:** O(1)


