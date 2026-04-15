package problems.p1156_swap_for_longest_repeated_character_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.maxRepOpt1("ababa"));
  }

  public int maxRepOpt1(String text) {
    int n = text.length();
    Map<Character, Integer> map = new HashMap<>();
    int maxLength = 0;
    char[] textArray = text.toCharArray();

    for (char c : textArray) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int i = 0; // left segment start
    int j = 0; // left segment end & middle value
    int k = 0; // right segment start

    while (i < n) {
      while (j < n && textArray[j] == textArray[i]) j++;
      k = j + 1;

      while (k < n && textArray[k] == textArray[i]) k++;

      int leftLength = j - i;
      int rightLength = k - j - 1;

      int swappableLength = leftLength + rightLength + 1;

      int maxAllowedLength = Math.min(swappableLength, map.get(textArray[i]));

      maxLength = Math.max(maxLength, maxAllowedLength);

      i = j;
    }

    return maxLength;
  }
}
