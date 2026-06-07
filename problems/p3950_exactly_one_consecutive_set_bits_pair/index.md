---
id: 3950
title: "Exactly One Consecutive Set Bits Pair"
difficulty: Easy
tags: [bit-manipulation]
date: 2026-06-07
link: https://leetcode.com/problems/exactly-one-consecutive-set-bits-pair
---

## Problem

You are given an integer n.

Return true if its binary representation contains exactly one pair of consecutive set bits, and false otherwise.



Example 1:

Input: nums = 6

Output: true

Explanation:

Binary representation of 6 is 110.
There is exactly one pair of consecutive set bits ("11"). Thus, the answer is true​​​​​​​.
Example 2:

Input: nums = 5

Output: false

Explanation:

Binary representation of 5 is 101.
There are no consecutive set bits. Thus, the answer is false​​​​​​​.


Constraints:

0 <= n <= 105


# Approach

**Pattern used:** Bit Manipulation

### Core Idea

The expression:

n & (n >> 1)

is a classic bit-manipulation trick used to detect consecutive set bits.

When `n` is shifted right by one position, every pair of adjacent `1`s in the original number overlaps. Performing an AND operation keeps only those positions that were part of a consecutive `11` pair.

### Step-by-Step

1. Shift the number right by one bit:

   n >> 1

2. Perform:

   n & (n >> 1)

3. Every consecutive pair `11` in the original number contributes exactly one set bit to the result.

Example:

n = 14

Binary:

1110

Shift right:

0111

AND:

1110
0111
----

0110

The result contains 2 set bits, meaning there are 2 consecutive pairs:

* bits 3 and 2
* bits 2 and 1

4. Count the set bits in the result:

   Integer.bitCount(n & (n >> 1))

5. Return `true` only if the count equals `1`.

### Why It Works

Each set bit in:

n & (n >> 1)

represents one adjacent `11` pair in the original binary representation.

Therefore:

* Count = 0 → no consecutive set bits
* Count = 1 → exactly one consecutive pair
* Count > 1 → multiple consecutive pairs

### Examples

n = 6

Binary:

110

n >> 1:

011

AND:

010

bitCount = 1

Return `true`

---

n = 14

Binary:

1110

AND result:

0110

bitCount = 2

Return `false`

---

n = 10

Binary:

1010

AND result:

0000

bitCount = 0

Return `false`

### Key Insight

The trick:

n & (n >> 1)

converts the problem of detecting adjacent set bits into simply counting set bits in the resulting number.

# Complexity

**Time Complexity:** O(1)

* Integer operations are performed on a fixed-size 32-bit integer.
* `Integer.bitCount()` runs in constant time for Java integers.

**Space Complexity:** O(1)

* Only a few integer variables are used.
