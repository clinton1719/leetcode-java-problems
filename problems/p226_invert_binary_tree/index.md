---
id: 226
title: "Invert Binary Tree"
difficulty: Easy
tags: [binary-tree, tree, dfs, bfs]
date: 2026-02-17
link: https://leetcode.com/problems/invert-binary-tree
---

## Problem

Given the root of a binary tree, invert the tree, and return its root.

![img.png](img.png)

Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

## Approach

We use Depth-First Search (DFS) recursion.

At each node:
1. Swap the left and right children.
2. Recursively invert the left subtree.
3. Recursively invert the right subtree.
4. Return the root.

The recursion naturally processes every node exactly once.

## Complexity

Time: O(n)
Each node is visited once.

Space: O(h)
Where h is the height of the tree.
Worst case (skewed tree): O(n)
Best case (balanced tree): O(log n)




