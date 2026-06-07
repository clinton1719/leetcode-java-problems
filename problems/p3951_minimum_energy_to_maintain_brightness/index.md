---
id: 3951
title: "Minimum Energy to Maintain Brightness"
difficulty: Medium
tags: [math, greedy]
date: 2026-06-07
link: https://leetcode.com/problems/minimum-energy-to-maintain-brightness
---

## Problem
You are given an integer n, representing n light bulbs arranged in a line and indexed from 0 to n - 1.

You are also given an integer brightness and a 2D integer array intervals, where intervals[i] = [starti, endi] represents an inclusive time interval during which the lighting requirement must be satisfied.


At each time unit, every bulb can independently be either on or off. A bulb that is on illuminates its own position and its adjacent positions, if they exist.


The total illumination at a time unit is the number of illuminated positions. Each position is counted at most once.


For every integer time unit covered by at least one interval in intervals, the total illumination must be at least brightness. At time units not covered by any interval, all bulbs may remain off. Each bulb that is on consumes 1 unit of energy for that time unit.


Return an integer denoting the minimum total energy required.



Example 1:

Input: n = 5, brightness = 5, intervals = [[6,12]]

Output: 14

Explanation:

Turn on the light bulbs at positions 1 and 4.

Current state of line: 0 1 0 0 1.

All 5 positions are illuminated, so the required brightness is reached.


The active interval has length 12 - 6 + 1 = 7, so the total energy is 2 * 7 = 14.

Example 2:


Input: n = 2, brightness = 1, intervals = [[0,0],[2,2]]


Output: 2


Explanation:


Turn on one light bulb during each active interval.

Each interval has length 1, so the total active time is 1 + 1 = 2.

The total energy is 1 * 2 = 2.

Example 3:


Input: n = 4, brightness = 2, intervals = [[1,3],[2,4]]


Output: 4


Explanation:


Turn on one light bulb. It can illuminate at least 2 positions.

The active intervals overlap, so the total active time is the length of [1,4], which is 4.

The total energy is 1 * 4 = 4.



Constraints:

1 <= n <= 106
1 <= brightness <= n
1 <= intervals.length <= 105
intervals[i] == [starti, endi]
0 <= starti <= endi <= 109


# Approach

**Pattern used:** Greedy + Interval Merging + Mathematical Observation

### Core Idea

The key observation is that the lighting requirement is identical for every time unit covered by any interval.

Instead of considering each time unit separately:

1. Determine the minimum number of bulbs needed to achieve the required brightness.
2. Count how many time units actually require lighting.
3. Multiply them together.

### Key Insight 1: Illumination per Bulb

A single bulb can illuminate at most:

* Its own position
* Left neighbor
* Right neighbor

So one bulb contributes to at most **3 illuminated positions**.

To achieve illumination ≥ `brightness`, the minimum bulbs needed at any time unit is:

(longBulbsNeeded) = ceil(brightness / 3)

Using integer arithmetic:

longBulbsNeeded = (brightness + 2) / 3

Examples:

* brightness = 1 → 1 bulb
* brightness = 3 → 1 bulb
* brightness = 4 → 2 bulbs
* brightness = 7 → 3 bulbs

### Key Insight 2: Merge Overlapping Intervals

Lighting is required during every time unit covered by at least one interval.

Overlapping intervals should not be counted multiple times.

Example:

[1,5]
[3,8]

Together cover only:

[1,8]

not 11 time units.

Therefore:

1. Sort intervals by start time.
2. Merge overlapping or adjacent intervals.
3. Count the total covered time units.

### Step-by-Step

#### 1. Handle Special Case

If:

brightness == 0

No illumination is required, so return 0.

#### 2. Sort Intervals

Sort by start time so overlapping intervals become easy to merge.

#### 3. Merge Intervals

Maintain:

* start = current merged interval start
* end = current merged interval end

For each interval:

* If it overlaps or touches the current interval:

  interval.start <= end + 1

  extend the merged interval.

* Otherwise:

    * Add the length of the previous merged interval.
    * Start a new merged interval.

#### 4. Count Covered Time Units

For an inclusive interval:

[start, end]

length is:

end - start + 1

Accumulate lengths of all merged intervals.

#### 5. Compute Minimum Bulbs Needed

Each bulb covers up to 3 positions:

longBulbsNeeded = (brightness + 2L) / 3

#### 6. Compute Energy

At every covered time unit we need exactly the minimum number of bulbs.

Therefore:

energy = coveredTimeUnits × longBulbsNeeded

### Why It Works

The problem does not require tracking individual bulb positions over time.

Only two facts matter:

1. How many time units require lighting.
2. The minimum bulbs needed during each such time unit.

Since the requirement is identical for every covered time unit, the optimal strategy is to use exactly the minimum number of bulbs whenever lighting is required.

### Subtle Detail

The merge condition uses:

intervals[i][0] <= end + 1

This merges both:

* Overlapping intervals
* Directly adjacent intervals

For counting discrete time units, intervals like:

[1,3] and [4,5]

cover a continuous set of required times:

1,2,3,4,5

so they can be treated as a single merged interval.
# Complexity

**Time Complexity:** O(m log m)

* Sorting the `m` intervals takes O(m log m).
* Merging takes O(m).

Overall: O(m log m)

**Space Complexity:** O(1)

* Only a few variables are used during merging.
* Ignoring the space used internally by the sorting algorithm.
