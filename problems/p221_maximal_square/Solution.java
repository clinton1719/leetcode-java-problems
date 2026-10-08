package problems.p221_maximal_square;

public class Solution {
  int[][] dp;
  int maxLength = 0;

  static void main() {
    Solution solution = new Solution();
    char[][] matrix = {
      {'1', '0', '1', '0', '0'},
      {'1', '0', '1', '1', '1'}
    };

    System.out.println(solution.maximalSquare(matrix));
  }

  public int maximalSquare(char[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    dp = new int[rows + 1][cols + 1];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == '1') {
          dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
          maxLength = Math.max(maxLength, dp[i + 1][j + 1]);
        }
      }
    }

    return maxLength * maxLength;
  }
}
