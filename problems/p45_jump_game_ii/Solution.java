package problems.p45_jump_game_ii;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.jump(new int[] {2, 3, 1, 1, 4}));
  }

  public int jump(int[] nums) {
    int jumps = 0;
    int currentEnd = 0;
    int farthest = 0;

    for (int i = 0; i < nums.length-1; i++) {
      farthest = Math.max(farthest, i + nums[i]);

      if (i == currentEnd) {
        jumps++;
        currentEnd = farthest;
      }
    }

    return jumps;
  }
}
