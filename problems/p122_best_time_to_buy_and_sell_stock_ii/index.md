---
id: 122
title: "Best Time to Buy and Sell Stock II"
difficulty: Medium
tags: [array, dynamic-programming]
date: 2025-12-08
link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
---

## Problem
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.

Find and return the maximum profit you can achieve.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.


Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104

## Approach

This solution calculates the **maximum profit with unlimited transactions** (you may buy and sell multiple times, but you must sell before you buy again).

### Key idea
Instead of trying to find valleys and peaks explicitly, the algorithm **captures every profitable upward movement**:

- If today’s price is higher than yesterday’s, take the profit.
- Add up all such positive differences.

This works because:
- Any sequence of increasing prices can be split into multiple small profits.
- The sum of these small profits equals the profit from buying at the start and selling at the peak.
- There is no benefit in skipping intermediate gains when transactions are unlimited.

This greedy approach is optimal and avoids unnecessary complexity.

---

## Complexity

* **Time:** `O(n)`
    - Single pass through the price array.

* **Space:** `O(1)`
    - Only a variable to accumulate profit is used.

