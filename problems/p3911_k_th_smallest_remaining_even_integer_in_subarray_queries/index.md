---
id: 3911
title: "K-th Smallest Remaining Even Integer in Subarray Queries"
difficulty: Hard
tags: [binary-search, array]
date: 2026-04-25
link: https://leetcode.com/problems/k-th-smallest-remaining-even-integer-in-subarray-queries
---

## Problem

You are given an integer array nums where nums is strictly increasing.

You are also given a 2D integer array queries, where queries[i] = [li, ri, ki].

For each query [li, ri, ki]:

Consider the subarray nums[li..ri]
From the infinite sequence of all positive even integers: 2, 4, 6, 8, 10, 12, 14, ...
Remove all elements that appear in the subarray nums[li..ri].
Find the kith smallest integer remaining in the sequence after the removals.
Return an integer array ans, where ans[i] is the result for the ith query.

A subarray is a contiguous non-empty sequence of elements within an array.

An array is said to be strictly increasing if each element is strictly greater than its previous one (if exists).



Example 1:

Input: nums = [1,4,7], queries = [[0,2,1],[1,1,2],[0,0,3]]

Output: [2,6,6]

Explanation:

i	queries[i]	nums[li..ri]	Removed
Evens	Remaining
Evens	ki	ans[i]
0	[0, 2, 1]	[1, 4, 7]	[4]	2, 6, 8, ...	1	2
1	[1, 1, 2]	[4]	[4]	2, 6, 8, ...	2	6
2	[0, 0, 3]	[1]	[]	2, 4, 6, ...	3	6
Thus, ans = [2, 6, 6].

Example 2:

Input: nums = [2,5,8], queries = [[0,1,2],[1,2,1],[0,2,4]]

Output: [6,2,12]

Explanation:

i	queries[i]	nums[li..ri]	Removed
Evens	Remaining
Evens	ki	ans[i]
0	[0, 1, 2]	[2, 5]	[2]	4, 6, 8, ...	2	6
1	[1, 2, 1]	[5, 8]	[8]	2, 4, 6, ...	1	2
2	[0, 2, 4]	[2, 5, 8]	[2, 8]	4, 6, 10, 12, ...	4	12
Thus, ans = [6, 2, 12].

Example 3:

Input: nums = [3,6], queries = [[0,1,1],[1,1,3]]

Output: [2,8]

Explanation:

i	queries[i]	nums[li..ri]	Removed
Evens	Remaining
Evens	ki	ans[i]
0	[0, 1, 1]	[3, 6]	[6]	2, 4, 8, ...	1	2
1	[1, 1, 3]	[6]	[6]	2, 4, 8, ...	3	8
Thus, ans = [2, 8].



Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
nums is strictly increasing
1 <= queries.length <= 105
queries[i] = [li, ri, ki]
0 <= li <= ri < nums.length
1 <= ki <= 109​​​​​​​


## Approach

**Pattern used:** Binary Search on Answer + Index Filtering

### Core Idea

For each query:

* You consider all **positive even numbers**: 2, 4, 6, 8, ...
* Remove those present in `nums[l..r]`
* Find the **k-th remaining number**

---

### Key Transformation

Instead of working with even numbers directly:

👉 Map:

* Even number `2x` → `x`

So problem becomes:

* Infinite sequence: `1, 2, 3, 4, ...`
* Remove values `nums[i] / 2` (only if nums[i] is even)

---

### Step-by-step

### 1. Preprocessing

* Store:

    * `evenPos`: values = nums[i]/2 (only even nums)
    * `evenIndex`: corresponding indices

👉 This helps:

* Quickly filter even numbers inside any `[l, r]`

---

### 2. For each query [l, r, k]

#### a. Find valid range of even elements

Using binary search:

* `left = first index ≥ l`
* `right = last index ≤ r`

---

#### b. Binary search on answer

We search for smallest `x` such that:

👉 `(numbers ≤ x) - (removed ≤ x) ≥ k`

Where:

* Total numbers ≤ x = `x`
* Removed = count of values ≤ x in `evenPos[left..right]`

---

### 3. Count removed elements

Use `countLessEqual`:

* Counts how many values in `[left, right]` ≤ x

---

### 4. Condition

If:
`x - removed ≥ k`
→ valid answer

Else:
→ increase x

---

### 5. Final answer

* Return `2 * x`

---

### Key Insights

* Convert problem from **even numbers → natural numbers**
* Binary search works because:

    * Answer space is monotonic
* Removal affects count dynamically

---

### Subtle Details

* `high = k + (right - left + 1)`

    * Worst case: all numbers removed → need to go further
* Only even numbers matter → ignore odds
* `evenIndex` ensures we only consider relevant subarray

---

### Edge Cases

* No even numbers in range → answer = `2*k`
* All small numbers removed → answer shifts higher
* Large k → binary search handles efficiently

---

## Complexity

**Time Complexity:**

* Preprocessing → O(n)
* Per query:

    * Binary search → O(log(k + m))
    * Each check → O(log m)

👉 Total per query: O(log n × log n)

---

**Space Complexity:** O(n)

* Storing even numbers and indices

---

## Optimization

### Already optimal for constraints

* Avoids generating sequence
* Avoids removing explicitly

---

### Possible Improvement

* Use segment tree / BIT for faster range counting
  👉 Reduces inner binary search cost

---

**Q1:** Why do we map even numbers `2x → x` instead of working directly with evens?
**Q2:** How does the condition `x - removed ≥ k` guarantee correctness?
**Q3:** Can this be optimized further using prefix sums or segment trees?
