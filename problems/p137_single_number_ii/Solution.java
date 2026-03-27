package problems.p137_single_number_ii;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.singleNumber(new int[] {2, 2, 3, 2}));
  }

  public int singleNumber(int[] nums) {
    int result = 0;

    for (int i = 0; i < 32; i++) {
      int count = 0;

      for (int num : nums) {
        if (((num >> i) & 1) == 1) {
          count++;
        }
      }
      if (count % 3 != 0) {
        result |= (1 << i);
      }
    }

    return result;
  }
}
