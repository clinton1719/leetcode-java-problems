---
id: 222
title: "Count Complete Tree Nodes"
difficulty: Easy
tags: [binary-tree, complete-binary-tree, algorithm]
date: 2026-02-21
link: https://leetcode.com/problems/count-complete-tree-nodes
---

## Problem

Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.



Example 1:
![img.png](img.png)

Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1


Constraints:

The number of nodes in the tree is in the range [0, 5 * 104].
0 <= Node.val <= 5 * 104
The tree is guaranteed to be complete.

## Approach

This solution takes advantage of properties of a Complete Binary Tree.

Key Idea:
In a complete binary tree, if the height of the leftmost path
equals the height of the rightmost path, the tree is a Perfect Binary Tree.

For a perfect binary tree with height h:
Number of nodes = 2^h - 1

Algorithm:

1. If root is null → return 0.
2. Compute:
   leftHeight  → by going fully left.
   rightHeight → by going fully right.
3. If leftHeight == rightHeight:
   The tree is perfect.
   Return **2^h - 1**.
4. Otherwise:
   Recursively count nodes in left and right subtrees:
   return 1 + countNodes(left) + countNodes(right)

This avoids traversing every node when subtrees are perfect.

## Complexity

Time: O((log n)^2)

Why?
- Computing height takes O(log n).
- In worst case, we do this height computation at each level.
- There are O(log n) levels.

So total = log n * log n = (log n)^2


## Explanation:

### 1. What is "Log n"?

In computer science,  (base 2) basically means: **"How many times can I cut this number in half before I reach 1?"**

* If you have 8 nodes, you can cut it in half 3 times (). So, .
* In a tree,  is the **height** of the tree. To get from the root to a leaf, you only take  steps.

### 2. Why is your code ?

Your algorithm does two things nested inside each other:

#### Part A: The Vertical Search ()

Every time you call `countNodes`, you run two `while` loops (`findLeftHeight` and `findRightHeight`).

* These loops travel from the top of a subtree straight down to the bottom.
* Since the tree height is , these loops take ** time**.

#### Part B: The Horizontal Search ()

Because you only recurse when the `leftHeight` doesn't match the `rightHeight`, you aren't visiting every single node in the tree. In a **Complete Binary Tree**, you will only ever "break" the perfect subtree logic along **one path** down the tree (the path leading to the last level's gap).

* You only perform the recursive call on a few nodes along the height of the tree.
* The number of times you "stop and check heights" is roughly ** times**.

### Putting it together

Since you are doing a  height check **at every step** of a  deep traversal, you multiply them:


---

### Comparison Table

| Algorithm | Time Complexity | What it's actually doing |
| --- | --- | --- |
| **Standard Recursion** |  | Visits **every single node** once. |
| **Your Optimized Version** |  | Only visits nodes along the "edges," skipping entire subtrees. |

**Fun Fact:**  is significantly faster than . If you had 1,000,000 nodes,  takes 1,000,000 operations, while  only takes about 400!

Would you like me to show you a trace of exactly which nodes the code visits using a small example tree?


