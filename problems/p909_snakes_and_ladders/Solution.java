package problems.p909_snakes_and_ladders;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    int[] arr1 = new int[] {-1, -1, -1, -1, -1, -1};
    int[] arr2 = new int[] {-1, -1, -1, -1, -1, -1};
    int[] arr3 = new int[] {-1, -1, -1, -1, -1, -1};
    int[] arr4 = new int[] {-1, 35, -1, -1, 13, -1};
    int[] arr5 = new int[] {-1, -1, -1, -1, -1, -1};
    int[] arr6 = new int[] {-1, 15, -1, -1, -1, -1};
    System.out.println(solution.snakesAndLadders(new int[][] {arr1, arr2, arr3, arr4, arr5, arr6}));
  }

  private static int findRowColAndValue(int[][] board, int t, int n) {
    int row = (t - 1) / n;
    int col = (t - 1) % n;

    int boardValue = board[n - 1 - row][row % 2 == 1 ? n - 1 - col : col];
    int y = boardValue != -1 ? boardValue : t;
    return y;
  }

  public int snakesAndLadders(int[][] board) {
    int n = board.length;
    int[] minRolls = new int[n * n + 1];
    Arrays.fill(minRolls, -1);
    Queue<Integer> q = new LinkedList<>();
    minRolls[1] = 0;
    q.add(1);

    while (!q.isEmpty()) {
      int x = q.poll();

      for (int i = 1; i <= 6 && x + i <= n * n; i++) {
        int t = x + i;

        int y = findRowColAndValue(board, t, n);

        if (y == n * n) return minRolls[x] + 1;
        if (minRolls[y] == -1) {
          minRolls[y] = minRolls[x] + 1;
          q.offer(y);
        }
      }
    }
    return -1;
  }
}
