package problems.p289_game_of_life;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    solution.gameOfLife(
        new int[][] {
          new int[] {0, 1, 0}, new int[] {0, 0, 1}, new int[] {1, 1, 1}, new int[] {0, 0, 0}
        });
  }

  // 0 - 0 -> 0
  // 1 - 1 -> 1
  // 0 - 1 -> 2
  // 1- 0 -> 3
  public void gameOfLife(int[][] board) {

    int rows = board.length;
    int cols = board[0].length;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {

        int liveNeighbors = countLiveNeighbors(board, r, c);

        // live -> dead
        if (board[r][c] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {

          board[r][c] = 3;
        }

        // dead -> live
        else if (board[r][c] == 0 && liveNeighbors == 3) {

          board[r][c] = 2;
        }
      }
    }

    // finalize board
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {

        if (board[r][c] == 2) {
          board[r][c] = 1;
        } else if (board[r][c] == 3) {
          board[r][c] = 0;
        }
      }
    }
  }

  private int countLiveNeighbors(int[][] board, int row, int col) {

    int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    int live = 0;

    for (int[] d : dirs) {

      int nr = row + d[0];
      int nc = col + d[1];

      if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {

        // originally alive
        if (board[nr][nc] == 1 || board[nr][nc] == 3) {

          live++;
        }
      }
    }

    return live;
  }
}
