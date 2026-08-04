---
id: 399
title: "Evaluate Division"
difficulty: Medium
tags: [tricky, dfs, graph]
date: 2026-08-03
link: https://leetcode.com/problems/evaluate-division
---

## Problem
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.



Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
note: x is undefined => -1.0
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]


Constraints:

1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.


# Intuition

Each equation represents a relationship between two variables.

For example,

```
a / b = 2
```

can be viewed as a directed edge:

```
a --2--> b
```

Since

```
b / a = 1/2
```

we also create the reverse edge.

After constructing these relationships, the problem becomes:

> Find a path from the numerator to the denominator.

The answer is simply the **product of all edge weights** along that path.

A Depth-First Search (DFS) is well suited for exploring these paths.

---

# Approach

### Step 1: Build the Graph

Treat every variable as a graph node.

For every equation:

- Add an edge from the numerator to the denominator with the given value.
- Add the reverse edge with the reciprocal of that value.

This creates a bidirectional weighted graph.

---

### Step 2: Process Each Query

For every query:

- If either variable does not exist in the graph, return `-1`.
- Otherwise, perform a DFS starting from the numerator.

During DFS:

- Maintain the product of all edge weights along the current path.
- Mark visited nodes to avoid revisiting them and forming cycles.
- If the destination is reached, return the accumulated product.
- If no valid path exists, return `-1`.

Repeat this process for every query.

---

# Why Does This Work?

Each edge represents a valid mathematical ratio between two variables.

Suppose we have:

```
a / b = 2
b / c = 3
```

Traversing from `a` to `c` gives:

```
a → b → c
```

The required ratio becomes

```
a / c

= (a / b) × (b / c)

= 2 × 3

= 6
```

Thus, multiplying the edge weights along a path correctly computes the required division result.

DFS explores every reachable path while the visited set prevents infinite recursion caused by cycles.

If a path exists, DFS eventually reaches the destination and returns the accumulated product. If no path exists, every reachable node is explored before returning `-1`.

Therefore, the algorithm correctly answers every query.

---

# Dry Run

### Input

```
Equations:

a / b = 2
b / c = 3

Queries:

a / c
c / a
a / e
```

### Graph

```
a --2--> b
b --1/2--> a

b --3--> c
c --1/3--> b
```

---

### Query 1: a / c

| Current Node | Product |
|--------------|--------:|
| a | 1 |
| b | 2 |
| c | 6 |

Answer:

```
6
```

---

### Query 2: c / a

| Current Node | Product |
|--------------|--------:|
| c | 1 |
| b | 1/3 |
| a | 1/6 |

Answer:

```
0.166666...
```

---

### Query 3: a / e

Node `e` does not exist in the graph.

Answer:

```
-1
```

---

# Complexity Analysis

Let:

- `V` = Number of variables (graph nodes)
- `E` = Number of equations (graph edges)
- `Q` = Number of queries

- **Time Complexity:** `O(E + Q × (V + E))`
    - Building the graph takes `O(E)`.
    - In the worst case, each DFS may visit every node and edge.

- **Space Complexity:** `O(V + E)`
    - The graph stores all variables and edges.
    - The recursion stack and visited set together use at most `O(V)` space during a DFS.