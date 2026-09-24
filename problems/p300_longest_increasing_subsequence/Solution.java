package problems.p300_longest_increasing_subsequence;


import java.util.Arrays;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
  }

  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int maxLength = 1;

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxLength = Math.max(maxLength, dp[i]);
    }

    return maxLength;
  }
}
