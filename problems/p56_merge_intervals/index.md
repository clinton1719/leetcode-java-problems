---
id: 56
title: "Merge Intervals"
difficulty: Medium
tags: [array, intervals, sorting]
date: 2026-05-14
link: https://leetcode.com/problems/merge-intervals
---

## Problem

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104


# Merge Intervals

## Approach

**Pattern used:** Sorting + Greedy Interval Merging

---

# Core Idea

Two intervals overlap if:

interval[0] \le prev[1]

Meaning:

* current interval starts before previous interval ends

After sorting by start time:

* overlapping intervals always appear consecutively

So we can greedily merge while traversing once.

---

# Step-by-step

## 1. Sort intervals

You sort by:

1. start time
2. end time if starts equal

This guarantees:

* intervals are processed left → right

Example:

Before:

[8,10] [1,3] [2,6]

After sorting:

[1,3] [2,6] [8,10]

Now overlaps become easy to detect.

---

# 2. Track current merged interval

Initialize:

int[] prev = intervals[0];

This represents:

* current active merged interval

---

# 3. Process intervals

For every interval:

## Overlap case

If:

interval[0] <= prev[1]

they overlap.

Merge them:

prev[1] = Math.max(prev[1], interval[1]);

Your line:

prev[0] = Math.min(interval[0], prev[0]);

works too,
though unnecessary after sorting because:

* `prev[0]` is already smallest

---

## Non-overlap case

If intervals do not overlap:

* previous merged interval is finalized
* add it to result
* start new merge group

---

# 4. Add final interval

After loop:

* last merged interval still remains

So:

list.add(prev);

is required.

---

# Example Walkthrough

Input:

[[1,3],[2,6],[8,10],[15,18]]

After sorting:

[[1,3],[2,6],[8,10],[15,18]]

---

Current:

prev = [1,3]

Next:
[2,6]

Overlap:
2 <= 3

Merge:

prev = [1,6]

---

Next:
[8,10]

No overlap:
8 > 6

Store [1,6]

prev = [8,10]

---

Next:
[15,18]

No overlap

Store [8,10]

prev = [15,18]

Final answer:

[[1,6],[8,10],[15,18]]

---

# Why greedy works

After sorting:

* earliest starting interval must be processed first
* merging immediately never harms future decisions

Because:

* any future overlap must also overlap current merged range

So local greedy merge becomes globally optimal.

---

# Complexity

## Sorting

O(n \log n)

---

## Traversal

O(n)

---

## Total

O(n \log n)

---

## Space Complexity

Ignoring output list:

O(1)

Including result storage:

O(n)

---

# Final Take

This is the standard optimal solution:

* sort
* greedily merge
* linear sweep afterward

Very important interval pattern.

---

**Q1:** Why does sorting by start time make greedy merging valid?
**Q2:** How would the problem change if intervals were closed/open ranges?
**Q3:** How would you solve this if intervals arrived as a stream instead of all at once?
