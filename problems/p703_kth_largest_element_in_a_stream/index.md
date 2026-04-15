---
id: 703
title: "Kth Largest Element In A Stream"
difficulty: Easy
tags: [design, heap]
date: 2026-03-29
link: https://leetcode.com/problems/kth-largest-element-in-a-stream
---

## Problem

You are part of a university admissions office and need to keep track of the kth highest test score from applicants in real-time. This helps to determine cut-off marks for interviews and admissions dynamically as new applicants submit their scores

You are tasked to implement a class which, for a given integer k, maintains a stream of test scores and continuously returns the kth highest test score after a new score has been submitted. More specifically, we are looking for the kth highest score in the sorted list of all scores.

Implement the KthLargest class:

KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element in the pool of test scores so far.


Example 1:

Input:
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]

Output: [null, 4, 5, 5, 8, 8]

Explanation:

KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3); // return 4
kthLargest.add(5); // return 5
kthLargest.add(10); // return 5
kthLargest.add(9); // return 8
kthLargest.add(4); // return 8

Example 2:

Input:
["KthLargest", "add", "add", "add", "add"]
[[4, [7, 7, 7, 7, 8, 3]], [2], [10], [9], [9]]

Output: [null, 7, 7, 7, 8]

Explanation:

KthLargest kthLargest = new KthLargest(4, [7, 7, 7, 7, 8, 3]);
kthLargest.add(2); // return 7
kthLargest.add(10); // return 7
kthLargest.add(9); // return 7
kthLargest.add(9); // return 8


Constraints:

0 <= nums.length <= 104
1 <= k <= nums.length + 1
-104 <= nums[i] <= 104
-104 <= val <= 104
At most 104 calls will be made to add.

## Approach

**Pattern used:** Min Heap (Top K Elements)

### Core Idea

You need to continuously track the **k-th largest element** in a stream.

👉 Instead of storing all elements:

* Maintain a **min heap of size k**
* Heap always stores the **k largest elements seen so far**

So:

* The **smallest element in the heap = k-th largest overall**

---

### Step-by-step

### Constructor

1. **Initialize min heap**

    * Default PriorityQueue → min heap

---

2. **Process initial array**

For each number:

* Add to heap
* If size exceeds k → remove smallest

👉 Ensures heap always contains top k elements

---

3. **Store k**

* Needed for future operations

---

### add(val)

1. **Insert new value**

* `heap.add(val)`

---

2. **Maintain size k**

* If heap size > k → remove smallest

---

3. **Return k-th largest**

* `heap.peek()` → smallest in heap

---

### Key Insights

* Heap size never exceeds k → efficient
* You discard irrelevant smaller elements early
* `peek()` directly gives answer in O(1)

---

### Example

k = 3
Stream: [4, 5, 8, 2]

Heap after init → [4, 5, 8]

add(3):

* Heap → [3, 4, 5, 8] → remove 3 → [4,5,8]
* Answer = 4

---

### Subtle Details

* Heap stores only **useful elements**
* Smaller elements are discarded immediately
* Works efficiently even for large streams

---

### Edge Cases

* Initial nums < k → heap grows until size k
* Duplicate values → handled naturally
* Negative numbers → no issue

---

## Complexity

**Time Complexity:**

* Constructor → O(n log k)
* add() → O(log k)

---

**Space Complexity:** O(k)

* Heap stores at most k elements

---

## Optimization

This is already optimal for streaming:

* Better than sorting every time → O(n log n)
* Better than storing all elements → O(n) space

---

### Alternative

* Use max heap of size n → inefficient
* Use sorted structure → slower updates

👉 Min heap of size k is the best trade-off

---

**Q1:** Why does the smallest element in the heap represent the k-th largest overall?
**Q2:** What happens if you use a max heap instead—how would logic change?
**Q3:** How would you modify this to track k-th smallest instead?
