---
id: 49
title: "Group Anagrams"
difficulty: Medium
tags: [array, hash-table, string, sorting]
date: 2026-03-22
link: https://leetcode.com/problems/group-anagrams
---

## Problem

Given an array of strings strs, group the anagrams together. You can return the answer in any order.


Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]



Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.


## Approach

The goal is to group strings that are **anagrams** of each other.

### Key Idea: Canonical Representation

Two strings are anagrams if they contain the **same characters with the same frequency**, regardless of order.

So we transform each string into a **canonical form** that uniquely represents its character composition.

---

### Method Used: Sorting

1. For each string:
   - Convert it into a character array.
   - Sort the array.
   - Convert it back to a string → this becomes the **key**.

2. Since all anagrams result in the **same sorted string**, they will map to the same key.

---

### Example

Input:

["eat", "tea", "tan", "ate", "nat", "bat"]

After sorting:

eat → aet  
tea → aet  
ate → aet  
tan → ant  
nat → ant  
bat → abt  

Grouping:

aet → ["eat", "tea", "ate"]  
ant → ["tan", "nat"]  
abt → ["bat"]

---

### Algorithm 1

1. Initialize a `HashMap<String, List<String>>`.
2. Iterate over each string:
   - Generate its sorted key.
   - Add the string to the corresponding list in the map.
3. Return all values from the map.

---

### Why This Works

Sorting ensures that all anagrams collapse into a **single identical key**, making grouping straightforward.

---

## Complexity 1

### Time Complexity

O(n × k log k)

- `n` = number of strings
- `k` = maximum length of a string
- Sorting each string takes `O(k log k)`

---

### Space Complexity 

O(n × k)

- Storing all strings in the hashmap groups.
- Additional space for keys.


## Approach 2

The goal is to group strings that are **anagrams** of each other using a more efficient method than sorting.

### Key Idea: Frequency-Based Hash (Canonical Form)

Instead of sorting each string, we represent it by the **frequency of each character**.

Two strings are anagrams if and only if their **character frequency counts are identical**.

---

### Step 1 — Build Frequency Array

For each word:

- Create an array of size 26 (for lowercase English letters)
- Count occurrences of each character

Example:

"eat" →  
a:1, e:1, t:1 → all others 0

---

### Step 2 — Generate Unique Hash String

Convert the frequency array into a string key:

- Iterate from `'a'` to `'z'`
- Append character + frequency only if frequency > 0

Example:

"eat" → "a1e1t1"  
"tea" → "a1e1t1" (same key → same group)

---

### Step 3 — Group Using HashMap

- Use the generated hash as the key
- Store all words with the same key in the same list

---

### Why This Works

The hash uniquely represents the **character composition**, independent of order.  
So all anagrams collapse into the same key.

---

### Comparison with Sorting Approach

- Sorting → depends on character order → O(k log k)
- Frequency → depends on counts → O(k)

This makes the frequency method more efficient for longer strings.

---

## Complexity 2

### Time Complexity

O(n × k)

- `n` = number of strings  
- `k` = maximum length of a string  
- Counting characters takes O(k) per string

---

### Space Complexity

O(n × k)

- Storing grouped strings
- Additional space for hash keys





