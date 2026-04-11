package problems.p3895_count_digit_appearances;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.countDigitOccurrences(new int[] {12, 54, 32, 2}, 2));
  }

  private static int findCount(int number, int digit) {
    if (number == 0 && digit == 0) return 1;

    int count = 0;

    while (number != 0) {
      int rem = number % 10;
      number /= 10;
      if (rem == digit) count++;
    }

    return count;
  }

  public int countDigitOccurrences(int[] nums, int digit) {
    int count = 0;
    for (int num : nums) {
      count += findCount(num, digit);
    }
    return count;
  }
}
