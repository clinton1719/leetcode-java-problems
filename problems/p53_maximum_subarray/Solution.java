package problems.p53_maximum_subarray;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }

  public int maxSubArray(int[] nums) {
    int currentSum = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      currentSum = Math.max(nums[i], currentSum + nums[i]);
      maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
  }
}
