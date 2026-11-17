package problems.p149_max_points_on_a_line;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    int[][] points = new int[][] {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
    System.out.println(solution.maxPoints(points));
  }

  public int maxPoints(int[][] points) {
    if (points.length <= 2) {
      return points.length;
    }

    int res = 1;
    for (int i = 0; i < points.length - 1; i++) {
      Map<String, Integer> count = new HashMap<>();
      for (int j = i + 1; j < points.length; j++) {
        int dx = points[j][0] - points[i][0];
        int dy = points[j][1] - points[i][1];
        if (dx < 0) {
          dx = -dx;
          dy = -dy;
        }
        int gcd = gcd(dx, dy); // greatest common divisor
        dx /= gcd;
        dy /= gcd;
        String slope = dx + ":" + dy;
        count.put(slope, count.getOrDefault(slope, 0) + 1);
      }
      for (int val : count.values()) {
        res = Math.max(res, val + 1);
      }
    }
    return res;
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
