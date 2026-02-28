package problems.p136_single_number;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.singleNumber(new int[] {2, 2, 1}));
  }

  public int singleNumber(int[] nums) {
    int answer = 0;

    for (int num : nums) {
      answer ^= num;
    }

    return answer;
  }
}
