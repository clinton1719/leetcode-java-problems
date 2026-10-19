package problems.p42_trapping_rain_water;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }

  public int trap(int[] height) {
    int n = height.length;
    int[] leftMax = new int[n];
    leftMax[0] = height[0];
    int[] rightMax = new int[n];
    rightMax[n - 1] = height[n - 1];
    int water = 0;

    for (int i = 1; i < n; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], height[i]);
    }

    for (int i = n - 2; i >= 0; i--) {
      rightMax[i] = Math.max(rightMax[i + 1], height[i]);

      water += Math.min(leftMax[i], rightMax[i]) - height[i];
    }

    return water;
  }
}
