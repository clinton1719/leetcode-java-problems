---
id: 57
title: "Insert Interval"
difficulty: Medium
tags: [interval, array]
date: 2026-05-15
link: https://leetcode.com/problems/insert-interval
---

## Problem

You are given an array of non-overlapping intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.



Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105


# Insert Interval — Cleaner Greedy Version

## Why this version is elegant

Instead of handling:

* overlap merging separately
* remaining intervals separately

this solution keeps reusing `newInterval` itself as the active merged interval.

Very clean greedy approach.

---

# Core Idea

As we scan intervals:

* intervals fully before `newInterval`
  → immediately add to answer

* overlapping intervals
  → merge into `newInterval`

* intervals fully after `newInterval`
  → add current merged `newInterval`
  → shift `newInterval` forward

This avoids nested loops entirely.

---

# Three Cases

## Case 1 — Current interval before new interval

interval[1] < newInterval[0]

No overlap.

Example:

[1,2] and [5,7]

Safe to add directly.

---

## Case 2 — Current interval after new interval

interval[0] > newInterval[1]

No overlap.

Since intervals are sorted:

* current merged interval is finalized

So:

1. add `newInterval`
2. make current interval the new active interval

This line is the trick:

newInterval = interval;

Now we continue processing normally.

---

## Case 3 — Overlapping

Otherwise:

Intervals overlap.

Merge by expanding boundaries:

newInterval[0] = Math.min(newInterval[0], interval[0]);

newInterval[1] = Math.max(newInterval[1], interval[1]);

---

# Why reassignment works

This is the elegant part:

When a non-overlapping interval appears after merged interval:

result.add(newInterval);
newInterval = interval;

Instead of:

* maintaining separate variables
* creating new arrays repeatedly

you simply shift the active interval window.

Very concise greedy state transition.

---

# Example Walkthrough

Input:

[[1,2],[3,5],[6,7],[8,10],[12,16]]

newInterval = [4,8]

---

[1,2]
before new interval

result = [[1,2]]

---

[3,5]
overlaps

newInterval = [3,8]

---

[6,7]
overlaps

newInterval = [3,8]

---

[8,10]
overlaps

newInterval = [3,10]

---

[12,16]
after merged interval

result.add([3,10])

newInterval = [12,16]

---

Loop ends:

add final interval

Answer:

[[1,2],[3,10],[12,16]]

---

# Why greedy works

Because intervals are:

* sorted
* non-overlapping initially

Once overlap ends,
it can never resume later.

So local merging is globally correct.

---

# Complexity

Single traversal:

O(n)

---

Extra space:

O(n)

for result list.

---

# Subtle Detail

This mutates `newInterval`.

Completely fine for LeetCode,
but in production code:

* sometimes safer to clone arrays
  if input mutation is undesirable.

---

# Final Take

This is the cleanest standard solution for Insert Interval:

* single pass
* no nested merge loops
* elegant interval reuse

Very interview-friendly implementation.

---

**Q1:** Why is it safe to finalize `newInterval` once a later non-overlapping interval appears?
**Q2:** How would this change if intervals were not initially sorted?
**Q3:** Could this same greedy pattern work for merging rectangles in 2D?
