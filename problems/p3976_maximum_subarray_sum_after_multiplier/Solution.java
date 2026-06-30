package problems.p3976_maximum_subarray_sum_after_multiplier;

public class Solution {

  static void main() {
    new Solution().maxSubarraySum(new int[] {1, -2, 3, 4, -5}, 2);
  }

  public long maxSubarraySum(int[] nums, int k) {
    return Math.max(solve(nums, k, true), solve(nums, k, false));
  }

  private long solve(int[] nums, int k, boolean multiply) {
    long NEG = Long.MIN_VALUE / 4;

    long dp0 = NEG;
    long dp1 = NEG;
    long dp2 = NEG;

    long ans = NEG;

    for (int x : nums) {
      long val = multiply ? (long) x * k : x / k;

      long ndp0 = Math.max(dp0 + x, (long) x);

      long ndp1 = Math.max(val, Math.max(dp0 + val, dp1 + val));

      long ndp2 = Math.max((long) x, Math.max(dp1 + x, dp2 + x));

      dp0 = ndp0;
      dp1 = ndp1;
      dp2 = ndp2;

      ans = Math.max(ans, Math.max(dp0, Math.max(dp1, dp2)));
    }

    return ans;
  }
}
