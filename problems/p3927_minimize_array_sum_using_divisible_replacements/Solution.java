package problems.p3927_minimize_array_sum_using_divisible_replacements;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  static void main() {
    new Solution().minArraySum(new int[] {3, 6, 2});
  }

  public long minArraySum(int[] nums) {
    int maxVal = 0;

    for (int num : nums) {
      if (num > maxVal) maxVal = num;
    }

    boolean[] exists = new boolean[maxVal + 1];
    for (int num : nums) {
      exists[num] = true;
    }

    Map<Integer, Integer> minReplacement = new HashMap<>();

    for (int i : nums) {
      if (minReplacement.containsKey(i)) continue;

      int best = i;
      for (int d = 1; d * d <= i; d++) {
        if (i % d == 0) {
          if (exists[d]) {
            best = d;
            break;
          }

          int otherD = i / d;
          if (exists[otherD]) {
            best = Math.min(best, otherD);
          }
        }
      }
      minReplacement.put(i, best);
    }

    long ans = 0;
    for (int num : nums) {
      ans += (long) minReplacement.get(num);
    }

    return ans;
  }
}
