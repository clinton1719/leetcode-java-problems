---
id: 129
title: "Sum Root to Leaf Numbers"
difficulty: Medium
tags: [tree, binary-tree, dfs]
date: 2026-06-30
link: https://leetcode.com/problems/sum-root-to-leaf-numbers
---

## Problem

You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.



Example 1:


Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:


Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.


Constraints:

The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 9
The depth of the tree will not exceed 10.


# Intuition

Each root-to-leaf path represents a number formed by concatenating the digits along the path.

Instead of treating the tree as individual nodes, we can think of each path as building a number digit by digit while traversing from the root to a leaf.

A Depth-First Search (DFS) naturally fits this problem because it allows us to explore one complete root-to-leaf path at a time.

Whenever a leaf node is reached, the constructed number is complete and can be added to the final sum.

---

# Approach

- Perform a DFS starting from the root.
- Maintain a sequence representing the digits encountered along the current root-to-node path.
- At each node:
    - Append the current digit to the sequence.
- If the current node is a leaf:
    - Convert the accumulated digits into a number.
    - Add the number to the final answer.
- Otherwise:
    - Recursively visit the left child.
    - Remove the last digit while backtracking.
    - Recursively visit the right child.
    - Remove the last digit while backtracking.

Backtracking ensures that after exploring one subtree, the digit corresponding to that subtree is removed before exploring another path.

---

# Why Does This Work?

DFS guarantees that every root-to-leaf path is visited exactly once.

The sequence of digits maintained during traversal always represents the current path from the root to the current node.

When a leaf is reached, this sequence forms exactly one valid root-to-leaf number, which is added to the total.

Backtracking restores the sequence to its previous state after returning from a recursive call, ensuring that each path is constructed independently without affecting other paths.

Since every root-to-leaf path is processed once and contributes exactly one number, the final sum is correct.

---

# Dry Run

### Input

```
        1
       / \
      2   3
```

Root-to-leaf paths:

- 1 → 2 → 12
- 1 → 3 → 13

| Current Path | Leaf? | Number Formed | Running Sum |
|--------------|-------|---------------|------------:|
| 1 | No | — | 0 |
| 1 → 2 | Yes | 12 | 12 |
| 1 → 3 | Yes | 13 | 25 |

Final answer:

```
25
```

---

# Complexity Analysis

- **Time Complexity:** `O(n × h)`
    - Each node is visited once during DFS.
    - For every leaf, converting the accumulated digits into a number takes `O(h)`, where `h` is the height of the tree. In the worst case, this results in `O(n × h)`.

- **Space Complexity:** `O(h)`
    - The recursion stack and the path representation store at most one root-to-leaf path at any time, where `h` is the height of the tree.