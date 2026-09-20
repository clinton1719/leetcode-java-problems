package problems.p172_factorial_trailing_zeroes;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.trailingZeroes(5));
  }

  public int trailingZeroes(int n) {
    int answer = 0;

    while (n > 0) {
      n /= 5;
      answer += n;
    }

    return answer;
  }
}
