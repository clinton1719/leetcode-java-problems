package problems.p_minimum_cost_to_move_between_indices;

public class Solution {

  static void main() {
    new Solution()
        .minCost(
            new int[] {0, 2, 3, 9},
            new int[][] {new int[] {3, 0}, new int[] {1, 2}, new int[] {2, 0}});
  }

  public int[] minCost(int[] nums, int[][] queries) {
    int n = nums.length;

    int[] closest = new int[n];
    closest[0] = 1;
    closest[n - 1] = n - 2;

    for (int i = 1; i < n - 1; i++) {
      int left = Math.abs(nums[i] - nums[i - 1]);
      int right = Math.abs(nums[i] - nums[i + 1]);

      if (left <= right) closest[i] = i - 1;
      else closest[i] = i + 1;
    }

    int[] forward = new int[n];
    for (int i = 1; i < n; i++) {
      int cost;
      if (closest[i - 1] == i) cost = 1;
      else cost = nums[i] - nums[i - 1];

      forward[i] = forward[i - 1] + cost;
    }

    int[] backward = new int[n];
    for (int i = n - 2; i >= 0; i--) {
      int cost;
      if (closest[i + 1] == i) cost = 1;
      else cost = nums[i + 1] - nums[i];

      backward[i] = backward[i + 1] + cost;
    }

    int[] ans = new int[queries.length];
    int currentIndex = 0;

    for (int[] q : queries) {
      int l = q[0], r = q[1];

      if (l < r) {
        ans[currentIndex++] = forward[r] - forward[l];
      } else {
        ans[currentIndex++] = backward[r] - backward[l];
      }
    }

    return ans;
  }
}
