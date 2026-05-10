---
id: 134
title: "Gas Station"
difficulty: Medium
tags: [array, greedy]
date: 2026-05-010
link: https://leetcode.com/problems/gas-station
---

## Problem

There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].


You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.


Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.




Example 1:

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4

Travel to station 4. Your tank = 4 - 1 + 5 = 8

Travel to station 0. Your tank = 8 - 2 + 1 = 7

Travel to station 1. Your tank = 7 - 3 + 2 = 6

Travel to station 2. Your tank = 6 - 4 + 3 = 5

Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.

Therefore, return 3 as the starting index.

Example 2:


Input: gas = [2,3,4], cost = [3,4,3]

Output: -1

Explanation:

You can't start at station 0 or 1, as there is not enough gas to travel to the next station.

Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4

Travel to station 0. Your tank = 4 - 3 + 2 = 3

Travel to station 1. Your tank = 3 - 3 + 3 = 3

You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.

Therefore, you can't travel around the circuit once no matter where you start.


Constraints:

n == gas.length == cost.length
1 <= n <= 105
0 <= gas[i], cost[i] <= 104
The input is generated such that the answer is unique.



## Approach

**Pattern used:** Greedy

---

### Core Idea

At each station:

* Gain = `gas[i]`
* Spend = `cost[i]`
* Net contribution:
  `diff = gas[i] - cost[i]`

Two important observations:

1. If total gas < total cost:

    * Completing the circuit is impossible

2. If starting from some station causes tank to become negative:

    * Any station between previous start and current index also cannot be valid starts

This allows a greedy reset.

---

### Step-by-step

### 1. Track overall feasibility

`total += gas[i] - cost[i]`

* If total is negative after full traversal:

    * impossible → return `-1`

---

### 2. Simulate current journey

`tank += diff`

* Represents remaining gas while traveling

---

### 3. Reset when journey fails

If `tank < 0`:

* Current start cannot work
* Any station between old start and current index also cannot work

So:

* Set next station as new candidate:
  `start = i + 1`
* Reset tank to 0

---

### Why resetting works

Suppose:

* You started at `start`
* Failed at `i`

That means:

sum(start → i) < 0

Now consider any station `k` between `start` and `i`.

Since:

* You already accumulated negative balance before reaching `i`
* Starting later would only reduce available gas

So none of them can succeed.

This is the key greedy insight.

---

### Edge Cases

* Total gas < total cost → return `-1`
* Single station → works naturally
* Exact balance (`total == 0`) → valid if traversal possible

---

## Complexity

**Time Complexity:** O(n)

* Single traversal

---

**Space Complexity:** O(1)

---

## Optimization Insight

Brute force:

* Try every starting station
* O(n²)

Greedy reduces this to:

* O(n)

by eliminating impossible ranges at once.

---

## Final Take

* Classic greedy optimization problem
* The reset logic is the key insight
* Optimal and interview-standard solution

---

**Q1:** Why does failing at index `i` invalidate all stations between `start` and `i`?
**Q2:** Can there be multiple valid starting stations?
**Q3:** How would this problem change if gas could become negative temporarily?


