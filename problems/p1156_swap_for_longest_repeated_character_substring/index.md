---
id: 1156
title: "Swap For Longest Repeated Character Substring"
difficulty: Medium
tags: [sliding-window, hash-table, string, tricky, three-pointers]
date: 2026-04-15
link: https://leetcode.com/problems/swap-for-longest-repeated-character-substring
---

## Problem

You are given a string text. You can swap two of the characters in the text.

Return the length of the longest substring with repeated characters.



Example 1:

Input: text = "ababa"
Output: 3
Explanation: We can swap the first 'b' with the last 'a', or the last 'b' with the first 'a'. Then, the longest repeated character substring is "aaa" with length 3.
Example 2:

Input: text = "aaabaaa"
Output: 6
Explanation: Swap 'b' with the last 'a' (or the first 'a'), and we get longest repeated character substring "aaaaaa" with length 6.
Example 3:

Input: text = "aaaaa"
Output: 5
Explanation: No need to swap, longest repeated character substring is "aaaaa" with length is 5.


Constraints:

1 <= text.length <= 2 * 104
text consist of lowercase English characters only.


Solution Approach

The solution uses a two-pointer technique to efficiently find all segments of repeated characters and determine the maximum possible length after one swap.


First, we count the frequency of each character in the string using a Counter: cnt = Counter(text). This gives us the total occurrences of each character, which serves as an upper bound for the maximum possible length of any repeated character substring.


The main algorithm uses three pointers: i, j, and k:

Finding the left segment: Starting from position i, we move pointer j to the right while text[j] == text[i]. This gives us a segment of length l = j - i where all characters are the same as text[i].

Skipping the gap: After finding the left segment, position j points to a different character. We skip this character and set k = j + 1.

Finding the right segment: We continue moving k to the right while text[k] == text[i]. This gives us another segment of the same character with length r = k - j - 1 (we subtract 1 because there's a gap character at position j).

Calculating maximum length: For the current character text[i], the maximum achievable length is:

If we can bridge the two segments by swapping the gap character: l + r + 1
But this is limited by the total count of that character: min(l + r + 1, cnt[text[i]])
The +1 accounts for either:

Swapping the gap character at position j with another instance of text[i] from elsewhere
Or if no right segment exists (r = 0), adding one more character of the same type to extend the left segment
Moving to next segment: We update i = j to move to the next different character segment and repeat the process.

The algorithm continues until we've examined all positions in the string, keeping track of the maximum length found across all segments.

Time Complexity: O(n) where n is the length of the string, as each character is visited at most twice.

Space Complexity: O(1) or O(26) for the character counter (assuming lowercase English letters).


Example Walkthrough

Let's walk through the algorithm with the string text = "ababa".


Step 1: Count character frequencies

cnt = {'a': 3, 'b': 2}

This tells us the maximum possible length for 'a' is 3 and for 'b' is 2.

Step 2: Process segments starting from position 0


Iteration 1: i = 0


Current character: text[0] = 'a'

Find left segment: j moves from 0 to 1 (stops at 'b')

Left segment = "a", length l = 1 - 0 = 1

Skip gap: k = j + 1 = 2

Find right segment: k moves from 2 to 3 (text[2] = 'a', stops at text[3] = 'b')

Right segment = "a", length r = 3 - 1 - 1 = 1

Calculate max: min(1 + 1 + 1, cnt['a']) = min(3, 3) = 3

This represents swapping the 'b' at position 1 with an 'a' from position 4

Update: i = j = 1, ans = 3

Iteration 2: i = 1

Current character: text[1] = 'b'

Find left segment: j moves from 1 to 2 (stops at 'a')

Left segment = "b", length l = 2 - 1 = 1

Skip gap: k = j + 1 = 3

Find right segment: k moves from 3 to 4 (text[3] = 'b', stops at text[4] = 'a')

Right segment = "b", length r = 4 - 2 - 1 = 1

Calculate max: min(1 + 1 + 1, cnt['b']) = min(3, 2) = 2

Limited by total count of 'b' (only 2 'b's exist)

Update: i = j = 2, ans = max(3, 2) = 3

Iteration 3: i = 2


Current character: text[2] = 'a'

Find left segment: j moves from 2 to 3 (stops at 'b')

Left segment = "a", length l = 3 - 2 = 1

Skip gap: k = j + 1 = 4

Find right segment: k moves from 4 to 5 (text[4] = 'a', reaches end)

Right segment = "a", length r = 5 - 3 - 1 = 1

Calculate max: min(1 + 1 + 1, cnt['a']) = min(3, 3) = 3

Update: i = j = 3, ans = max(3, 3) = 3

Iteration 4: i = 3


Current character: text[3] = 'b'

Find left segment: j moves from 3 to 4 (stops at 'a')

Left segment = "b", length l = 4 - 3 = 1

Skip gap: k = j + 1 = 5 (out of bounds)

Find right segment: No right segment, r = 0

Calculate max: min(1 + 0 + 1, cnt['b']) = min(2, 2) = 2

The +1 represents adding another 'b' from position 1 to extend

Update: i = j = 4, ans = max(3, 2) = 3

Iteration 5: i = 4


Current character: text[4] = 'a'

Find left segment: j moves from 4 to 5 (reaches end)

Left segment = "a", length l = 5 - 4 = 1

No gap or right segment

Calculate max: min(1 + 0 + 1, cnt['a']) = min(2, 3) = 2

Update: i = j = 5, loop ends

Result: Maximum length = 3


This can be achieved by swapping text[1] with text[4], transforming "ababa" → "aaabb", creating "aaa" of length 3.