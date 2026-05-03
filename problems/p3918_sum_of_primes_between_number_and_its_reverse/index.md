---
id: 3918
title: "Sum of Primes Between Number and Its Reverse"
difficulty: Medium
tags: [sieve-of-eratosthenes-algorithm, algorithm, math, counting]
date: 2026-05-03
link: https://leetcode.com/problems/sum-of-primes-between-number-and-its-reverse
---

## Problem

You are given an integer n.

Let r be the integer formed by reversing the digits of n.

Return the sum of all prime numbers between min(n, r) and max(n, r), inclusive.

A prime number is a natural number greater than 1 with only two factors, 1 and itself.



Example 1:


Input: n = 13

Output: 132

Explanation:

The reverse of 13 is 31. Thus, the range is [13, 31].

The prime numbers in this range are 13, 17, 19, 23, 29, and 31.

The sum of these prime numbers is 13 + 17 + 19 + 23 + 29 + 31 = 132.

Example 2:


Input: n = 10


Output: 17

Explanation:

The reverse of 10 is 1. Thus, the range is [1, 10].

The prime numbers in this range are 2, 3, 5, and 7.

The sum of these prime numbers is 2 + 3 + 5 + 7 = 17.

Example 3:


Input: n = 8

Output: 0

Explanation:

The reverse of 8 is 8. Thus, the range is [8, 8].

There are no prime numbers in this range, so the sum is 0.



Constraints:

1 <= n <= 1000


## Approach

**Pattern used:** Sieve of Eratosthenes + Range Aggregation

---

### Core Idea

Instead of checking each number individually for primality, you:

1. **Reverse the number**
2. Define the range `[start, end]`
3. Use **Sieve of Eratosthenes** to precompute all primes up to `end`
4. Sum primes within the required range

---

### Step-by-step

### 1. Reverse the number

* Build reversed using:
  `reversed = reversed * 10 + (n % 10)`

---

### 2. Define range

* `start = min(original, reversed)`
* `end = max(original, reversed)`

---

### 3. Handle small edge case

* If `end < 2` → no primes → return 0

---

### 4. Build sieve

* Create boolean array `isPrime[]`

* Initialize all to `true`

* Mark:

    * `0` and `1` → not prime

* For each `i` from `2 → √end`:

    * If `isPrime[i]`:

        * Mark multiples starting from `i*i`

---

### 5. Compute sum

* Iterate from `start → end`
* Add all numbers where `isPrime[i] == true`

---

### Key Insights

* Sieve avoids repeated √n checks → much faster
* Starting from `i*i` avoids redundant marking
* Works well when range is large

---

### Subtle Details

* `i * i <= end` avoids overflow and unnecessary work
* `j = i * i` is critical optimization
  (smaller multiples already handled)

---

### Edge Cases

* `n = 0` or `1` → returns 0
* Reverse shrinks range (e.g., 1000 → 1)
* `n == reversed` → single number range

---

## Complexity

**Time Complexity:**
O(N log log N)

* N = `end`

---

**Space Complexity:**
O(N)

* Sieve array

---

## Optimization Insight

If multiple queries exist:

* Precompute sieve once up to max possible value
* Use **prefix sum of primes** to answer each query in O(1)
---

**Q1:** How would you use prefix sums to make multiple queries O(1)?
**Q2:** Why is starting from `i*i` sufficient in the sieve?
**Q3:** When would this approach become memory inefficient?


