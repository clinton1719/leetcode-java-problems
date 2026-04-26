package problems.p3909_compare_sums_of_bitonic_parts;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.compareBitonicSums(new int[] {1, 3, 2, 1}));
  }

  public int compareBitonicSums(int[] nums) {
    long ascSum = nums[0];
    int n = nums.length;
    int index = 1;

    while (index < n && nums[index] > nums[index - 1]) {
      ascSum += nums[index++];
    }

    int peakIndex = index - 1;

    long descSum = nums[peakIndex];

    while (index < n && nums[index] < nums[index - 1]) {
      descSum += nums[index++];
    }

    if (ascSum == descSum) {
      return -1;
    } else if (ascSum > descSum) {
      return 0;
    } else {
      return 1;
    }
  }
}
