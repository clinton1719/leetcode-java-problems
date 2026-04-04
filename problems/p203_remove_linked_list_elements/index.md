---
id: 203
title: "Remove Linked List Elements"
difficulty: Easy
tags: [linked-list, recursion]
date: 2026-04-04
link: https://leetcode.com/problems/remove-linked-list-elements
---

## Problem

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.



Example 1:
![img.png](img.png)

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []


Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50

## Approach

**Pattern used:** Linked List Traversal + Dummy Node (Filter Pattern)

### Core Idea

You need to **remove all nodes with a given value**.

Instead of deleting nodes in-place with tricky pointer handling, build a **filtered list**:

* Keep nodes that do NOT match `val`
* Skip nodes that match

---

### Step-by-step

1. **Create dummy node**

    * `start → new list`
    * Helps avoid edge cases (like removing head)

2. **Initialize pointer**

    * `current` → builds the result list

---

3. **Traverse original list**

While `head != null`:

### Case 1: Keep node

* If `head.val != val`

    * Link it:
      `current.next = head`
    * Move `current` forward

---

### Case 2: Remove node

* If `head.val == val`

    * Do nothing (skip it)

---

4. **Move forward**

* Always advance:
  `head = head.next`

---

5. **Terminate list**

* `current.next = null`
  👉 Important to break any leftover links

---

6. **Return result**

* `start.next`

---

### Key Insights

* This is a **filtering problem**
* Dummy node avoids special handling for head removal
* Reusing existing nodes → no extra memory for nodes

---

### Subtle Details

* You only move `current` when keeping a node
* Explicitly setting `current.next = null` avoids unintended links
* You are NOT creating new nodes → just rewiring

---

### Example

Input:
1 → 2 → 6 → 3 → 4 → 5 → 6
val = 6

Process:

* Skip 6’s
* Keep others

Output:
1 → 2 → 3 → 4 → 5

---

### Edge Cases

* All nodes match → return null
* No nodes match → return original list
* Head nodes match → handled by dummy node
* Single node → removed or kept correctly

---

## Complexity

**Time Complexity:** O(n)

* Traverse list once

---

**Space Complexity:** O(1)

* No extra space (in-place reuse)

---

## Optimization

### Alternative (In-place deletion without dummy)

You could:

* First remove matching nodes from head
* Then traverse and delete

But:

* Requires extra checks
* More error-prone

👉 Dummy node approach is cleaner and safer

---

**Q1:** How would you modify this to remove nodes based on a condition (e.g., even numbers)?
**Q2:** What happens if you forget to set `current.next = null` at the end?
**Q3:** Can this pattern be generalized to filter nodes in other data structures?

