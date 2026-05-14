package problems.p56_merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    solution.merge(
        new int[][] {new int[] {1, 3}, new int[] {2, 6}, new int[] {15, 8}, new int[] {8, 10}});
  }

  public int[][] merge(int[][] intervals) {
    List<int[]> list = new ArrayList<>();

    Arrays.sort(
        intervals,
        (a, b) -> {
          if (a[0] == b[0]) {
            return a[1] - b[1];
          } else {
            return a[0] - b[0];
          }
        });

    int[] prev = intervals[0];
    for (int[] interval : intervals) {
      if (interval[0] <= prev[1]) {
        prev[1] = Math.max(interval[1], prev[1]);
      } else {
        list.add(prev);
        prev = interval;
      }
    }
    list.add(prev);

    return list.toArray(new int[0][]);
  }
}
