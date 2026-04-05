package problems.p54_spiral_matrix;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.spiralOrder(
            new int[][] {
              new int[] {1, 2, 3, 4}, new int[] {5, 6, 7, 8}, new int[] {9, 10, 11, 12}
            }));
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {

      // 1. left → right
      for (int j = left; j <= right; j++) {
        result.add(matrix[top][j]);
      }
      top++;

      // 2. top → bottom
      for (int i = top; i <= bottom; i++) {
        result.add(matrix[i][right]);
      }
      right--;

      // 3. right → left (check needed)
      if (top <= bottom) {
        for (int j = right; j >= left; j--) {
          result.add(matrix[bottom][j]);
        }
        bottom--;
      }

      // 4. bottom → top (check needed)
      if (left <= right) {
        for (int i = bottom; i >= top; i--) {
          result.add(matrix[i][left]);
        }
        left++;
      }
    }

    return result;
  }

  public List<Integer> spiralOrder2(int[][] matrix) {
    int startRow = 0;
    int endRow = matrix.length;
    int startCol = 0;
    int endCol = matrix[0].length;
    int size = endRow * endCol;
    List<Integer> result = new ArrayList<>(size);

    int row = startRow;
    int col = startCol;

    while (result.size() < size) {
      while (col < endCol) {
        result.add(matrix[row][col]);
        col++;
      }
      col--;
      row++;
      startRow++;
      if (result.size() == size) return result;

      while (row < endRow) {
        result.add(matrix[row][col]);
        row++;
      }
      row--;
      col--;
      endCol--;
      if (result.size() == size) return result;

      while (col >= startCol) {
        result.add(matrix[row][col]);
        col--;
      }
      col++;
      row--;
      endRow--;
      if (result.size() == size) return result;

      while (row >= startRow) {
        result.add(matrix[row][col]);
        row--;
      }
      row++;
      col++;
      startCol++;
      if (result.size() == size) return result;
    }

    return result;
  }
}
