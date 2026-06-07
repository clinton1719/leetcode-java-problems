package problems.p3931_check_adjacent_digit_differences;


public class Solution {

  static void main() {
    new Solution().isAdjacentDiffAtMostTwo("132");
  }

  public boolean isAdjacentDiffAtMostTwo(String s) {
    for (int i = 1; i < s.length(); i++) {
      int difference = s.charAt(i) - s.charAt(i - 1);

      if (Math.abs(difference) > 2) {
        return false;
      }
    }

    return true;
  }
}
