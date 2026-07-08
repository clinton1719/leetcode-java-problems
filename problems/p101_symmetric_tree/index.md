---
id: 101
title: "Symmetric Tree"
difficulty: Easy
tags: [binary-tree, tree, dfs, bfs]
date: 2026-02-17
link: https://leetcode.com/problems/symmetric-tree
---

## Problem

Given the root of a binary tree, invert the tree, and return its root.

![img.png](img.png)

Example 1:

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false


Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100


Follow up: Could you solve it both recursively and iteratively?

# Intuition

The Lowest Common Ancestor (LCA) of two nodes is the **lowest node in the tree that has both nodes as descendants** (where a node can also be a descendant of itself).

Instead of searching for paths from the root to both nodes, we can use recursion to determine where the target nodes are located.

For every node, there are three possibilities:

- Both target nodes are in the left subtree.
- Both target nodes are in the right subtree.
- One target node is in each subtree.

The third case identifies the current node as the Lowest Common Ancestor.

---

# Approach

Perform a Depth-First Search (DFS) on the tree.

For each node:

1. If the current node is `null`, return `null`.
2. If the current node matches either `p` or `q`, return the current node.
3. Recursively search the left subtree.
4. Recursively search the right subtree.

After both recursive calls:

- If both left and right return a non-null node, the current node is the first place where the two targets meet, so it is the Lowest Common Ancestor.
- If only one side returns a non-null node, propagate that node upward.
- If both sides return `null`, propagate `null`.

The recursive calls continue until the root receives the final answer.

---

# Why Does This Work?

Each recursive call returns one of three values:

- `null` if neither target node exists in that subtree.
- One of the target nodes (or their Lowest Common Ancestor) if found in that subtree.
- The Lowest Common Ancestor itself once both targets have been discovered.

If one target is found in the left subtree and the other in the right subtree, the current node is the first node that connects both paths, making it the Lowest Common Ancestor.

If both targets lie entirely within one subtree, that subtree will eventually determine the Lowest Common Ancestor and propagate it upward unchanged.

Since every node is visited exactly once and all possible locations of the target nodes are considered, the algorithm always returns the correct Lowest Common Ancestor.

---

# Dry Run

### Input

```
          3
         / \
        5   1
       / \ / \
      6  2 0  8
        / \
       7   4

p = 5
q = 1
```

| Current Node | Left Result | Right Result | Returned Value |
|-------------:|-------------|--------------|----------------|
| 5 | 5 | null | 5 |
| 1 | null | 1 | 1 |
| 3 | 5 | 1 | 3 |

Final answer:

```
3
```

---

### Another Example

```
          3
         / \
        5   1
       / \
      6   2

p = 5
q = 6
```

| Current Node | Left Result | Right Result | Returned Value |
|-------------:|-------------|--------------|----------------|
| 6 | 6 | null | 6 |
| 5 | 6 | 5 | 5 |
| 3 | 5 | null | 5 |

Final answer:

```
5
```

Here, one of the target nodes (`5`) is an ancestor of the other (`6`), so it is the Lowest Common Ancestor.

---

# Complexity Analysis

- **Time Complexity:** `O(n)`
    - Every node is visited at most once during the DFS traversal.

- **Space Complexity:** `O(h)`
    - The recursion stack stores at most one root-to-leaf path, where `h` is the height of the tree.
    - In the worst case (a skewed tree), this becomes `O(n)`.




