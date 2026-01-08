---
id: 26
title: "Best Time to Buy and Sell Stock"
difficulty: Easy
tags: [array, dynamic-programming]
date: 2025-12-08
link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock
---

## Problem

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104

## Approach

This problem is solved using a **single-pass greedy strategy**.

The goal is to maximize profit by choosing the best day to buy and a later day to sell. Since selling must occur after buying, we track the minimum price seen so far and compute the profit for each day relative to that minimum.

We maintain two variables:

* `buy` stores the minimum stock price encountered so far.
* `maxProfit` stores the maximum profit achievable up to the current day.

Invariant maintained during iteration:

* `buy` is always the lowest price among all previous days.
* `maxProfit` is the maximum profit achievable using prices seen so far.

Algorithm steps:

* Initialize `buy` to a very large value and `maxProfit` to 0.
* Iterate through each price in the array:

    * Compute the profit if the stock were sold at the current price (`price - buy`).
    * Update `maxProfit` if this profit is greater than the current maximum.
    * Update `buy` if the current price is lower than the previous minimum.
* After the loop completes, `maxProfit` contains the maximum possible profit.

This approach ensures the buy operation always occurs before the sell operation and avoids unnecessary nested loops.

## Complexity

* **Time:** O(n)
  Each price is processed exactly once.

* **Space:** O(1)
  Only constant extra variables are used.

