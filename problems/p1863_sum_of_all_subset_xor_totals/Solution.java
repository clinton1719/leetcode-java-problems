package problems.p1863_sum_of_all_subset_xor_totals;


public class Solution {
  static int sum = 0;

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.subsetXORSum(new int[] {5, 1, 6}));
  }

  private static void backtrack(int[] nums, int currentXor, int index, int n) {
    if (n == index) {
      return;
    }
    for (int i = index; i < n; i++) {
      currentXor ^= nums[i];
      sum += currentXor;
      backtrack(nums, currentXor, i + 1, n);
      currentXor ^= nums[i];
    }
  }

  public int subsetXORSum(int[] nums) {
    backtrack(nums, 0, 0, nums.length);
    return sum;
  }
}
