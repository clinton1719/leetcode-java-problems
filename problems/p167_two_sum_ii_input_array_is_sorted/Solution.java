package problems.p167_two_sum_ii_input_array_is_sorted;

public class Solution {
  static void main() {
    int[] nums = {2, 7, 11, 15};
    Solution solution = new Solution();
    int[] result = solution.twoSum(nums, 9);
    for (int num : result) {
      System.out.println(num);
    }
  }

  public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;

    while (left < right) {
      if (numbers[left] + numbers[right] == target) {
        return new int[] {left + 1, right + 1};
      } else if (numbers[left] + numbers[right] > target) {
        right--;
      } else {
        left++;
      }
    }
    return new int[] {};
  }
}
