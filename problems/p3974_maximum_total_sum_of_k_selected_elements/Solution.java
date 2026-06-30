package problems.p3974_maximum_total_sum_of_k_selected_elements;

import java.util.Arrays;

public class Solution {

  static void main() {
    new Solution().maxSum(new int[] {6, 1, 2, 9}, 3, 2);
  }

  public long maxSum(int[] nums, int k, int mul) {
    Arrays.sort(nums);

    long sum = 0;
    int index = nums.length - 1;

    while (k > 0) {
      if (mul > 0) {
        sum += (long) nums[index] * mul;
      } else {
        sum += nums[index];
      }
      k--;
      mul--;
      index--;
    }

    return sum;
  }
}
