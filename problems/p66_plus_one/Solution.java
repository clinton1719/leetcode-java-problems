package problems.p66_plus_one;

import java.util.Arrays;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.plusOne(new int[] {1, 2, 9})));
  }

  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }

      digits[i] = 0;
    }

    int[] ans = new int[digits.length + 1];
    ans[0] = 1;

    return ans;
  }
}
