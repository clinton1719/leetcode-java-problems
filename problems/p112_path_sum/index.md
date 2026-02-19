---
id: 112
title: "Path Sum"
difficulty: Easy
tags: [binary-tree, tree, dfs, bfs]
date: 2026-02-19
link: https://leetcode.com/problems/path-sum
---

## Problem

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

![img.png](img.png)

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There are two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000

## Approach

We use Depth-First Search (DFS).

At each node:
1. If the node is null → return false.
2. If it is a leaf node:
   Check whether its value equals the remaining targetSum.
3. Otherwise:
   Subtract the node's value from targetSum.
   Recursively check left and right subtrees.

If either subtree returns true → a valid path exists.


## Complexity

Time: O(n)
We may visit every node once.

Space: O(h)
Where h is the height of the tree.
Worst case (skewed tree): O(n)
Balanced tree: O(log n)





