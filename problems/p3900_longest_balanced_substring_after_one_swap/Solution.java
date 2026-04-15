package problems.p3900_longest_balanced_substring_after_one_swap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.longestBalanced("01111100"));
  }

  public int longestBalanced(String s) {
    Map<Integer, List<Integer>> mpp = new HashMap<>();
    mpp.computeIfAbsent(0, key -> new ArrayList<>()).add(-1);

    int count0 = 0;
    int count1 = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '1') {
        count1++;
      } else {
        count0++;
      }
    }

    int sum = 0;
    int maxLength = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        sum++;
      }
      if (s.charAt(i) == '0') {
        sum--;
      }

      if (mpp.containsKey(sum)) {
        maxLength = Math.max(maxLength, i - mpp.get(sum).get(0));
      }

      if (mpp.containsKey(sum - 2)) {
        for (int j : mpp.get(sum - 2)) {
          int len = i - j;
          int usedZeros = (len - 2) / 2;
          if (count0 > usedZeros) {
            maxLength = Math.max(maxLength, len);
            break;
          }
        }
      }

      if (mpp.containsKey(sum + 2)) {
        for (int j : mpp.get(sum + 2)) {
          int len = i - j;
          int usedOnes = (len - 2) / 2;
          if (count1 > usedOnes) {
            maxLength = Math.max(maxLength, len);
            break;
          }
        }
      }

      mpp.computeIfAbsent(sum, key -> new ArrayList<>()).add(i);
    }

    return maxLength;
  }
}
