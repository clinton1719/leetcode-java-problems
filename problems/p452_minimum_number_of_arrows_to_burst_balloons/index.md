---
id: 452
title: "Minimum Number of Arrows to Burst Balloons"
difficulty: Medium
tags: [intervals, greedy]
date: 2026-06-07
link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
---

## Problem

There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.


Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.


Given the array points, return the minimum number of arrows that must be shot to burst all balloons.



Example 1:

Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:

- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- 
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].


Example 2:


Input: points = [[1,2],[3,4],[5,6],[7,8]]

Output: 4

Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.

Example 3:


Input: points = [[1,2],[2,3],[3,4],[4,5]]

Output: 2

Explanation: The balloons can be burst by 2 arrows:

- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].


Constraints:

1 <= points.length <= 105
points[i].length == 2
-231 <= xstart < xend <= 231 - 1


# Approach

**Pattern used:** Greedy + Interval Intersection

### Core Idea

An arrow can burst every balloon whose interval contains the arrow's x-coordinate.

Therefore, if several balloons overlap, we can burst all of them with a single arrow shot somewhere inside their common overlap.

The greedy idea is to continuously maintain the intersection of all overlapping balloons currently being considered.

* If the next balloon overlaps this intersection, shrink the intersection.
* If it does not overlap, we must use a new arrow and start tracking a new overlap region.

### Step-by-Step

#### 1. Sort by Start Coordinate

Sort balloons by their left endpoint:

Arrays.sort(points, Comparator.comparingInt(a -> a[0]))

This ensures overlapping balloons appear together.

Example:

[1,6]
[2,8]
[7,12]

After sorting, overlapping groups become easy to detect.

---

#### 2. Track Current Overlap Region

Initialize:

point = points[0]

This represents the current common intersection where a single arrow can still burst all balloons seen so far.

---

#### 3. Process Remaining Balloons

For each balloon:

##### Case 1: Overlap Exists

If:

points[i][0] <= point[1]

the intervals overlap.

Example:

Current intersection:

[3,8]

Next balloon:

[5,10]

New intersection becomes:

[5,8]

So update:

point[0] = max(...)
point[1] = min(...)

This keeps only the region where one arrow can still hit every balloon in the group.

---

##### Case 2: No Overlap

If:

points[i][0] > point[1]

there is no common x-coordinate anymore.

A new arrow is required.

So:

* Increment arrow count.
* Start a new overlap region using the current balloon.

---

#### 4. Return arrows + 1

The code counts transitions between groups.

The first group always needs one arrow, so:

return arrows + 1

### Example

Input:

[1,6]
[2,8]
[7,12]
[10,16]

Start:

intersection = [1,6]

Process [2,8]:

intersection → [2,6]

Process [7,12]:

No overlap

arrows = 1

intersection = [7,12]

Process [10,16]:

intersection → [10,12]

Finished:

arrows + 1 = 2

Answer = 2

### Key Insight

For overlapping balloons, the exact arrow position does not matter.

What matters is the common region where an arrow could be placed.

By repeatedly shrinking the overlap interval, we preserve every possible valid arrow position.

When the overlap disappears, a new arrow becomes unavoidable.

### Subtle Detail

This solution modifies the original interval stored in `points`.

Specifically:

point[0] = ...
point[1] = ...

This is safe because the previous interval is never needed again.

However, many solutions prefer separate variables:

currentStart
currentEnd

to avoid mutating the input.



# Complexity

**Time Complexity:** O(n log n)

* Sorting takes O(n log n).
* The scan through all balloons takes O(n).

Overall:

O(n log n)

**Space Complexity:** O(1)

* Only a few variables are used.
* Ignoring the space used internally by the sorting algorithm.
