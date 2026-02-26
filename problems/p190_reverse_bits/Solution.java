package problems.p190_reverse_bits;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.reverseBits(43261596));
  }

  public int reverseBits(int n) {
    if (n == 0) return 0;
    int result = 0;

    for (int i = 0; i < 32; i++) {
      result <<= 1;
      if ((n & 1) == 1) result++;
      n >>>= 1;
    }

    return result;
  }
}
