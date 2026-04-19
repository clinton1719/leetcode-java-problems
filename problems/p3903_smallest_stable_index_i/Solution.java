package problems.p3903_smallest_stable_index_i;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.firstStableIndex(new int[] {5,0,1,4}, 3));
  }

  public int firstStableIndex(int[] nums, int k) {
    int[] maxArray = new int[nums.length];
    int[] minArray = new int[nums.length];

    int currentMaxElement = nums[0];
    int currentMinElement = nums[nums.length-1];

    for (int i = 0; i<nums.length; i++) {
      if (nums[i] > currentMaxElement) {
        currentMaxElement = nums[i];
      }
      maxArray[i] = currentMaxElement;
    }

    for (int i = nums.length-1; i>=0; i--) {
      if (nums[i] < currentMinElement) {
        currentMinElement = nums[i];
      }
      minArray[i] = currentMinElement;
    }

    int stableIndex = Integer.MAX_VALUE;
    boolean isFound = false;

    for (int i = 0; i<nums.length; i++) {
      int currentStableIndex = maxArray[i] - minArray[i];

      if (currentStableIndex <= k) {
        stableIndex = Math.min(stableIndex, i);
        isFound = true;
      }
    }

    return isFound ? stableIndex : -1;
  }
}
