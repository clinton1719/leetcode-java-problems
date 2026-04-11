package problems.p162_find_peak_element;

public class Solution {
  static void main() {
    int[] nums = {1, 2, 1};
    Solution solution = new Solution();
    System.out.println(solution.findPeakElement(nums));
  }

  public int findPeakElement(int[] nums) {
    if (nums.length == 1) return 0;
    int p1 = 0;
    int p2 = nums.length - 1;

    while (p1 <= p2) {
      int p1Left = p1 - 1 < 0 ? Integer.MIN_VALUE : nums[p1 - 1];
      int p1Right = nums[p1 + 1];

      if (p1Left < nums[p1] && p1Right < nums[p1]) return p1;

      int p2Left = nums[p2 - 1];
      int p2Right = p2 + 1 >= nums.length ? Integer.MIN_VALUE : nums[p2 + 1];
      if (p2Left < nums[p2] && p2Right < nums[p2]) return p2;

      p1++;
      p2--;
    }

    return -1;
  }

  // binary search
  public int findPeakElement2(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] > nums[mid + 1]) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }
}
