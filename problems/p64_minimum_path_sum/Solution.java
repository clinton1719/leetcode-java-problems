package problems.p64_minimum_path_sum;

import java.util.Arrays;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.minPathSum(
            new int[][] {new int[] {1, 3, 1}, new int[] {1, 5, 1}, new int[] {4, 2, 1}}));
  }

  private int dfs(int[][] grid, int[][] dp, int row, int col) {
    if (row == grid.length - 1 && col == grid[0].length - 1) {
      return grid[row][col];
    }

    if (dp[row][col] != -1) {
      return dp[row][col];
    }

    int down = Integer.MAX_VALUE;
    int right = Integer.MAX_VALUE;

    if (row + 1 < grid.length) {
      down = dfs(grid, dp, row + 1, col);
    }

    if (col + 1 < grid[0].length) {
      right = dfs(grid, dp, row, col + 1);
    }

    return dp[row][col] =
            grid[row][col] + Math.min(down, right);
  }

  public int minPathSum(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    int[][] dp = new int[rows][cols];

    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    return dfs(grid, dp, 0, 0);
  }
}
