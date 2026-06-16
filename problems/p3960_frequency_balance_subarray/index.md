---
id: 3960
title: "Frequency Balance Subarray"
difficulty: Medium
tags: [hash-table]
date: 2026-06-14
link: https://leetcode.com/problems/frequency-balance-subarray
---

## Problem

You are given an integer array ​​​​​​​nums.

Define a frequency balance subarray as follows:

If the subarray contains only one distinct value, it is frequency balanced.
Otherwise, there must exist a positive integer f such that every distinct value in the subarray occurs either f or 2 * f times, and both frequencies occur among the distinct values.
Return an integer denoting the length of the longest frequency balance subarray.



Example 1:

Input: nums = [1,2,2,1,2,3,3,3]

Output: 5

Explanation:

The longest frequency balance subarray is [2, 1, 2, 3, 3].
The elements that appear most frequently are 2 and 3, both appearing twice.
The remaining element 1 appears once, meeting the requirements.
Example 2:

Input: nums = [5,5,5,5]

Output: 4

Explanation:

The longest frequency balance subarray is [5, 5, 5, 5].
The element that appears most frequently is 5.
There are no other elements meeting the requirements.
Example 3:

Input: nums = [1,2,3,4]

Output: 1

Explanation:

Since all elements appear only once, the length of the longest frequency balance subarray is 1.



Constraints:

1 <= nums.length <= 10​​​​​​​3
1 <= nums[i] <= 10​​​​​​​9


# Approach

**Pattern used:** Brute Force + Frequency Maps

### Core Idea

The solution examines every possible subarray and dynamically tracks:

1. The frequency of each value.
2. How many values have each frequency.

The second map (`freqCount`) is the key optimization because it allows the balance condition to be checked without scanning all element frequencies every time.

### Data Structures

#### freq

Stores:

value → frequency

Example:

[2,1,2,3,3]

becomes:

2 → 2
1 → 1
3 → 2

---

#### freqCount

Stores:

frequency → number of values having that frequency

For the same example:

1 → 1
2 → 2

Meaning:

* One value occurs once.
* Two values occur twice.

This lets us reason about the frequency distribution directly.

---

### Step-by-Step

#### 1. Fix Left Boundary

For every index:

left = 0 ... n-1

start a new subarray.

---

#### 2. Expand Right Boundary

Move:

right = left ... n-1

one step at a time.

Each step adds one element to the current subarray.

---

#### 3. Update Frequencies

Suppose:

x = nums[right]

Current frequency:

oldFreq

First remove its contribution from `freqCount`.

Example:

oldFreq = 2

Before:

2 → 3

After:

2 → 2

Then increase its frequency:

newFreq = oldFreq + 1

Update:

freq[x] = newFreq

and add it to:

freqCount[newFreq]

---

### Why `freqCount` Helps

Without `freqCount`, every validation would require scanning all frequencies in `freq`.

That would make validation O(distinct values).

Instead, the algorithm maintains the frequency distribution incrementally.

Validation becomes O(1).

---

### Balance Checking

The function `isBalanced()` determines whether the current subarray satisfies the definition.

#### Case 1: Length = 1

A single element is always balanced.

---

#### Case 2: One Distinct Value

Example:

[5,5,5,5]

Frequency:

5 → 4

Balanced by definition.

---

#### Case 3: More Than One Distinct Value

The problem requires:

* Exactly two frequencies must exist.
* One frequency must be exactly double the other.

Therefore:

freqCount.size() == 2

Example:

1 → 1
2 → 2

Valid because:

2 = 2 × 1

---

Example:

2 → 3
4 → 2

Valid because:

4 = 2 × 2

---

Example:

1 → 2
3 → 1

Invalid because:

3 ≠ 2 × 1

---

### Example Walkthrough

Subarray:

[2,1,2,3,3]

Frequencies:

2 → 2
1 → 1
3 → 2

Frequency distribution:

1 → 1
2 → 2

There are exactly two frequencies:

* minFreq = 1
* maxFreq = 2

Since:

2 = 2 × 1

the subarray is balanced.

Length = 5.

### Key Insight

The clever part is not the brute force itself.

It is maintaining:

frequency → count of values with that frequency

so that validity can be checked in constant time rather than repeatedly scanning all distinct elements.

### Subtle Detail

Notice that the counts inside `freqCount` are never used in the final condition.

Only the frequency values matter.

For example:

1 → 100
2 → 1

is still valid because the frequencies present are exactly `{1,2}`.

The problem only requires that both frequencies occur at least once.



# Complexity

Let n be the array length.

**Time Complexity:** O(n²)

* There are O(n²) subarrays.
* Each extension of the right pointer performs O(1) map updates.
* Balance checking is O(1) because `freqCount` contains at most a few entries.

Overall:

O(n²)

**Space Complexity:** O(n)

* In the worst case, every element is distinct.
* Both maps can store O(n) entries.
