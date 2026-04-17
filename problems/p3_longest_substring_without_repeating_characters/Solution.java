package problems.p3_longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
  }

  public int lengthOfLongestSubstring(String s) {
    int left = 0;
    int maxLength = 0;
    Set<Character> charSet = new HashSet<>();

    for (int right = 0; right < s.length(); right++) {
      while (charSet.contains(s.charAt(right))) {
        charSet.remove(s.charAt(left));
        left++;
      }

      charSet.add(s.charAt(right));
      maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
  }
}
