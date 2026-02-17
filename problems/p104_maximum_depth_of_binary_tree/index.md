---
id: 104
title: "Maximum Depth Of Binary Tree"
difficulty: Easy
tags: [binary-tree, bfs, dfs, tree]
date: 2026-02-17
link: https://leetcode.com/problems/maximum-depth-of-binary-tree
---

## Problem

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

![img.png](img.png)

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2


Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

## Approach 1 (BFS – Level Order Traversal)

We use a queue to perform level-order traversal.

Algorithm:
1. If root is null → return 0.
2. Add the root node to the queue.
3. While the queue is not empty:
    - Get the current level size.
    - Process all nodes in that level.
    - Add their children to the queue.
    - Increment depth after finishing each level.
4. Return depth.

Each iteration of the outer loop processes one level of the tree.

Time: O(n)
Each node is visited exactly once.

Space: O(n)
In the worst case (complete binary tree), the queue stores up to n/2 nodes.


## Approach 2 (DFS – Recursion)

We use recursion to compute the depth of left and right subtrees.

Algorithm:
1. If root is null → return 0.
2. Recursively compute:
   leftDepth = maxDepth(root.left)
   rightDepth = maxDepth(root.right)
3. Return:
   1 + max(leftDepth, rightDepth)

The +1 accounts for the current node.

Time: O(n)
Each node is visited once.

Space: O(h)
Where h is the height of the tree.
Worst case (skewed tree): O(n)
Best case (balanced tree): O(log n)



