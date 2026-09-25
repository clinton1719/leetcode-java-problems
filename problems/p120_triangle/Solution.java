package problems.p120_triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.minimumTotal(
            new ArrayList<>(
                List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3)))));
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    int[][] dp = new int[triangle.size()][triangle.getLast().size()];
    dp[0][0] = triangle.getFirst().getFirst();

    for (int i = 1; i < triangle.size(); i++) {
      for (int j = 0; j < i + 1; j++) {
        if (j == 0) {
          dp[i][j] = triangle.get(i).get(j) + dp[i - 1][0];
        } else if (j == i) {
          dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
          dp[i][j] += triangle.get(i).get(j);
        }
      }
    }

    int minTotal = 1 << 30;

    for (int j = 0; j < triangle.getLast().size(); j++) {
      minTotal = Math.min(minTotal, dp[triangle.size() - 1][j]);
    }

    return minTotal;
  }
}
