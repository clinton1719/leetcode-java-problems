---
id: 207
title: "Course Schedule"
difficulty: Medium
tags: [graph, topological-sort, tricky, algorithm, directed-acylic-graph, kahns-algorithm]
date: 2026-08-04
link: https://leetcode.com/problems/course-schedule
---

## Problem

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.



# Intuition

Each course can be viewed as a node in a directed graph.

If a course depends on another course, we create a directed edge from the prerequisite to the dependent course.

For example,

```
Course 1 requires Course 0
```

becomes

```
0 → 1
```

A course can only be taken when all of its prerequisites have been completed.

This means we should always start with courses that have **no prerequisites** (indegree = 0).

This is exactly what **Topological Sorting (Kahn's Algorithm)** does.

If every course can be processed, it is possible to finish all courses. Otherwise, a cycle exists, making it impossible to complete every course.

---

# Approach

### Step 1: Build the Graph

- Create an adjacency list where each course stores the courses that depend on it.
- Maintain an **indegree array** where each value represents the number of prerequisites for a course.

---

### Step 2: Find Courses with No Prerequisites

- Traverse the indegree array.
- Add every course with indegree `0` to a queue.
- These courses can be taken immediately.

---

### Step 3: Process the Courses

While the queue is not empty:

- Remove a course from the queue.
- Count it as completed.
- Visit all courses that depend on it.
- Reduce their indegree since one prerequisite has now been completed.
- If a dependent course's indegree becomes `0`, add it to the queue.

---

### Step 4: Check the Result

- If the number of completed courses equals the total number of courses, every course can be finished.
- Otherwise, some courses were never processed because they belong to a cycle.

---

# Why Does This Work?

A course can only be taken after all its prerequisites have been completed.

The indegree of a node represents exactly how many prerequisites are still pending.

Initially, all courses with indegree `0` are immediately available. Once such a course is completed, it removes one prerequisite from each of its dependent courses by decreasing their indegree.

Eventually:

- If every course reaches indegree `0`, every course becomes available and can be completed.
- If a cycle exists, every course in the cycle always has at least one remaining prerequisite. Therefore, none of them ever reaches indegree `0`, and they can never be added to the queue.

Thus, the algorithm correctly determines whether all courses can be completed.

---

# Dry Run

### Input

```
numCourses = 4

prerequisites =
[
  [1,0],
  [2,0],
  [3,1],
  [3,2]
]
```

### Graph

```
0 → 1
0 → 2
1 → 3
2 → 3
```

### Initial Indegrees

| Course | Indegree |
|--------:|---------:|
| 0 | 0 |
| 1 | 1 |
| 2 | 1 |
| 3 | 2 |

Initial Queue:

```
[0]
```

### Processing

| Course Processed | Queue After Processing | Completed |
|-----------------:|------------------------|----------:|
| 0 | [1, 2] | 1 |
| 1 | [2] | 2 |
| 2 | [3] | 3 |
| 3 | [] | 4 |

All courses are processed.

Final answer:

```
true
```

---

### Cycle Example

```
0 → 1
1 → 0
```

Initial indegrees:

| Course | Indegree |
|--------:|---------:|
| 0 | 1 |
| 1 | 1 |

Queue:

```
[]
```

Since no course has indegree `0`, processing never begins.

Completed courses:

```
0
```

Since

```
0 ≠ numCourses
```

the answer is:

```
false
```

---

# Complexity Analysis

- **Time Complexity:** `O(V + E)`
    - Building the graph takes `O(E)`.
    - Each course is processed once, and each prerequisite edge is visited exactly once.

- **Space Complexity:** `O(V + E)`
    - The adjacency list stores all edges.
    - The indegree array and queue together require `O(V)` space.

Where:

- `V` = Number of courses.
- `E` = Number of prerequisite relationships.
