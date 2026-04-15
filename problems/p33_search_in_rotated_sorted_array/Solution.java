package problems.p33_search_in_rotated_sorted_array;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
  }

  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;

    while (left < right) {
      int mid = left + ((right - left) / 2);

      if (nums[mid] == target) return mid;

      if (nums[mid] > target) {
        if (nums[left] > target) {
          left = mid + 1;
        } else {
          right = mid;
        }
      } else {
        if (nums[mid] < nums[left] && nums[left] < target) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
    }

    return nums[left] == target ? left : -1;
  }
}
