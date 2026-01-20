package problems.p55_jump_game;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.canJump(new int[] {0, 2, 3}));
  }

  public boolean canJump(int[] nums) {
    int n = nums.length;
    int lastIndex = n - 1;

    for (int i = lastIndex; i >= 0; i--) {
      if (i + nums[i] >= lastIndex) {
        lastIndex = i;
      }
    }

    return lastIndex == 0;
  }
}
