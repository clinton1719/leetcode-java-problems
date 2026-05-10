package problems.p3925_concatenate_array_with_reverse;


public class Solution {

  static void main() {
    new Solution().concatWithReverse(new int[] {1, 2, 3});
  }

  public int[] concatWithReverse(int[] nums) {
    int n = nums.length;
    int[] ans = new int[2 * n];
    int right = n - 1;

    for (int i = 0; i < n; i++) {
      ans[i] = nums[i];
      ans[i + n] = nums[right--];
    }

    return ans;
  }
}
