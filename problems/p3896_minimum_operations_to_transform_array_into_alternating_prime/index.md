---
id: 3896
title: "Minimum Operations to Transform Array into Alternating Prime"
difficulty: Medium
tags: [math, array]
date: 2026-04-11
link: https://leetcode.com/problems/minimum-operations-to-transform-array-into-alternating-prime
---

## Problem

You are given an integer array nums.

An array is considered alternating prime if:

Elements at even indices (0-based) are prime numbers.

Elements at odd indices are non-prime numbers.

In one operation, you may increment any element by 1.

Return the minimum number of operations required to transform nums into an alternating prime array.

A prime number is a natural number greater than 1 with only two factors, 1 and itself.



Example 1:

Input: nums = [1,2,3,4]

Output: 3

Explanation:

The element at index 0 must be prime. Increment nums[0] = 1 to 2, using 1 operation.

The element at index 1 must be non-prime. Increment nums[1] = 2 to 4, using 2 operations.

The element at index 2 is already prime.

The element at index 3 is already non-prime.

Total operations = 1 + 2 = 3.


Example 2:


Input: nums = [5,6,7,8]

Output: 0

Explanation:

The elements at indices 0 and 2 are already prime.

The elements at indices 1 and 3 are already non-prime.

No operations are needed.

Example 3:

Input: nums = [4,4]

Output: 1

Explanation:

The element at index 0 must be prime. Increment nums[0] = 4 to 5, using 1 operation.

The element at index 1 is already non-prime.

Total operations = 1.



Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105

## Approach

**Pattern used:** Greedy + Number Theory (Prime Checking)

### Core Idea

You must transform the array into:

* Even indices → **prime**
* Odd indices → **non-prime**

Each operation = increment by 1
👉 So for each element, the **optimal strategy is greedy**:

* Move it to the **nearest valid number ≥ current value**

---

### Step-by-step

1. **Traverse the array**

For each index `i`:

---

2. **Even index (i % 2 == 0) → need prime**

* If already prime → no cost
* Else:

    * Find next prime ≥ value
    * Add `(nextPrime - value)` to operations

---

3. **Odd index (i % 2 == 1) → need non-prime**

* If already non-prime → no cost
* Else:

    * Find next non-prime ≥ value
    * Add `(nextNonPrime - value)` to operations

---

4. **Return total operations**

---

### Key Insights

* Only **increment allowed**, so:
  👉 You must move forward (no backward optimization)
* Greedy works because:
  👉 Any delay in fixing a number only increases cost
* Each element is **independent** → no interaction between positions

---

### Subtle Details

* `nextPrime(n)` includes `n` itself if already prime
* `nextNonPrime(n)` includes `n` if already non-prime
* Prime check runs up to √n → efficient enough for moderate values

---

### Edge Cases

* Values < 2:

    * 0, 1 are non-prime
    * Even index → must increase to at least 2
* Large primes:

    * May require multiple increments to reach next non-prime
* Already valid array → 0 operations

---

## Complexity

**Time Complexity:** O(n × √m × k)

Where:

* n = array size
* m = max value in nums
* k = gap to next prime/non-prime (usually small)

Breakdown:

* Each `isPrime` → O(√m)
* `nextPrime` / `nextNonPrime` → may loop multiple times

---

**Space Complexity:** O(1)

* No extra space used

---

## Optimization

### Faster Prime Handling

Use **Sieve of Eratosthenes**:

* Precompute primes up to max(nums) + buffer
* Then:

    * Prime check → O(1)
    * Next prime → jump using precomputed array

This reduces complexity to roughly:
👉 O(n + m log log m)

---

### Even Better Insight

* Non-prime is very frequent → usually `val` or `val+1`
* Prime gaps are small → loops are short in practice

---

**Q1:** Why is greedy optimal here instead of trying global optimization?
**Q2:** How would performance change if nums values go up to 10⁹?
**Q3:** Can you precompute next prime and next non-prime for all values efficiently?







