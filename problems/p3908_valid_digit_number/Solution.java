package problems.p3908_valid_digit_number;

import java.util.*;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.validDigit(1101, 0));
  }

  public boolean validDigit(int n, int x) {
    boolean foundX = false;
    int firstDigit = 0;

    while (n > 0) {
      int rem = n % 10;
      if (rem == x) {
        foundX = true;
      }
      firstDigit = rem;
      n /= 10;
    }

    return foundX && firstDigit != x;
  }
}
