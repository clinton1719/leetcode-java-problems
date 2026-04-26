package problems.p50_powx_n;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.myPow(2, 5));
  }

  public double myPow(double x, int n) {
    double ans = recursion(x, Math.abs(n));

    if (n < 0) {
      return 1 / ans;
    } else {
      return ans;
    }
  }

  private double recursion(double x, int n) {
    if (x == 0) return 0;
    if (n == 0) return 1;

    double result = recursion(x, n / 2);
    result = result * result;
    if (n % 2 == 0) {
      return result;
    } else {
      return x * result;
    }
  }
}
