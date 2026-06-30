---
id: 3974
title: "Maximum Total Sum of K Selected Elements"
difficulty: Medium
tags: [greedy, array, sorting]
date: 2026-06-28
link: https://leetcode.com/problems/maximum-total-sum-of-k-selected-elements
---

## Problem

You are given an integer array nums and two integers k and mul.

Select exactly k elements from nums. Process these elements one by one in any order you choose.

For each selected element, independently choose one of the following:

Add the element's value to the total sum, or
Multiply the element by the current value of mul and add the result to the total sum.
After processing each selected element, mul decreases by 1, regardless of which option was chosen. The current value of mul may become 0 or negative.

Return an integer denoting the maximum possible total sum.



Example 1:

Input: nums = [6,1,2,9], k = 3, mul = 2

Output: 26

Explanation:

One optimal way:

One optimal selection is nums[3] = 9, nums[0] = 6, and nums[2] = 2.
Process nums[3] = 9 first: choose multiplication, so it contributes 9 * 2 = 18. Now, mul becomes 1.
Process nums[0] = 6 next: choose multiplication, so it contributes 6 * 1 = 6. Now, mul becomes 0.
Process nums[2] = 2 last: choose addition, so it contributes 2.
The total sum is 18 + 6 + 2 = 26.
Example 2:

Input: nums = [3,7,5,2], k = 2, mul = 4

Output: 43

Explanation:

One optimal way:

One optimal selection is nums[1] = 7 and nums[2] = 5.
Process nums[1] = 7 first: choose multiplication, so it contributes 7 * 4 = 28. Now, mul becomes 3.
Process nums[2] = 5 next: choose multiplication, so it contributes 5 * 3 = 15.
The total sum is 28 + 15 = 43.
Example 3:

Input: nums = [4,4], k = 1, mul = 1

Output: 4

Explanation:

One optimal way:

One optimal selection is nums[0] = 4.
Process nums[0] = 4: choose multiplication, so it contributes 4 * 1 = 4.
The total sum is 4.


Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
1 <= k <= nums.length
1 <= mul <= 105


# Intuition

Since all elements in `nums` are **positive**, multiplying a larger number by a larger multiplier always produces a greater contribution than multiplying a smaller number.

The available multipliers are:

```
mul, mul-1, mul-2, ...
```

These values decrease after every processed element.

Therefore:

- The **largest selected number** should receive the **largest multiplier**.
- The second largest number should receive the second largest multiplier.
- And so on.

When the current multiplier becomes `0` or negative, multiplying no longer increases the value of a positive number.

For any positive number `x`:

```
x * 0 = 0 < x
x * (-1) < x
```

So from that point onward, it is always better to simply add the number instead of multiplying it.

---

# Approach

1. Sort the array in ascending order.
2. Start selecting elements from the end (largest elements first).
3. For each selected element:
    - If the current multiplier is positive, multiply the element by it.
    - Otherwise, simply add the element.
4. Decrease the multiplier after processing each element.
5. Continue until exactly `k` elements have been processed.

---

# Why does the Greedy Strategy Work?

Suppose we have two numbers:

```
a > b
```

and two multipliers

```
m1 > m2
```

Compare the two possible assignments.

### Assignment 1

```
a × m1 + b × m2
```

### Assignment 2

```
a × m2 + b × m1
```

The difference is

```
(a × m1 + b × m2)
-
(a × m2 + b × m1)

= (a - b)(m1 - m2)
```

Since

```
a > b
m1 > m2
```

both terms are positive, so

```
(a - b)(m1 - m2) > 0
```

Therefore,

```
a × m1 + b × m2
>
a × m2 + b × m1
```

This proves that assigning larger multipliers to larger numbers is always optimal.


---

# Complexity Analysis

- **Time Complexity:** `O(n log n)`
    - Sorting the array dominates the runtime.

- **Space Complexity:** `O(1)`
    - Only a few extra variables are used (excluding the space used by the sorting algorithm).
 
