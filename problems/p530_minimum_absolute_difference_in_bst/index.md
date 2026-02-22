---
id: 530
title: "Minimum Absolute Difference in BST"
difficulty: Easy
tags: [binary-tree, tree, inorder-traversal]
date: 2026-02-22
link: https://leetcode.com/problems/minimum-absolute-difference-in-bst
---

## Problem

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.



Example 1:
![img.png](img.png)

Input: root = [4,2,6,1,3]
Output: 1

Example 2:
![img_1.png](img_1.png)

Input: root = [1,0,48,null,null,12,49]
Output: 1


Constraints:

The number of nodes in the tree is in the range [2, 104].
0 <= Node.val <= 105


Note: This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

## Approach

This problem relies on a key property of a Binary Search Tree (BST):

Inorder traversal of a BST produces values in sorted order.

Key Idea:
The minimum absolute difference between any two nodes in a BST
must occur between two adjacent values in the sorted (inorder) sequence.

Algorithm:

1. Perform an inorder traversal (Left → Node → Right).
2. Keep track of the previously visited node (`prev`).
3. At each node:
    - Compute the difference:
      node.val - prev.val
    - Update `minDifference` if smaller.
4. Update `prev` to the current node.
5. Return `minDifference`.

Because inorder traversal visits nodes in ascending order,
we only need to compare adjacent nodes.

## Complexity
Time: O(n)
Each node is visited exactly once.

Space: O(h)
Due to recursion stack.
Worst case (skewed tree): O(n)
Balanced tree: O(log n)

