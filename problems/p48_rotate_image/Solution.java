package problems.p48_rotate_image;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    solution.rotate(
        new int[][] {
          new int[] {5, 1, 9, 11},
          new int[] {2, 4, 8, 10},
          new int[] {13, 3, 6, 7},
          new int[] {15, 14, 12, 16}
        });
  }

  public void rotate(int[][] matrix) {
    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix.length - 1;
    int count = matrix.length - 1;

    while (left <= right && top <= bottom && count > 0) {
      List<Integer> carryOver = new ArrayList<>(right - left + 1);
      int index = 0;

      // 1. left → right
      for (int j = left; j <= right; j++) {
        carryOver.add(matrix[top][j]);
      }

      // 2. top → bottom
      for (int i = top; i <= bottom; i++) {
        int temp = carryOver.get(index);
        carryOver.set(index, matrix[i][right]);
        matrix[i][right] = temp;
        index++;
      }
      index = 1;

      // 3. right → left (check needed)
      for (int j = right - 1; j >= left; j--) {
        int temp = carryOver.get(index);
        carryOver.set(index, matrix[bottom][j]);
        matrix[bottom][j] = temp;
        index++;
      }
      index = 1;

      // 4. bottom → top (check needed)
      for (int i = bottom - 1; i >= top; i--) {
        int temp = carryOver.get(index);
        carryOver.set(index, matrix[i][left]);
        matrix[i][left] = temp;
        index++;
      }
      index = 1;

      for (int j = left + 1; j <= right; j++) {
        int temp = carryOver.get(index);
        carryOver.set(index, matrix[top][j]);
        matrix[top][j] = temp;
        index++;
      }

      left++;
      right--;
      top++;
      bottom--;
    }
  }

  // reverse and transpose
  public void rotate2(int[][] matrix) {
    int edgeLength = matrix.length;

    int top = 0;
    int bottom = edgeLength - 1;

    while (top < bottom) {
      for (int col = 0; col < edgeLength; col++) {
        int temp = matrix[top][col];
        matrix[top][col] = matrix[bottom][col];
        matrix[bottom][col] = temp;
      }
      top++;
      bottom--;
    }

    for (int row = 0; row < edgeLength; row++) {
      for (int col = row + 1; col < edgeLength; col++) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
      }
    }
  }
}
