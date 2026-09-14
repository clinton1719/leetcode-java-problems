---
id: 210
title: "Course Schedule II"
difficulty: Medium
tags: [graph, topological-sort, tricky, algorithm, directed-acylic-graph, kahns-algorithm]
date: 2026-09-14
link: https://leetcode.com/problems/course-schedule-ii
---

## Problem

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]


Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.



# Intuition

This problem is an extension of **Course Schedule**.

In Course Schedule, we only need to determine whether all courses can be completed. Here, we additionally need to return a valid order in which the courses can be taken.

The key idea is to use **Topological Sorting with Kahn's Algorithm**.

A course with `indegree = 0` has no remaining prerequisites, so it can be taken immediately. After completing that course, we remove it as a prerequisite from its dependent courses.

The order in which courses are removed from the queue becomes the required course order.

---

# Approach

### Step 1: Build the Graph

For every prerequisite relationship:

```text
[course, prerequisite]
```

create a directed edge:

```text
prerequisite → course
```

Also maintain an `indegree` for every course.

The indegree represents how many prerequisites are still required before that course can be taken.

---

### Step 2: Find Courses With No Prerequisites

Add every course with an indegree of `0` to a queue.

These courses can be taken immediately.

---

### Step 3: Perform Topological Sort

While the queue is not empty:

- Remove a course from the queue.
- Add it to the answer.
- Visit every course that depends on it.
- Decrease the dependent course's indegree.
- If its indegree becomes `0`, add it to the queue.

The resulting order is a valid course completion order.

---

### Step 4: Detect a Cycle

Keep track of how many courses were added to the answer.

If all `numCourses` courses are processed, return the generated order.

If fewer than `numCourses` courses are processed, some courses are part of a cycle and therefore cannot be completed.

In that case, return an empty array.

---

# Why Does This Work?

A course can only be taken when all of its prerequisites have been completed.

The indegree tells us exactly how many prerequisites are still outstanding.

Initially, every course with indegree `0` is safe to take. Once we process such a course, we effectively satisfy one prerequisite for each dependent course.

When a dependent course's indegree reaches `0`, all of its prerequisites have been completed, so it can safely be added to the ordering.

Therefore, every course added to the answer appears only after all of its prerequisites.

If a cycle exists, none of the courses inside that cycle can reach an indegree of `0`, so they will never be processed. Consequently, the number of processed courses will be smaller than `numCourses`.

Thus, the algorithm either produces a valid topological ordering or correctly identifies that no valid ordering exists.

---

# Dry Run

### Input

```text
numCourses = 4

prerequisites =
[
    [1,0],
    [2,0],
    [3,1],
    [3,2]
]
```

Graph:

```text
0 → 1
↓   ↓
2 → 3
```

Initial indegrees:

| Course | Indegree |
|-------:|---------:|
| 0 | 0 |
| 1 | 1 |
| 2 | 1 |
| 3 | 2 |

Initial queue:

```text
[0]
```

### Processing

| Course Processed | Indegree Changes | Queue | Answer |
|------------------:|------------------|-------|--------|
| 0 | 1→0, 2→0 | [1, 2] | [0] |
| 1 | 3: 2→1 | [2] | [0, 1] |
| 2 | 3: 1→0 | [3] | [0, 1, 2] |
| 3 | None | [] | [0, 1, 2, 3] |

All four courses were processed, so the ordering is valid.

One possible answer is:

```text
[0, 1, 2, 3]
```

---

# Complexity Analysis

- **Time Complexity:** `O(V + E)`
    - Building the graph takes `O(E)`.
    - Every course is processed once.
    - Every prerequisite edge is examined once.

- **Space Complexity:** `O(V + E)`
    - The adjacency list stores all prerequisite relationships.
    - The indegree array, queue, and result array require `O(V)` additional space.

Where:

- `V` = number of courses.
- `E` = number of prerequisite relationships.