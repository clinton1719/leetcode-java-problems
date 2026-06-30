---
id: 3976
title: "Maximum Subarray Sum After Multiplier"
difficulty: Medium
tags: [kadanes-algorithm, algorithm, dynamic-programming]
date: 2026-06-30
link: https://leetcode.com/problems/maximum-subarray-sum-after-multiplier
---

## Problem

You are given an integer array nums and a positive integer k.

You must choose exactly one subarray of nums and perform exactly one of the following operations:

Multiply each number in the chosen subarray by k.
Divide each number in the chosen subarray by k.
When dividing a positive number by k, use the floor value of the division result.
When dividing a negative number by k, use the ceiling value of the division result.
Return the maximum possible sum of a non-empty subarray in the resulting array.

Note that the subarray chosen for the operation and the subarray chosen for the sum may be different.



Example 1:

Input: nums = [1,-2,3,4,-5], k = 2

Output: 14

Explanation:

Multiply each number in the subarray [3, 4] by 2.
This results in nums = [1, -2, 6, 8, -5].
The subarray with the largest sum is [6, 8], so the output is 6 + 8 = 14.
Example 2:

Input: nums = [-5,-4,-3], k = 2

Output: -1

Explanation:

Divide each number in the subarray [-3] by 2.
This results in nums = [-5, -4, -1].
The subarray with the largest sum is [-1], so the output is -1.


Constraints:

1 <= nums.length <= 105
-105 <= nums[i] <= 105
1 <= k <= 105


# Intuition

The operation (multiply or divide) must be applied to **exactly one contiguous subarray**, while the maximum sum subarray in the final array may be different.

This means that during our traversal, we need to know whether we are:

1. **Before applying the operation**
2. **Currently inside the operated subarray**
3. **After finishing the operation**

These three stages naturally lead to a Dynamic Programming solution.

Since the problem asks us to consider **either multiplying or dividing**, we solve the problem twice—once assuming multiplication and once assuming division—and return the larger result.

---

# Approach

For each pass (multiply or divide), maintain three DP states:

- **State 0:** Maximum subarray sum ending at the current index without starting the operation.
- **State 1:** Maximum subarray sum ending at the current index while the operation is currently being applied.
- **State 2:** Maximum subarray sum ending at the current index after the operation has already finished.

For every element:

- Update the first state using the standard Kadane's Algorithm.
- Update the second state by considering:
    - Starting the operation at the current element.
    - Extending an already active operated subarray.
    - Starting the operation immediately after a normal subarray.
- Update the third state by considering:
    - Ending the operated subarray before the current element.
    - Extending a normal subarray after the operation has finished.
    - Starting a completely new subarray.

After processing each element, update the overall maximum among all three states.

Finally:

- Compute the answer assuming multiplication.
- Compute the answer assuming division.
- Return the larger of the two.

---

# Why Does This Work?

At every index, every valid maximum subarray must belong to exactly one of three situations:

1. The operation has **not started**.
2. The operation is **currently active**.
3. The operation has **already finished**.

These three states cover every possible placement of the required operated subarray.

The transitions between states ensure that:

- The operation starts exactly once.
- The operated subarray remains contiguous.
- Once the operation ends, it cannot start again.

Since every possible valid configuration is represented by one of these DP states, and each transition considers all legal ways to extend or begin a subarray, the algorithm guarantees the optimal answer.

Running the DP twice ensures that both allowed operations (multiplication and division) are evaluated independently, and taking the maximum gives the best possible result.

---

# Dry Run

### Input

```
nums = [1, -2, 3, 4, -5]
k = 2
```

### Multiplication Pass

| Element | State 0 (Normal) | State 1 (During Operation) | State 2 (After Operation) | Best So Far |
|---------:|-----------------:|---------------------------:|--------------------------:|------------:|
| 1 | 1 | 2 | 1 | 2 |
| -2 | -1 | -2 | 0 | 2 |
| 3 | 3 | 6 | 3 | 6 |
| 4 | 7 | 14 | 10 | 14 |
| -5 | 2 | 4 | 9 | 14 |

The maximum subarray sum after multiplying is:

```
14
```

The division pass produces a smaller value, so the final answer is:

```
14
```

---

# Complexity Analysis

- **Time Complexity:** `O(n)`
    - Each pass processes the array once, and the algorithm performs two passes (multiply and divide). This is still linear.

- **Space Complexity:** `O(1)`
    - Only a constant number of DP variables are maintained regardless of the input size.