package problems.p169_majority_element;

public class Solution {
  public int majorityElement(int[] nums) {
    int count = 1, currentVal = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != currentVal) {
        count--;

        if (count == 0) {
          currentVal = nums[i];
          count++;
        }
      } else {
        count++;
      }
    }

    return currentVal;
  }

  static void main() {
    int[] nums = {8, 8, 7, 7, 7};
    Solution solution = new Solution();
    int result = solution.majorityElement(nums);
    System.out.println(result);
  }
}
