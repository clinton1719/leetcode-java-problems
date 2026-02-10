---
id: 21
title: "Merge Two Sorted Lists"
difficulty: Easy
tags: [linked-list, recursion]
date: 2026-02-09
link: https://leetcode.com/problems/merge-two-sorted-lists
---

## Problem
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

## Approach

A dummy node is used to simplify edge cases when building the merged list.
Two pointers traverse the input lists, and at each step the node with the smaller value is appended to the result list.
The pointer of the chosen list is advanced, and the result pointer moves forward.
Once one of the lists is exhausted, the remaining nodes of the other list are directly attached, since they are already sorted.

This approach merges the lists in a single pass without creating new nodes.

## Complexity

* **Time:** O(n + m)
* **Space:** O(1)


## Approach 2 recursion

This solution uses recursion to merge the two sorted linked lists.
At each recursive call, the heads of both lists are compared.
The node with the smaller value is chosen as the head of the merged list, and its `next` pointer is set to the result of merging the remaining part of that list with the other list.
This process continues until one of the lists becomes null, at which point the remaining nodes of the other list are returned directly.

The recursion naturally preserves the sorted order of the merged list.

## Complexity

* **Time:** O(n + m)
* **Space:** O(n + m)


