---
id: 3961
title: "Maximize Sum of Device Ratings"
difficulty: Medium
tags: [greedy, sorting, array]
date: 2026-06-14
link: https://leetcode.com/problems/maximize-sum-of-device-ratings
---

## Problem

You are given a 2D integer array units of size m × n where units[i][j] represents the capacity of the jth unit in the ith device. Each device contains exactly n units.

The rating of a device is the minimum capacity among all its units.

You may perform the following operation any number of times (including zero):

Choose a device i that has not been used as a source before.
Remove exactly one unit from device i and add it to any different device.
Then mark device i as used, so it cannot be chosen again as a source.
Return the maximum possible sum of the ratings of all devices after any number of such operations.

Note:

Devices can receive units from multiple devices, regardless of whether they have been selected.
The rating of an empty device is 0.


Example 1:

Input: units = [[1,3],[2,2]]

Output: 4

Explanation:

​​​​​​​​​​​​​​Select device i = 0 and transfer units[0][0] = 1 to device i = 1.
After the transfer, the ratings are:
Device 0 = [3]: rating[0] = 3
Device 1 = [2, 2, 1]: rating[1] = 1
Thus, the sum of ratings is 3 + 1 = 4.
Example 2:

Input: units = [[1,2,3],[4,5,6]]

Output: 6

Explanation:

Select device i = 1 and transfer units[1][0] = 4 to device i = 0.
After the transfer, the ratings are:
Device 0 = [1, 2, 3, 4]: rating[0] = 1
Device 1 = [5, 6]: rating[1] = 5
Thus, the sum of ratings is 1 + 5 = 6.
Example 3:

Input: units = [[5,5,5],[1,1,1]]

Output: 6

Explanation:

No transfers increase the sum of ratings. Thus, the sum of ratings is 5 + 1 = 6.


Constraints:

1 <= m == units.length <= 105
1 <= n == units[i].length <= 105
m * n <= 2 * 105
1 <= units[i][j] <= 105


# Approach

**Pattern used:** Greedy + Mathematical Observation

### Core Idea

The rating of a device is its minimum unit capacity.

If we sort a device:

[a, b, c, ...]

its rating is:

a

If we remove exactly one unit from that device, the best unit to remove is always the smallest one (`a`), because that increases the rating from:

a → b

where `b` is the second smallest element.

So every device has two possible contributions:

* Don't donate → contribute smallest element
* Donate smallest element → contribute second smallest element

The entire problem becomes deciding which device should keep its smallest element and which devices should upgrade to their second smallest element.

---

### Key Observation 1

After sorting each row:

row[0] = smallest element
row[1] = second smallest element

If a device donates its smallest element:

rating becomes row[1]

Therefore, for maximum rating, we'd like every device to contribute its second smallest element.

That would give:

sum(second smallest of every row)

---

### Key Observation 2

Where do all removed minimum elements go?

Any donated unit decreases the receiver's rating if it is smaller than the receiver's current minimum.

To minimize damage, all donated minimum elements should ultimately end up in a single device.

That device's rating becomes the smallest donated value.

Since every row donates its smallest element, the final minimum among donated values is simply:

global minimum across all devices

Thus one device must end up with rating:

globalMin

instead of its second smallest element.

---

### Key Observation 3

Which device should absorb all donated units?

Suppose a device currently contributes:

secondSmallest

After receiving the donated minimums, its contribution becomes:

globalMin

Loss:

secondSmallest - globalMin

To maximize the final answer, choose the device with the smallest second-smallest value.

That minimizes the loss.

So we replace:

minSecond

with:

globalMin

in the total.

---

### Step-by-Step

#### 1. Handle n = 1

If every device has only one unit:

* Removing that unit would make the source device empty.
* Rating becomes 0.

No useful upgrade exists.

The answer is simply the sum of all values.

---

#### 2. Sort Every Row

For each device:

Arrays.sort(row)

Now:

* row[0] = minimum
* row[1] = second minimum

---

#### 3. Track Three Quantities

##### globalMin

Smallest value among all devices.

##### minSecond

Smallest second-minimum among all devices.

##### secondElemSum

Sum of all second-minimum values.

---

#### 4. Compute Final Answer

Start with:

secondElemSum

This assumes every device upgraded to its second minimum.

One device must absorb all donated units, causing its rating to become:

globalMin

instead of:

minSecond

Therefore:

answer = secondElemSum - minSecond + globalMin

which is exactly:

globalMin + secondElemSum - minSecond

### Example

units = [[1,3],[2,2]]

After sorting:

[1,3]
[2,2]

globalMin = 1

second minimums:

3, 2

secondElemSum = 5

minSecond = 2

Answer:

5 - 2 + 1 = 4

### Why It Works

Every useful operation removes the smallest element of a device and upgrades its rating to the second smallest element.

All removed elements can be concentrated into a single receiver.

Only that receiver's rating is affected, and it becomes the smallest donated value.

Therefore the optimal configuration is:

* Every device contributes its second smallest value.
* Except one device, whose contribution becomes the global minimum.

Choosing the device with the smallest second-smallest value minimizes the loss.


# Complexity

Let:

* m = number of devices
* n = number of units per device

**Time Complexity:** O(m × n log n)

* Each row is sorted independently.
* Sorting one row costs O(n log n).
* There are m rows.

Overall:

O(m × n log n)

**Space Complexity:** O(1)

* Only a few variables are maintained.
* Ignoring the space used internally by the sorting algorithm.
