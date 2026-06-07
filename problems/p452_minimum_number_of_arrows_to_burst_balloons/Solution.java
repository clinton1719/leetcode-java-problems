package problems.p452_minimum_number_of_arrows_to_burst_balloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.findMinArrowShots(
            new int[][] {
              new int[] {3, 9},
              new int[] {7, 12},
              new int[] {3, 8},
              new int[] {6, 8},
              new int[] {9, 10},
              new int[] {2, 9},
              new int[] {0, 9},
              new int[] {3, 9},
              new int[] {0, 6},
              new int[] {2, 8}
            }));
  }

  public int findMinArrowShots(int[][] points) {
    int arrows = 0;

    Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
    int[] point = points[0];

    for (int i = 1; i < points.length; i++) {
      if (points[i][0] <= point[1]) {
        point[0] = Math.max(points[i][0], point[0]);
        point[1] = Math.min(points[i][1], point[1]);
        if (i == points.length - 1) {
          arrows++;
        }
      } else {
        point = points[i];
        arrows++;
      }
    }

    return arrows + 1;
  }
}
