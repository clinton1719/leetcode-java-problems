---
id: 53
title: "Maximum Subarray"
difficulty: Medium
tags: [array, dynamic-programming, greedy, kadanes-algorithm, algorithm]
date: 2026-06-28
link: https://leetcode.com/problems/maximum-subarray
---

## Problem

Given an integer array nums, find the subarray with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.



# Maximum Subarray (Kadane's Algorithm)

## Intuition

The key observation is that at every index, we have only **two choices**:

1. **Start a new subarray** from the current element.
2. **Extend the previous subarray** by including the current element.

If the previous running sum is negative, carrying it forward will only decrease the current sum. In that case, it is always better to start a new subarray from the current element.

---

## Approach

We maintain two variables:

- `currentSum` → Maximum subarray sum ending at the current index.
- `maxSum` → Maximum subarray sum found so far.

For every element:

- Either start a new subarray:
  ```java
  nums[i]
  ```

- Or continue the previous subarray:
  ```java
  currentSum + nums[i]
  ```

Choose the larger of the two:

```java
currentSum = Math.max(nums[i], currentSum + nums[i]);
```

Then update the overall maximum:

```java
maxSum = Math.max(maxSum, currentSum);
```

---

## Dry Run

**Input**

```text
nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
```

| Index | Element | currentSum | maxSum |
|------:|--------:|-----------:|-------:|
| 0 | -2 | -2 | -2 |
| 1 | 1 | max(1, -2+1)=1 | 1 |
| 2 | -3 | max(-3, 1-3)=-2 | 1 |
| 3 | 4 | max(4, -2+4)=4 | 4 |
| 4 | -1 | max(-1, 4-1)=3 | 4 |
| 5 | 2 | max(2, 3+2)=5 | 5 |
| 6 | 1 | max(1, 5+1)=6 | 6 |
| 7 | -5 | max(-5, 6-5)=1 | 6 |
| 8 | 4 | max(4, 1+4)=5 | 6 |

**Answer:** `6`

The maximum subarray is:

```text
[4, -1, 2, 1]
```

---

## Why Does This Work?

At every index, `currentSum` represents the **maximum subarray sum ending at that index**.

If the previous sum becomes negative, adding it to the current element would only make the result smaller. Therefore, we discard it and start a new subarray.

Meanwhile, `maxSum` stores the best answer seen throughout the traversal.

This greedy choice guarantees the optimal solution.

---

## Complexity Analysis

- **Time Complexity:** **O(n)**
    - We traverse the array exactly once.

- **Space Complexity:** **O(1)**
    - Only two variables (`currentSum` and `maxSum`) are used regardless of the input size.



