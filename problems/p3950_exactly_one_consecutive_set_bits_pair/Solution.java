package problems.p3950_exactly_one_consecutive_set_bits_pair;

public class Solution {

  static void main() {
    new Solution().consecutiveSetBits(6);
  }

  public boolean consecutiveSetBits(int n) {
    return Integer.bitCount(n & (n >> 1)) == 1;
  }
}
