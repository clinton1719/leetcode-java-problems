package problems.p3912_valid_elements_in_an_array;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    solution.findValidElements(new int[] {1, 2, 4, 2, 3, 2});
  }

  public List findValidElements(int[] nums) {
    int n = nums.length;
    List<Integer> ans = new ArrayList<>();

    if (n == 1) {
      ans.add(nums[0]);
      return ans;
    }

    int[] right = new int[n];
    right[n - 1] = nums[n - 1];

    for (int i = n - 2; i >= 0; i--) {
      right[i] = Math.max(nums[i], right[i + 1]);
    }

    ans.add(nums[0]);

    int maxLeft = nums[0];

    for (int i = 1; i < n - 1; i++) {
      if (nums[i] > maxLeft || nums[i] > right[i + 1]) {
        ans.add(nums[i]);
      }
      maxLeft = Math.max(maxLeft, nums[i]);
    }

    ans.add(nums[n - 1]);

    return ans;
  }
}
