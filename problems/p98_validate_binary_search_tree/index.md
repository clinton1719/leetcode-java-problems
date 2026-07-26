---
id: 98
title: "Validate Binary Search Tree"
difficulty: Medium
tags: [binary-tree, tree, dfs]
date: 2026-07-26
link: https://leetcode.com/problems/validate-binary-search-tree
---

## Problem

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys strictly less than the node's key.
The right subtree of a node contains only nodes with keys strictly greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1


# Intuition

A Binary Search Tree (BST) satisfies more than just the relationship between a node and its immediate children.

For every node:

- All values in its left subtree must be **strictly smaller** than the node.
- All values in its right subtree must be **strictly larger** than the node.

Simply comparing a node with its children is not enough because a violation may occur deeper in the tree.

The idea is to maintain the **valid range** that every node is allowed to take. As we move down the tree, this range becomes smaller based on the values of its ancestors.

---

# Approach

- Start the traversal with the widest possible range.
- For every node:
    - Check whether its value lies strictly within the current valid range.
    - If it does not, the tree is not a valid BST.
- Recursively validate:
    - The left subtree with an updated upper bound equal to the current node's value.
    - The right subtree with an updated lower bound equal to the current node's value.
- If every node satisfies its allowed range, the tree is a valid BST.

Using `long` values for the bounds prevents overflow when the tree contains nodes with the minimum or maximum possible integer values.

---

# Why Does This Work?

Each recursive call carries the constraints imposed by all ancestor nodes.

For a node:

- It must be greater than every ancestor for which it lies in the right subtree.
- It must be smaller than every ancestor for which it lies in the left subtree.

Passing the valid range downward ensures these conditions are preserved throughout the traversal.

If any node violates its allowed range, it means it breaks the BST property with respect to one of its ancestors, so the tree cannot be a valid BST.

Since every node is checked exactly once against the correct bounds, the algorithm correctly determines whether the tree is a valid BST.

---

# Dry Run

### Input

```
        5
       / \
      3   7
     / \   \
    2   4   8
```

| Node | Valid Range | Valid? |
|-----:|-------------|--------|
| 5 | (-∞, +∞) | ✓ |
| 3 | (-∞, 5) | ✓ |
| 2 | (-∞, 3) | ✓ |
| 4 | (3, 5) | ✓ |
| 7 | (5, +∞) | ✓ |
| 8 | (7, +∞) | ✓ |

Every node satisfies its range, so the tree is a valid BST.

---

### Invalid Example

```
        5
       / \
      3   7
         /
        4
```

| Node | Valid Range | Valid? |
|-----:|-------------|--------|
| 5 | (-∞, +∞) | ✓ |
| 7 | (5, +∞) | ✓ |
| 4 | (5, 7) | ✗ |

Although `4` is smaller than its parent `7`, it is also in the **right subtree of 5**, so it must be greater than `5`. Since it violates this constraint, the tree is not a valid BST.

---

# Complexity Analysis

- **Time Complexity:** `O(n)`
    - Every node is visited exactly once during the traversal.

- **Space Complexity:** `O(h)`
    - The recursion stack stores at most one root-to-leaf path, where `h` is the height of the tree.
    - In the worst case of a skewed tree, this becomes `O(n)`.

