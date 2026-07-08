---
id: 102
title: "Binary Tree Level Order Traversal"
difficulty: Medium
tags: [tree, binary-tree, bfs]
date: 2026-07-08
link: https://leetcode.com/problems/binary-tree-level-order-traversal
---

## Problem

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Example 1:
![img.png](img.png)


Input: root = [3,9,20,null,null,15,7]

Output: [[3],[9,20],[15,7]]

Example 2:


Input: root = [1]

Output: [[1]]

Example 3:


Input: root = []

Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000


# Intuition

Level Order Traversal visits the tree **level by level**, starting from the root and moving downward.

Since nodes are processed in the order they are discovered, a **Queue** is the ideal data structure because it follows the **First-In-First-Out (FIFO)** principle.

The key idea is to process all nodes currently in the queue before moving to the next level. The queue size at the beginning of each iteration tells us exactly how many nodes belong to the current level.

---

# Approach

- If the tree is empty, return an empty list.
- Initialize a queue and insert the root node.
- While the queue is not empty:
    - Determine the number of nodes in the current level using the queue's size.
    - Process exactly those nodes:
        - Remove each node from the front of the queue.
        - Add its value to the current level's list.
        - Insert its left and right children into the queue if they exist.
    - After processing all nodes of the current level, add the level's list to the final answer.
- Continue until all levels have been processed.

---

# Why Does This Work?

The queue always stores nodes in the order they should be visited.

At the start of each iteration, the queue contains **only the nodes of the current level**. Recording the queue size before processing ensures that newly added child nodes are not processed immediately but are deferred to the next iteration.

This guarantees that:

- Every node is visited exactly once.
- Nodes are grouped according to their level.
- The traversal proceeds from top to bottom and from left to right within each level.

Thus, the algorithm correctly produces the level order traversal of the binary tree.

---

# Dry Run

### Input

```
        3
       / \
      9   20
         /  \
        15   7
```

| Queue Before Level | Nodes Processed | Level Output | Queue After Level |
|--------------------|-----------------|--------------|-------------------|
| [3] | 3 | [3] | [9, 20] |
| [9, 20] | 9, 20 | [9, 20] | [15, 7] |
| [15, 7] | 15, 7 | [15, 7] | [] |

Final answer:

```
[
  [3],
  [9, 20],
  [15, 7]
]
```

---

# Complexity Analysis

- **Time Complexity:** `O(n)`
    - Every node is visited exactly once during the traversal.

- **Space Complexity:** `O(n)`
    - In the worst case, the queue stores all nodes at the widest level of the tree, and the output also contains all nodes.




