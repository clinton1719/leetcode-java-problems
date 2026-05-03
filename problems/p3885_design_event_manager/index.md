---
id: 3885
title: "Design Event Manager"
difficulty: Easy
tags: [design, heap]
date: 2026-03-29
link: https://leetcode.com/problems/design-event-manager
---

## Problem

You are given an initial list of events, where each event has a unique eventId and a priority.


Implement the EventManager class:

EventManager(int[][] events) Initializes the manager with the given events, where events[i] = [eventIdi, priority​​​​​​​i].
void updatePriority(int eventId, int newPriority) Updates the priority of the active event with id eventId to newPriority.
int pollHighest() Removes and returns the eventId of the active event with the highest priority. If multiple active events have the same priority, return the smallest eventId among them. If there are no active events, return -1.
An event is called active if it has not been removed by pollHighest().



Example 1:

Input:
["EventManager", "pollHighest", "updatePriority", "pollHighest", "pollHighest"]
[[[[5, 7], [2, 7], [9, 4]]], [], [9, 7], [], []]

Output:
[null, 2, null, 5, 9]

Explanation

EventManager eventManager = new EventManager([[5,7], [2,7], [9,4]]); // Initializes the manager with three events
eventManager.pollHighest(); // both events 5 and 2 have priority 7, so return the smaller id 2
eventManager.updatePriority(9, 7); // event 9 now has priority 7
eventManager.pollHighest(); // remaining highest priority events are 5 and 9, return 5
eventManager.pollHighest(); // return 9
Example 2:

Input:
["EventManager", "pollHighest", "pollHighest", "pollHighest"]
[[[[4, 1], [7, 2]]], [], [], []]

Output:
[null, 7, 4, -1]

Explanation

EventManager eventManager = new EventManager([[4,1], [7,2]]); // Initializes the manager with two events
eventManager.pollHighest(); // return 7
eventManager.pollHighest(); // return 4
eventManager.pollHighest(); // no events remain, return -1


Constraints:

1 <= events.length <= 105
events[i] = [eventId, priority]
1 <= eventId <= 109
1 <= priority <= 109
All the values of eventId in events are unique.
1 <= newPriority <= 109
For every call to updatePriority, eventId refers to an active event.
At most 105 calls in total will be made to updatePriority and pollHighest.


## Approach

The goal is to manage events with priorities and support:

- updatePriority(eventId, newPriority)
- pollHighest() → return event with highest priority (tie → smaller id)

### Key Idea: Max-Heap + HashMap (Lazy Deletion)

We combine:

1. **PriorityQueue (Max-Heap)**  
   - Stores `[eventId, priority]`
   - Ordered by:
     - Higher priority first
     - If tie → smaller eventId first

2. **HashMap (eventId → latest priority)**  
   - Tracks the **current valid priority**
   - Helps detect outdated entries in heap

---

## Problem Challenge

Java’s `PriorityQueue` does NOT support:

- Efficient update of elements
- Efficient removal of arbitrary elements

---

## Solution: Lazy Deletion

Instead of updating/removing inside heap:

- We **insert a new entry** with updated priority
- Old entries remain in heap (become stale)

---

## Operations

### 1. Initialization

- Insert all events into:
  - `map` (for current state)
  - `pq` (for ordering)

---

### 2. updatePriority

- Update value in map
- Push new `[eventId, newPriority]` into heap

Old entries are NOT removed → handled later

---

### 3. pollHighest

Loop until valid entry found:

1. Peek top element
2. Check:
   
   if map.get(eventId) != priority  
   → stale entry → discard

3. If valid:
   - Remove from heap
   - Remove from map (mark inactive)
   - Return eventId

---

## Why This Works

- Heap may contain outdated entries
- Map always contains **latest truth**
- Lazy deletion avoids expensive heap operations

---

## Complexity

### Time Complexity

- updatePriority → O(log n)  
- pollHighest → O(log n) amortized  

Worst case:
- Multiple stale entries may be removed  
- But each stale entry is processed only once → amortized efficient

---

### Space Complexity

O(n)

- Heap may temporarily store multiple versions of same event (due to lazy updates)
- Map stores current active events

---

## Key Insight

This pattern is widely used when:

- Heap does not support decrease/increase-key
- Frequent updates are required

👉 "Insert new + invalidate old" is often cheaper than trying to modify in-place






