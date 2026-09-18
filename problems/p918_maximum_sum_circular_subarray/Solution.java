package problems.p918_maximum_sum_circular_subarray;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.maxSubarraySumCircular(new int[] {1, -2, 3, -2}));
  }

  public int maxSubarraySumCircular(int[] nums) {
    int globalMax = nums[0], globalMin = nums[0];
    int currentMax = 0, currentMin = 0, total = 0;

    for (int num : nums) {
      currentMax = Math.max(num, currentMax + num);
      currentMin = Math.min(num, currentMin + num);
      total += num;
      globalMax = Math.max(globalMax, currentMax);
      globalMin = Math.min(globalMin, currentMin);
    }

    return globalMax > 0 ? Math.max(globalMax, total - globalMin) : globalMax;
  }
}
