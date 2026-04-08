---
id: 106
title: "Construct Binary Tree from Inorder And PostOrder Traversal"
difficulty: Medium
tags: [binary-tree, tree, inorder-traversal, preorder-traversal, divide-and-conquer]
date: 2026-04-07
link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
---

## Problem

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.



Example 1:
![img.png](img.png)


Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]

Output: [3,9,20,null,null,15,7]

Example 2:


Input: inorder = [-1], postorder = [-1]

Output: [-1]


Constraints:

1 <= inorder.length <= 3000
postorder.length == inorder.length
-3000 <= inorder[i], postorder[i] <= 3000
inorder and postorder consist of unique values.
Each value of postorder also appears in inorder.
inorder is guaranteed to be the inorder traversal of the tree.
postorder is guaranteed to be the postorder traversal of the tree.


## Approach

**Pattern used:** Tree Construction + Recursion (Divide & Conquer)

### Core Idea

You reconstruct the binary tree using:

* **Postorder** → gives root **last**
* **Inorder** → splits left and right subtrees

👉 Key property:

* Last element in postorder = root
* In inorder:

    * Left side = left subtree
    * Right side = right subtree

---

### Step-by-step

1. **Build hashmap for inorder**

    * `value → index`
    * Allows O(1) lookup instead of O(n)

---

2. **Initialize postorder index**

    * Start from end:
      `postorderIndex = n - 1`

---

3. **Recursive build**

#### Base condition

* If `inStart > inEnd` → return null

---

#### Pick root

* `value = postorder[postorderIndex--]`
* Create node

---

#### Find split point

* `index = inorderMap.get(value)`

---

#### Build subtrees

⚠️ Important order:

* **Right subtree first**
* Then **Left subtree**

👉 Because postorder is:
Left → Right → Root
When traversing backwards:
Root → Right → Left

---

4. **Return root**

---

### Example

Inorder:   [9, 3, 15, 20, 7]
Postorder: [9, 15, 7, 20, 3]

Process:

* Root = 3
* Split inorder:

    * Left → [9]
    * Right → [15, 20, 7]

Then:

* Build right subtree first (20)
* Then left (9)

---

### Key Insights

* Postorder determines **which node to pick**
* Inorder determines **how to split**
* Reversing postorder traversal forces:
  👉 Right subtree before left

---

### Subtle Details

* Order of recursion is critical:

    * Wrong order → incorrect tree
* Using hashmap avoids repeated scanning
* Using indices avoids array copying

---

### Edge Cases

* Empty arrays → return null
* Single node → leaf node
* Skewed tree → behaves like linked list

---

## Complexity

**Time Complexity:** O(n)

* Each node processed once
* Hashmap lookup → O(1)

---

**Space Complexity:** O(n)

* Hashmap → O(n)
* Recursion stack → O(n) worst case

---

**Q1:** Why must we build the right subtree before the left when using postorder?
**Q2:** What would break if we didn’t use a hashmap for inorder lookup?
**Q3:** How would this approach change for preorder + inorder reconstruction?
