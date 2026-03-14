---
id: 155
title: "Min Stack"
difficulty: Medium
tags: [stack, design]
date: 2026-03-14
link: https://leetcode.com/problems/min-stack
---

## Problem

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.



Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2


Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.


## Approach

The goal is to design a stack that supports the following operations in **O(1) time**:

- push
- pop
- top
- getMin (retrieve the minimum element in the stack)

### Key Idea

Each node in the stack stores **two values**:

1. `val` → the actual value pushed into the stack
2. `min` → the **minimum value in the stack up to that node**

This means every node knows the **minimum of all elements below it including itself**.

---

### How Push Works

When inserting a new value:

- If the stack is empty  
  The node becomes the head and its `min` is the value itself.

- Otherwise  
  The new node’s `min` is:

min(val, head.min)

So the node stores the **minimum between the new value and the previous minimum**.

Then the new node becomes the **new head of the stack**.

---

### How Pop Works

Pop simply moves the head pointer:

head = head.next

Since each node already stores the correct minimum for that level, the new head automatically represents the correct minimum.

---

### How Top Works

Return the value stored at the head:

head.val

---

### How getMin Works

Return the minimum stored at the head:

head.min

Because each node stores the minimum up to that point, the head always holds the **current stack minimum**.

---

### Why This Works

Instead of searching the entire stack to find the minimum, the minimum is **precomputed and stored in every node**.  
So retrieving it takes **constant time**.

---

## Complexity

### Time Complexity

push → O(1)  
pop → O(1)  
top → O(1)  
getMin → O(1)

All operations only manipulate the head node.

---

### Space Complexity

O(n)

Each pushed element creates a node storing:

- value
- current minimum
- next pointer





