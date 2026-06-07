---
id: 3954
title: "Sum of Compatible Numbers in Range I"
difficulty: Easy
tags: [bit-manipulation]
date: 2026-06-07
link: https://leetcode.com/problems/sum-of-compatible-numbers-in-range-i
---

## Problem


You are given two integers n and k.

A positive integer x is called compatible if it satisfies both of the following conditions:

abs(n - x) <= k
(n & x) == 0
Return the sum of all compatible integers x.

Note:

Here, & denotes the bitwise AND operator.
The absolute difference between integers i and j is defined as abs(i - j).


Example 1:

Input: n = 2, k = 3

Output: 10

Explanation:

The compatible integers are:

x = 1, since abs(2 - 1) = 1 and 2 & 1 = 0.
x = 4, since abs(2 - 4) = 2 and 2 & 4 = 0.
x = 5, since abs(2 - 5) = 3 and 2 & 5 = 0.
Thus, the answer is 1 + 4 + 5 = 10.

Example 2:

Input: n = 5, k = 1

Output: 0

Explanation:

There are no compatible integers in the range [4, 6]. Thus, the answer is 0.



Constraints:

1 <= n <= 100
1 <= k <= 100


# Approach

**Pattern used:** Brute Force Enumeration + Bit Manipulation

### Core Idea

A number `x` is compatible if:

1. `abs(n - x) <= k`
2. `(n & x) == 0`

The first condition restricts `x` to a small range around `n`.

The solution simply checks every integer in that range and adds the ones that satisfy the bitwise condition.

### Key Insight

The condition:

(n & x) == 0

means that `n` and `x` do not share any bit position where both have a `1`.

Example:

n = 10 = 1010₂

x = 5 = 0101₂

1010
0101
----

0000

Since the AND result is 0, `x` is compatible.

---

### Step-by-Step

#### 1. Check Numbers Greater Than n

Start with:

x = n + 1

Continue while:

abs(n - x) <= k

For each value:

* If `(n & x) == 0`, add it to the answer.
* Increment `x`.

This examines all integers in:

[n + 1, n + k]

---

#### 2. Check Numbers Smaller Than n

Start with:

x = n - 1

Continue while:

abs(n - x) <= k

For each value:

* If `(n & x) == 0`, add it to the answer.
* Decrement `x`.

The extra check:

x < 0

prevents examining negative numbers.

This covers:

[max(0, n - k), n - 1]

---

#### 3. Why n Itself Is Not Checked

The loops intentionally start from:

* `n + 1`
* `n - 1`

So `x = n` is excluded.

This is correct because:

n & n = n

For a positive integer `n`, this is never `0`.

Therefore `n` can never be compatible.

---

### Why It Works

The compatible integers must lie within distance `k` from `n`.

The algorithm exhaustively checks every such candidate exactly once and verifies the bitwise requirement directly.

Since every valid candidate is considered and every invalid candidate is rejected, the resulting sum is correct.

### Edge Cases

* `k = 0`

    * No values are checked.
    * Answer is 0.

* `n = 0`

    * Every number with distance ≤ k satisfies `(0 & x) == 0`.

* No compatible numbers exist.

    * Answer remains 0.

* Lower range would become negative.

    * The `x < 0` check stops the search.

# Complexity

**Time Complexity:** O(k)

* Up to `k` numbers above `n` are checked.
* Up to `k` numbers below `n` are checked.
* Each check is O(1).

Overall: O(k)

**Space Complexity:** O(1)

* Only a few integer variables are used.
