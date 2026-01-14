package problems.p80_remove_duplicates_from_sorted_array_ii;

public class Solution {
  static void main() {
    int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
    Solution solution = new Solution();
    System.out.println(solution.removeDuplicates(nums));
  }

  public int removeDuplicates(int[] nums) {
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      if (k < 2 || nums[i] != nums[k - 2]) {
        nums[k] = nums[i];
        k++;
      }
    }
    return k;
  }
}
