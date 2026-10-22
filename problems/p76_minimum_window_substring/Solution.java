package problems.p76_minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
  }

  public String minWindow(String s, String t) {
    if (s.length() < t.length() || t.isEmpty()) {
      return "";
    }

    int startPos = 0, endPos = 0;

    Map<Character, Integer> slidingWindow = new HashMap<>();
    Map<Character, Integer> characterCount = new HashMap<>();

    int validCharacterCount = 0;

    // Store the best window's boundaries, not the substring itself.
    int minStart = 0;
    int minLength = Integer.MAX_VALUE;

    for (char c : t.toCharArray()) {
      characterCount.merge(c, 1, Integer::sum);
    }

    while (endPos < s.length()) {
      char currentCharacter = s.charAt(endPos);

      if (characterCount.containsKey(currentCharacter)) {
        slidingWindow.merge(currentCharacter, 1, Integer::sum);

        if (slidingWindow.get(currentCharacter) <= characterCount.get(currentCharacter)) {
          validCharacterCount++;
        }
      }

      // Shrink while all required character occurrences are matched.
      while (validCharacterCount == t.length()) {
        // ompare window lengths, not against s.length().
        int currentLength = endPos - startPos + 1;

        if (currentLength < minLength) {
          minLength = currentLength;
          minStart = startPos;
        }

        char leftChar = s.charAt(startPos);

        if (characterCount.containsKey(leftChar)) {
          // Decrement the frequency when removing the left character.
          slidingWindow.merge(leftChar, -1, Integer::sum);

          // Invalidate the window only if a required occurrence is lost.
          if (slidingWindow.get(leftChar) < characterCount.get(leftChar)) {
            validCharacterCount--;
          }
        }

        startPos++;
      }

      // Always advance the right pointer, even for irrelevant characters.
      endPos++;
    }

    // Return the best window, or "" if no valid window was found.
    return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
  }
}
