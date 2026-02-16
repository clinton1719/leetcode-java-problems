package problems.p1_two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i<nums.length; i++) {
      if (map.containsKey(nums[i])) {
        return new int[] {i, map.get(nums[i])};
      }
      map.put(target - nums[i], i);
    }

    return new int[] {};
  }
}
