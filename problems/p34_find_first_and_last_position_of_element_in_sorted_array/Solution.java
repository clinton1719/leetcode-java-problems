package problems.p34_find_first_and_last_position_of_element_in_sorted_array;

import problems.Utility;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    Utility.printIntegerArray(solution.searchRange(new int[] {1, 4}, 4));
  }

  public int[] searchRange(int[] nums, int target) {
    int left = firstOccurrence(nums, target);
    if (left == -1) return new int[] {-1, -1};

    int right = lastOccurrence(nums, target);
    return new int[] {left, right};
  }

  private int firstOccurrence(int[] nums, int target) {
    int low = 0, high = nums.length - 1, ans = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] >= target) {
        if (nums[mid] == target) ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }

  private int lastOccurrence(int[] nums, int target) {
    int low = 0, high = nums.length - 1, ans = -1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] <= target) {
        if (nums[mid] == target) ans = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return ans;
  }
}
