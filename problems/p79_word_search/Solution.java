package problems.p79_word_search;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.exist(
            new char[][] {
              new char[] {'A', 'B', 'C', 'E'},
              new char[] {'S', 'F', 'E', 'S'},
              new char[] {'A', 'D', 'E', 'E'},
            },
            "ABCESEEEFS"));
  }

  private static boolean backtrack(char[][] board, String word, int row, int col, int index) {

    if (index == word.length()) return true;

    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;

    if (board[row][col] != word.charAt(index)) return false;

    char temp = board[row][col];
    board[row][col] = '#'; // mark visited

    boolean found =
        backtrack(board, word, row + 1, col, index + 1)
            || backtrack(board, word, row - 1, col, index + 1)
            || backtrack(board, word, row, col + 1, index + 1)
            || backtrack(board, word, row, col - 1, index + 1);

    board[row][col] = temp; // restore

    return found;
  }

  public boolean exist(char[][] board, String word) {
    boolean answer;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        answer = backtrack(board, word, i, j, 0);
        if (answer) return true;
      }
    }

    return false;
  }
}
