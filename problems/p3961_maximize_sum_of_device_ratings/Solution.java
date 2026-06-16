package problems.p3961_maximize_sum_of_device_ratings;

import java.util.Arrays;

public class Solution {

  static void main() {
    new Solution().maxRatings(new int[][] {new int[] {1, 3}, new int[] {2, 2}});
  }

  public long maxRatings(int[][] units) {
    int globalMin = Integer.MAX_VALUE;
    int minSecond = Integer.MAX_VALUE;
    long secondElemSum = 0;

    int n = units[0].length;

    if (n == 1) {
      long sum = 0;
      for (int[] row : units) {
        sum += row[0];
      }
      return sum;
    }

    for (int[] row : units) {
      Arrays.sort(row);

      globalMin = Math.min(globalMin, row[0]);
      minSecond = Math.min(minSecond, row[1]);
      secondElemSum += row[1];
    }

    return globalMin + secondElemSum - minSecond;
  }
}
