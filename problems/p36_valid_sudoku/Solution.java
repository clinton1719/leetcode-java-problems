package problems.p36_valid_sudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    char[] arr1 = new char[] {'7', '.', '.', '.', '4', '.', '.', '.', '.'};
    char[] arr2 = new char[] {'.', '.', '.', '8', '6', '5', '.', '.', '.'};
    char[] arr3 = new char[] {'.', '1', '.', '2', '.', '.', '.', '.', '.'};
    char[] arr4 = new char[] {'.', '.', '.', '.', '.', '9', '.', '.', '.'};
    char[] arr5 = new char[] {'.', '.', '.', '.', '5', '.', '5', '.', '.'};
    char[] arr6 = new char[] {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
    char[] arr7 = new char[] {'.', '.', '.', '.', '.', '.', '2', '.', '.'};
    char[] arr8 = new char[] {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
    char[] arr9 = new char[] {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
    System.out.println(
        solution.isValidSudoku2(
            new char[][] {arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9}));
  }

  private static boolean checkValidBox(char[][] board, int row, int col) {
    Set<Character> set = new HashSet<>();
    int rowEnd = row + 3;
    int colEnd = col + 3;

    for (int i = row; i < rowEnd; i++) {
      for (int j = col; j < colEnd; j++) {
        if (board[i][j] != '.' && !set.add(board[i][j])) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < board.length; i += 3) {
      for (int j = 0; j < board.length; j += 3) {
        if (!checkValidBox(board, i, j)) return false;
      }
    }

    for (int i = 0; i < board.length; i++) {
      int j = i;
      if (!isValidRowAndColumn(board, i, j)) return false;
    }

    return true;
  }

  private boolean isValidRowAndColumn(char[][] board, int row, int col) {
    Set<Character> set = new HashSet<>();

    int i = row - 1, j = row + 1;
    set.add(board[row][col]);
    while (i >= 0) {
      if (board[i][col] != '.' && !set.add(board[i][col])) return false;
      i--;
    }
    while (j < board.length) {
      if (board[j][col] != '.' && !set.add(board[j][col])) return false;
      j++;
    }

    i = col - 1;
    j = col + 1;
    set = new HashSet<>();
    set.add(board[row][col]);
    while (i >= 0) {
      if (board[row][i] != '.' && !set.add(board[row][i])) return false;
      i--;
    }
    while (j < board.length) {
      if (board[row][j] != '.' && !set.add(board[row][j])) return false;
      j++;
    }

    return true;
  }

  public boolean isValidSudoku2(char[][] board) {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] boxes = new boolean[9][9];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {

        if (board[i][j] == '.') continue;

        int digitIndex = board[i][j] - '1';
        int boxIndex = (i / 3) * 3 + (j / 3);

        if (rows[i][digitIndex] || cols[j][digitIndex] || boxes[boxIndex][digitIndex]) {
          return false;
        }

        rows[i][digitIndex] = true;
        cols[j][digitIndex] = true;
        boxes[boxIndex][digitIndex] = true;
      }
    }

    return true;
  }
}
