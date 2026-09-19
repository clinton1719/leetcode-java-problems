package problems.p153_find_minimum_in_rotated_sorted_array;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.findMin(new int[] {8, 4, 6, 7}));
  }

  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;

    while (nums[left] > nums[right]) {
      int mid = left + ((right - left) / 2);

      if (nums[mid] < nums[left] && nums[mid] < nums[right]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return nums[left];
  }
}
