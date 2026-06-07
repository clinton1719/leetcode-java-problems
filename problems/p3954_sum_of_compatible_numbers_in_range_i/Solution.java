package problems.p3954_sum_of_compatible_numbers_in_range_i;

public class Solution {

  static void main() {
    new Solution().sumOfGoodIntegers(2, 3);
  }

  public int sumOfGoodIntegers(int n, int k) {
    int sum = 0;
    int x = n + 1;

    while (Math.abs(n - x) <= k) {
      if ((n & x) == 0) {
        sum += x;
      }
      x++;
    }

    x = n - 1;

    while (Math.abs(n - x) <= k) {
      if ((n & x) == 0) {
        sum += x;
      }
      x--;
      if (x < 0) break;
    }

    return sum;
  }
}
