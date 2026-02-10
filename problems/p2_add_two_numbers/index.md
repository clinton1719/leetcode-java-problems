---
id: 2
title: "Add Two Numbers"
difficulty: Medium
tags: [linked-list, recursion, math]
date: 2026-02-10
link: https://leetcode.com/problems/add-two-numbers
---

## Problem
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

## Approach

A dummy node is used to simplify construction of the result list.
The two linked lists are traversed simultaneously, representing digits of two numbers in reverse order.
At each step, the current digits and the carry from the previous addition are summed.
The new digit (`sum % 10`) is added as a node to the result list, and the carry (`sum / 10`) is updated.
The loop continues as long as there are remaining nodes in either list or a non-zero carry, ensuring all digits are processed.

This approach simulates elementary addition digit by digit.

## Complexity

* **Time:** O(max(n, m))
* **Space:** O(max(n, m))


