---
id: 105
title: "Construct Binary Tree from Preorder and Inorder Traversal"
difficulty: Medium
tags: [binary-tree, tree, inorder-traversal, preorder-traversal, divide-and-conquer]
date: 2026-04-07
link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
---

## Problem

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.



Example 1:
![img.png](img.png)

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]

Output: [3,9,20,null,null,15,7]

Example 2:


Input: preorder = [-1], inorder = [-1]

Output: [-1]



Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.



## Approach

**Pattern used:** Tree Construction + Recursion (Divide & Conquer)

### Core Idea

You reconstruct a binary tree using:

* **Preorder** → gives root first
* **Inorder** → splits left and right subtrees

👉 Key property:

* First element in preorder = root
* In inorder:

    * Left side = left subtree
    * Right side = right subtree

---

### Step-by-step

1. **Convert preorder to queue**

    * So you can always access the next root in O(1)

---

2. **Recursive build**

For each call:

#### a. Base condition

* If inorder is empty → return null

---

#### b. Pick root

* `rootElem = preorderQueue.poll()`

---

#### c. Find root in inorder

* Locate index of root in inorder array

---

#### d. Split inorder

* Left subtree → elements before index
* Right subtree → elements after index

---

#### e. Recursive calls

* Build left subtree first
* Then build right subtree

👉 Order matters because preorder is:
Root → Left → Right

---

### Example

Preorder: [3, 9, 20, 15, 7]
Inorder:  [9, 3, 15, 20, 7]

Process:

* Root = 3
* Inorder split:

    * Left → [9]
    * Right → [15, 20, 7]

Repeat recursively

---

### Key Insights

* Preorder drives **which node to create**
* Inorder determines **where to split**
* Recursion naturally builds the tree structure

---

### Subtle Details

* Left subtree MUST be built before right
* Using queue ensures correct preorder sequence
* `Arrays.copyOfRange()` creates new arrays → costly

---

### Edge Cases

* Empty arrays → return null
* Single node → leaf node
* Skewed tree → behaves like linked list

---

## Complexity

**Time Complexity:** O(n²)

* For each node:

    * `findIndex` → O(n)
    * `copyOfRange` → O(n)

👉 Total becomes quadratic

---

**Space Complexity:** O(n²)

* Recursive stack → O(n)
* Array copies at each step → O(n²)

---

## Optimization (Important)

### Optimal Approach: O(n)

1. Use a **HashMap** for inorder indices → O(1) lookup
2. Avoid array copying:

    * Pass `start` and `end` indices instead

---

### Why it's better

* No repeated scanning
* No array creation
* Clean and efficient recursion

---

### Optimized idea (high-level)

* Maintain `preIndex` pointer instead of queue
* Use hashmap for inorder index lookup
* Recurse using index ranges

---

**Q1:** Why does using indices instead of copying arrays drastically improve performance?
**Q2:** What happens if preorder and inorder arrays are inconsistent?
**Q3:** Can you reconstruct the tree using inorder + postorder instead, and how would it differ?


