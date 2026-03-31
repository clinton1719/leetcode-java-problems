package problems.p201_bitwise_and_of_numbers_range;


public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.rangeBitwiseAnd(5, 7));
  }

  public int rangeBitwiseAnd(int left, int right) {
    int shift = 0;

    while (left < right) {
      left >>= 1;
      right >>= 1;
      shift++;
    }

    return left << shift;
  }
}
