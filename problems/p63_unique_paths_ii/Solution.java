package problems.p63_unique_paths_ii;

public class Solution {
  Integer[][] memo;
  int[][] obstacleGrid;
  int rows, cols;

  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.uniquePathsWithObstacles(
            new int[][] {new int[] {0, 0, 0}, new int[] {0, 1, 0}, new int[] {0, 0, 0}}));
  }

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    this.obstacleGrid = obstacleGrid;
    rows = obstacleGrid.length;
    cols = obstacleGrid[0].length;
    memo = new Integer[rows][cols];

    return dfs(0, 0);
  }

  private int dfs(int row, int col) {
    // base case 1 - out of bounds/obstacle
    if (row >= rows || col >= cols || obstacleGrid[row][col] == 1) return 0;

    // base case 2 - reached destination
    if (row == rows - 1 && col == cols - 1) {
      return 1;
    }

    // evaluate memo if needed
    if (memo[row][col] == null) {
      int pathsDown = dfs(row + 1, col);
      int pathsRight = dfs(row, col + 1);

      memo[row][col] = pathsDown + pathsRight;
    }

    return memo[row][col];
  }
}
