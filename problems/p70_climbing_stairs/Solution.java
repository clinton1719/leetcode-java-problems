package problems.p70_climbing_stairs;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.climbStairs(5));
  }

  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }

    int first = 2, second = 1;

    for (int i = 3; i <= n; i++) {
      int sum = first + second;
      second = first;
      first = sum;
    }

    return first;
  }
}
