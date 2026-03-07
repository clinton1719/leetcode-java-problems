package problems.p128_longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
  }

  public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();

    for (int num : nums) {
      set.add(num);
    }

    int maxLength = 0;

    for (int num : nums) {
      if (set.isEmpty()) {
        break;
      }
      int l = num - 1;
      int r = num + 1;

      while (set.remove(l)) {
        l--;
      }
      while (set.remove(r)) {
        r++;
      }

      maxLength = Math.max(maxLength, r - l - 1);
    }

    return maxLength;
  }
}
