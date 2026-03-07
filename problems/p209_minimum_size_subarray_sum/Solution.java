package problems.p209_minimum_size_subarray_sum;

import java.util.*;

public class Solution {
  static void main() {
    int[] nums = {1, 2};
    Solution solution = new Solution();
    System.out.println(solution.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
  }

  public int minSubArrayLen(int target, int[] nums) {
    int left = 0, right = 0, sum = nums[left];
    int minLength = Integer.MAX_VALUE;
    while (right < nums.length) {
      if (sum >= target) {
        minLength = Math.min(minLength, right - left + 1);
        if (minLength == 1) return minLength;
        sum -= nums[left];
        left++;
      } else {
        right++;
        if (right >= nums.length) return minLength;
        sum += nums[right];
      }
    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
}
