---
id: 3931
title: "Check Adjacent Digit Differences"
difficulty: Easy
tags: [string]
date: 2026-06-07
link: https://leetcode.com/problems/check-adjacent-digit-differences
---

## Problem

You are given a string s consisting of digits.

Return true if the absolute difference between every pair of adjacent digits is at most 2, otherwise return false.


The absolute difference between a and b is defined as abs(a - b).



Example 1:


Input: s = "132"

Output: true

Explanation:

The absolute difference between digits at s[0] and s[1] is abs(1 - 3) = 2.

The absolute difference between digits at s[1] and s[2] is abs(3 - 2) = 1.

Since both differences are at most 2, the answer is true.


Example 2:


Input: s = "129"

Output: false

Explanation:

The absolute difference between digits at s[0] and s[1] is abs(1 - 2) = 1.

The absolute difference between digits at s[1] and s[2] is abs(2 - 9) = 7, which is greater than 2.

Therefore, the answer is false.



Constraints:

2 <= s.length <= 100
s consists only of digits.


# Approach

**Pattern used:** Linear Scan (Adjacent Pair Validation)

### Core Idea

The solution checks whether every pair of adjacent characters differs by at most 2.

It scans the string once and compares each character with the previous one. If any adjacent pair has an absolute difference greater than 2, the string is invalid and we immediately return `false`.

### Step-by-Step

1. Start from index `1`.

2. Compare the current character with the previous character.

3. Compute:

   difference = s.charAt(i) - s.charAt(i - 1)

4. Take the absolute value using `Math.abs()`.

5. If the difference is greater than `2`, return `false`.

6. If the loop finishes, return `true`.

### Key Insights

* Every adjacent pair must satisfy the condition.
* A single violation makes the answer `false`.
* Early termination avoids unnecessary work.
* `Math.abs()` handles both increasing and decreasing character values.

### Edge Cases

* Empty string → valid
* Single character → valid
* Difference exactly `2` → valid
* Negative differences are handled correctly by `Math.abs()`

### Why It Works

The algorithm directly verifies the required condition for every adjacent pair exactly once. If all pairs satisfy the constraint, the string is valid.

# Complexity

**Time Complexity:** O(n)

* We traverse the string once.
* Each iteration performs constant-time operations.

**Space Complexity:** O(1)

* Only a single integer variable is used.
* No extra data structures are required.
