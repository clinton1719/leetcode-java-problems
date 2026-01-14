package problems.p80_remove_duplicates_from_sorted_array_ii;

public class Solution {
  static void main() {
    int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
    Solution solution = new Solution();
    System.out.println(solution.removeDuplicates(nums));
  }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int i = 2;

        for (int j = 2; j < nums.length; j++) {
            if (nums[j] > nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}
