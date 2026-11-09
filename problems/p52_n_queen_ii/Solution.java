package problems.p52_n_queen_ii;

public class Solution {
  int solutions = 0;
  boolean[] queenInCols;
  boolean[] rightSlantingDiagonal; // diagonal where sum of indices is always same
  boolean[] leftSlantingDiagonal; // diagonal where differences of if indices is always same
  int n;

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.totalNQueens(4));
  }

  public int totalNQueens(int n) {
    queenInCols = new boolean[n];
    rightSlantingDiagonal = new boolean[(2 * n)];
    leftSlantingDiagonal = new boolean[2 * n];
    this.n = n;

    dfs(0);

    return solutions;
  }

  private void dfs(int row) {
    if (row == n) {
      ++solutions;
      return;
    }

    for (int col = 0; col<n; col++) {
      int rightDiagonal = row + col;
      int leftDiagonal = row-col + n;

      if (queenInCols[col] || rightSlantingDiagonal[rightDiagonal] || leftSlantingDiagonal[leftDiagonal]) {
        continue;
      }

      // Place queen at (row, col)
      queenInCols[col] = true;
      rightSlantingDiagonal[rightDiagonal] = true;
      leftSlantingDiagonal[leftDiagonal] = true;

      dfs(row + 1);

      queenInCols[col] = false;
      rightSlantingDiagonal[rightDiagonal] = false;
      leftSlantingDiagonal[leftDiagonal] = false;
    }
  }
}
