package problems.p57_insert_interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    solution.insert(new int[][] {new int[] {1, 3}, new int[] {6, 9}}, new int[] {2, 5});
  }

  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> ans = new ArrayList<>();

    if (intervals.length == 0) return new int[][] {newInterval};

    int[] prev = intervals[0];

    for (int i = 1; i<intervals.length; i++) {

    }

    return ans.toArray(new int[0][]);
  }
}
