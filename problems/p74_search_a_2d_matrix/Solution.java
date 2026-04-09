package problems.p74_search_a_2d_matrix;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.searchMatrix(
            new int[][] {
              new int[] {1, 3, 5, 7}, new int[] {10, 11, 16, 20}, new int[] {23, 30, 34, 50}
            },
            23));
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    int startRow = 0;
    int endRow = matrix.length - 1;
    int startCol = 0;
    int endCol = matrix[0].length - 1;

    int row = startRow + ((endRow - startRow) / 2);
    int col = startCol + ((endCol - startCol) / 2);

    while (startRow < endRow) {
      row = startRow + ((endRow - startRow) / 2);
      int value = matrix[row][0];

      if (value == target) {
        return true;
      }

      if (value > target) {
        endRow = row;
      } else {
        if (matrix[row][endCol] == target) return true;
        if (matrix[row][endCol] > target) break;
        startRow = row + 1;
        row = startRow;
      }
    }

    if (matrix[row][col] == target) return true;

    while (startCol < endCol) {
      col = startCol + ((endCol - startCol) / 2);
      int value = matrix[row][col];

      if (value == target) {
        return true;
      }

      if (value > target) {
        endCol = col;
      } else {
        startCol = col + 1;
        col = startCol;
      }
    }

    if (matrix[row][col] == target) return true;

    return matrix[row][col] == target;
  }
}
