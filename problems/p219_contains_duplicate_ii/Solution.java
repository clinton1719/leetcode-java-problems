package problems.p219_contains_duplicate_ii;

import java.util.*;

public class Solution {
  static void main() {
    int[] nums = {1, 2};
    Solution solution = new Solution();
    System.out.println(solution.containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2));
  }

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> window = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      if (i > k) {
        window.remove(nums[i - k - 1]);
      }

      if (!window.add(nums[i])) {
        return true;
      }
    }

    return false;
  }
}
