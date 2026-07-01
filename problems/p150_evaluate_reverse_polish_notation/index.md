---
id: 150
title: "Evaluate Reverse Polish Notation"
difficulty: Medium
tags: [stack, math]
date: 2026-07-01
link: https://leetcode.com/problems/evaluate-reverse-polish-notation
---

## Problem

You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.


Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22


Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].


# Intuition

In Reverse Polish Notation (RPN), operators always appear **after** their operands.

This means that while traversing the expression from left to right:

- Every number is stored for future use.
- Whenever an operator is encountered, it operates on the **two most recent numbers**.

A stack is the perfect data structure for this because it follows the **Last-In-First-Out (LIFO)** principle.

---

# Approach

- Traverse the array of tokens from left to right.
- For each token:
    - If it is a number, push it onto the stack.
    - If it is an operator:
        - Pop the top two elements from the stack.
        - The first popped value is the **second operand**, while the second popped value is the **first operand**.
        - Perform the corresponding operation.
        - Push the result back onto the stack.
- After processing all tokens, the stack contains exactly one element, which is the final result.

---

# Why Does This Work?

Reverse Polish Notation eliminates the need for parentheses because the position of each operator uniquely determines its operands.

The stack always maintains all intermediate results that are waiting to participate in future operations.

Whenever an operator is encountered:

- The two most recent operands are exactly the two values on top of the stack.
- Performing the operation and pushing the result back preserves the correct evaluation order.

By the end of the traversal, every operation has been evaluated exactly once, leaving only the final answer on the stack.

---

# Dry Run

### Input

```
tokens = ["2", "1", "+", "3", "*"]
```

| Token | Operation | Stack |
|-------|-----------|-------|
| 2 | Push | [2] |
| 1 | Push | [2, 1] |
| + | Pop 1 and 2 → Push 3 | [3] |
| 3 | Push | [3, 3] |
| * | Pop 3 and 3 → Push 9 | [9] |

Final answer:

```
9
```

---

# Complexity Analysis

- **Time Complexity:** `O(n)`
    - Each token is processed exactly once, and every stack operation takes constant time.

- **Space Complexity:** `O(n)`
    - In the worst case, the stack may store all operands before any operators are processed.
