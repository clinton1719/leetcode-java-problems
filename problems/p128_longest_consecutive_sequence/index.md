---
id: 128
title: "Longest Consecutive Sequence"
difficulty: Medium
tags: [array, hash-table, hash-set]
date: 2026-03-07
link: https://leetcode.com/problems/longest-consecutive-sequence
---

## Problem

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

# Approach

**Pattern used:** HashSet + Sequence Expansion

### Core Idea

The solution stores all numbers in a HashSet for O(1) lookups and removals.

For each number, it tries to expand:

* Left: `num - 1`, `num - 2`, ...
* Right: `num + 1`, `num + 2`, ...

Whenever a number is found, it is removed from the set.

This removal is the key insight: once a number becomes part of a sequence, it will never be processed again.

### Step-by-Step

#### 1. Store All Numbers in a HashSet

This allows:

* O(1) average lookup
* O(1) average removal

Example:

nums = [100,4,200,1,3,2]

set = {100,4,200,1,3,2}

---

#### 2. Try Every Number as a Starting Point

For each number:

Initialize:

l = num - 1
r = num + 1

---

#### 3. Expand Left

While:

set.remove(l)

keep moving left.

Example:

num = 3

If:

2 exists → remove it

then:

1 exists → remove it

then:

0 does not exist → stop

---

#### 4. Expand Right

Similarly:

While:

set.remove(r)

keep moving right.

Example:

4 exists → remove

5 does not exist → stop

---

#### 5. Compute Length

After expansion:

(l + 1) ... (r - 1)

is the complete consecutive sequence.

Length:

r - l - 1

Example:

l = 0
r = 5

Sequence:

1,2,3,4

Length:

5 - 0 - 1 = 4

---

#### 6. Update Maximum

Keep the longest sequence found so far.

### Example Walkthrough

Input:

[100,4,200,1,3,2]

Start with:

num = 4

Expand left:

3 → remove
2 → remove
1 → remove

Expand right:

5 not found

Now:

l = 0
r = 5

Length:

5 - 0 - 1 = 4

Answer becomes:

4

When later processing:

1,2,3

they have already been removed from the set, so almost no extra work is done.

### Key Insight

The solution achieves O(n) because every number is removed from the set at most once.

Even though there are nested while loops, the total number of successful removals across the entire algorithm is at most n.

Think of it this way:

* A number can enter the set once.
* A number can be removed once.
* After removal, it is never visited again.

Therefore the total work remains linear.

### Subtle Detail

Notice that the current number (`num`) itself is never removed.

This is still fine because all neighboring numbers are removed during expansion.

Eventually the set becomes empty and:

if (set.isEmpty()) break;

allows an early exit.

### Comparison with the More Common Solution

The standard HashSet solution checks:

if (!set.contains(num - 1))

before starting expansion.

That ensures only the beginning of a sequence performs the work.

Your solution uses a different idea:

* Start expansion from every number.
* Remove numbers as they are consumed.

Both achieve O(n) average time because each value participates in expansion only once.


# Complexity

**Time Complexity:** O(n)

* Building the HashSet takes O(n).
* Every number can be removed from the set at most once.
* Total successful removals across all expansions are O(n).

Overall:

O(n)

**Space Complexity:** O(n)

* The HashSet stores up to n distinct numbers.

