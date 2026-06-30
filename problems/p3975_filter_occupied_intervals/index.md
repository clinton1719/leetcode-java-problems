---
id: 3975
title: "Filter Occupied Intervals"
difficulty: Medium
tags: [intervals, sorting]
date: 2026-06-30
link: https://leetcode.com/problems/filter-occupied-intervals
---

## Problem

You are given a 2D integer array occupiedIntervals, where occupiedIntervals[i] = [starti, endi] represents a time interval during which you are occupied. Each interval starts at starti and ends at endi, inclusive. These intervals may overlap.

You are also given two integers freeStart and freeEnd, which define a free time interval from freeStart to freeEnd, inclusive.

Your task is to merge all occupied intervals that overlap or touch, then remove all integer points in the free interval from the merged occupied intervals.

Two intervals touch if the second interval starts immediately after the first one ends. For example, [1, 1] and [2, 2] touch and should be merged into [1, 2].

Return the remaining occupied intervals in sorted order. The returned intervals must be non-overlapping and must contain the minimum number of intervals possible. If there are no remaining occupied points, return an empty list.



Example 1:

Input: occupiedIntervals = [[2,6],[4,8],[10,10],[10,12],[14,16]], freeStart = 7, freeEnd = 11

Output: [[2,6],[12,12],[14,16]]

Explanation:

After merging, the occupied intervals are [2, 8], [10, 12], and [14, 16].
Excluding the free interval [7, 11] results in [2, 6], [12, 12], and [14, 16].
Example 2:

Input: occupiedIntervals = [[1,5],[2,3]], freeStart = 3, freeEnd = 8

Output: [[1,2]]

Explanation:

After merging, the occupied interval is [1, 5].
Excluding the free interval [3, 8] results in [1, 2].


Constraints:

1 <= occupiedIntervals.length <= 5 * 104
occupiedIntervals[i].length == 2
1 <= starti <= endi <= 109
1 <= freeStart <= freeEnd <= 109


# Intuition

The problem can be solved in two independent phases:

1. **Merge all occupied intervals** so that overlapping or touching intervals become a single interval.
2. **Remove the free interval** from each merged interval.

Since the final occupied intervals must be non-overlapping and minimal, merging first greatly simplifies the second step.

Touching intervals should also be merged because they represent continuous occupied integer points. For example, `[1, 1]` and `[2, 2]` become `[1, 2]`.

---

# Approach

### Phase 1: Merge Occupied Intervals

- Sort all occupied intervals by their starting time.
- Traverse the sorted intervals while maintaining the current merged interval.
- If the next interval overlaps or touches the current interval, extend the current interval.
- Otherwise, store the current interval and begin a new one.

After this phase, every occupied point belongs to exactly one merged interval.

### Phase 2: Remove the Free Interval

For each merged interval, there are five possible cases:

1. **No overlap**
    - The occupied interval lies completely outside the free interval.
    - Keep the interval unchanged.

2. **Completely inside the free interval**
    - Every occupied point is removed.
    - Discard the interval.

3. **Free interval lies completely inside the occupied interval**
    - The occupied interval is split into two smaller intervals.

4. **Overlap on the right side**
    - Keep only the left remaining portion.

5. **Overlap on the left side**
    - Keep only the right remaining portion.

Processing every merged interval independently produces the final answer.

---

# Why Does This Work?

The algorithm is correct because it separates the problem into two well-defined operations.

First, sorting guarantees that any overlapping or touching intervals appear consecutively. Therefore, a single linear scan is sufficient to merge every connected occupied region.

Once merged, each occupied interval is independent of every other interval. Removing the free interval from one merged interval cannot affect another, allowing each interval to be processed separately.

Considering all possible overlap cases ensures that every occupied integer point is handled exactly once:

- Points outside the free interval are preserved.
- Points inside the free interval are removed.
- Intervals spanning both sides of the free interval are correctly split into two.

Since no new overlaps are introduced after splitting, the resulting intervals remain sorted, non-overlapping, and minimal.

---

# Dry Run

### Input

```
occupiedIntervals = [[2,6],[4,8],[10,10],[10,12],[14,16]]
freeStart = 7
freeEnd = 11
```

### Step 1: Merge Intervals

| Current Interval | Action | Merged Intervals |
|------------------|--------|------------------|
| [2,6] | Start merging | |
| [4,8] | Overlaps with [2,6] | [2,8] |
| [10,10] | New interval | [2,8] |
| [10,12] | Overlaps with [10,10] | [2,8], [10,12] |
| [14,16] | New interval | [2,8], [10,12], [14,16] |

Merged intervals:

```
[2,8], [10,12], [14,16]
```

### Step 2: Remove Free Interval [7,11]

| Interval | Result |
|----------|--------|
| [2,8] | [2,6] |
| [10,12] | [12,12] |
| [14,16] | Unchanged |

Final answer:

```
[[2,6],[12,12],[14,16]]
```

---

# Complexity Analysis

- **Time Complexity:** `O(n log n)`
    - Sorting the intervals takes `O(n log n)`.
    - Merging and filtering each require a single linear traversal.

- **Space Complexity:** `O(n)`
    - In the worst case, all intervals remain separate after merging, requiring additional space for the merged intervals and the final result.
