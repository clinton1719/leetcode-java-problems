package problems.p191_number_of_1_bits;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.hammingWeight(11));
  }

  public int hammingWeight(int n) {
    int count = 0;
    for (int i = 0; i < 32; i++) {
      if ((n & 1) == 1) count++;
      n >>>= 1;
    }

    return count;
  }

  public int hammingWeight2(int n) {
    int count = 0;

    while (n != 0) {
      n = n & (n - 1);
      count++;
    }

    return count;
  }
}
