package problems.p130_surrounded_regions;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    solution.solve(
        new char[][] {
          new char[] {'O', 'X', 'X', 'O', 'X'},
          new char[] {'X', 'O', 'O', 'X', 'O'},
          new char[] {'X', 'O', 'X', 'O', 'X'},
          new char[] {'O', 'X', 'O', 'O', 'O'},
          new char[] {'X', 'X', 'O', 'X', 'O'}
        });
  }

  public void solve(char[][] board) {
    if (board == null || board.length == 0) return;

    int m = board.length;
    int n = board[0].length;

    // 1. Mark boundary-connected 'O' as safe
    for (int i = 0; i < m; i++) {
      dfs(board, i, 0); // left boundary
      dfs(board, i, n - 1); // right boundary
    }

    for (int j = 0; j < n; j++) {
      dfs(board, 0, j); // top boundary
      dfs(board, m - 1, j); // bottom boundary
    }

    // 2. Flip remaining 'O' to 'X', and revert safe marks
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X'; // surrounded
        } else if (board[i][j] == '#') {
          board[i][j] = 'O'; // safe
        }
      }
    }
  }

  private void dfs(char[][] board, int i, int j) {
    int m = board.length;
    int n = board[0].length;

    if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
      return;
    }

    board[i][j] = '#'; // mark as safe

    dfs(board, i + 1, j);
    dfs(board, i - 1, j);
    dfs(board, i, j + 1);
    dfs(board, i, j - 1);
  }
}
