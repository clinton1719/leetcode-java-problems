package problems.p525_contiguous_array;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.findMaxLength(new int[] {5, 4, 3, 2, 1}));
  }

  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxLength = Integer.MIN_VALUE;
    int count = 0;
    map.put(count, -1);

    for (int i = 0; i < nums.length; i++) {
      count = nums[i] == 1 ? 1 : -1;

      if (map.containsKey(count)) {
        maxLength = Math.max(maxLength, i - map.get(count));
      } else {
        map.put(count, i);
      }
    }

    return maxLength;
  }
}
