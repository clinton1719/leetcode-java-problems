package problems.p35search_insert_position;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.searchInsert(new int[] {1, 3, 5, 6}, 5));
  }

  public int searchInsert(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    int middle;

    while (left < right) {
      middle = left + ((right - left) / 2);

      if (nums[middle] == target) return middle;

      if (nums[middle] < target) left = middle + 1;

      if (nums[middle] > target) right = middle - 1;
    }

    return nums[left] > target ? left : left + 1;
  }
}
