---
id: 191
title: "Number Of 1 Bits"
difficulty: Easy
tags: [bit-manipulation, algorithm, brian-kernighans-algorithm]
date: 2026-02-28
link: https://leetcode.com/problems/number-of-1-bits
---

## Problem

Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).



Example 1:

Input: n = 11

Output: 3

Explanation:

The input binary string 1011 has a total of three set bits.

Example 2:

Input: n = 128

Output: 1

Explanation:

The input binary string 10000000 has a total of one set bit.

Example 3:

Input: n = 2147483645

Output: 30

Explanation:

The input binary string 1111111111111111111111111111101 has a total of thirty set bits.



Constraints:

1 <= n <= 231 - 1


Follow up: If this function is called many times, how would you optimize it?

## Approach 1
We count the number of 1 bits in a 32-bit integer.

Algorithm:
1. Initialize count = 0.
2. Repeat 32 times:
    - Check the least significant bit using (n & 1).
    - If it is 1, increment count.
    - Right shift n by 1.
3. Return count.

This checks each of the 32 bits individually.

## Complexity 1
Time: O(1)
Always runs 32 iterations.

Space: O(1)
Uses only a few variables.

## Approach 2 - Brian Kernighan’s Algorithm
Brian Kernighan’s Algorithm is a clever and efficient method used to count the number of 1s (set bits) in the binary representation of an integer. The algorithm works by repeatedly turning off the rightmost set bit of the number, and each iteration counts as one set bit.

How it Works:
Identify the rightmost set bit using the expression n & (n - 1). This operation clears the least significant set bit of n.
Repeat the process until the number becomes 0.
Count the number of iterations.
The key operation, n & (n - 1), works because subtracting 1 from a number flips all the bits after the rightmost set bit (including the set bit itself). When performing a bitwise AND with the original number, it effectively removes that set bit.

## Complexity 2
Time: O(k)
Where k = number of 1 bits.
Worst case: 32
Best case: 0

Space: O(1)


