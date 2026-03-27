---
id: 380
title: "Insert Delete GetRandom O(1)"
difficulty: Medium
tags: [array, design, hash-table, math]
date: 2026-03-27
link: https://leetcode.com/problems/insert-delete-getrandom-o1
---

## Problem

Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.

bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.

bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.

int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.

You must implement the functions of the class such that each function works in average O(1) time complexity.



Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]

Output

[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.

randomizedSet.remove(2); // Returns false as 2 does not exist in the set.

randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].

randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.

randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].

randomizedSet.insert(2); // 2 was already in the set, so return false.

randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.



Constraints:

-231 <= val <= 231 - 1
At most 2 * 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.


## Approach

The goal is to design a data structure that supports:

- insert(val)
- remove(val)
- getRandom()

all in **O(1) average time**.

---

### Key Idea: Combine ArrayList + HashMap

We use:

1. **ArrayList (`list`)**
   - Stores elements
   - Allows O(1) random access

2. **HashMap (`map`)**
   - Maps value → index in the list
   - Allows O(1) lookup

---

### Why Both Are Needed

- List → needed for `getRandom()`
- Map → needed for fast `insert()` and `remove()`

---

## Operations

### 1. Insert

- Check if value exists in map
- If not:
  - Add it to the end of the list
  - Store its index in the map

---

### 2. Remove (Tricky Part)

We cannot remove directly from the middle of a list in O(1).

### Trick: Swap with Last Element

Steps:

1. Get index of element to remove
2. Get last element in the list
3. Move last element to the index of the element to remove:

   list[index] = lastElement

4. Update its index in the map:

   map.put(lastElement, index)

5. Remove last element from list
6. Remove the target element from map

---

### Why This Works

- Avoids shifting elements (which would be O(n))
- Maintains contiguous array structure

---

### 3. getRandom

- Generate random index from `0 → list.size() - 1`
- Return element at that index

---

## Complexity

### Time Complexity

insert → O(1) average  
remove → O(1) average  
getRandom → O(1)

---

### Space Complexity

O(n)

- Store elements in both list and map

