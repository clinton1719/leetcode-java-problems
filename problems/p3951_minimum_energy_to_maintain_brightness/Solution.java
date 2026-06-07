package problems.p3951_minimum_energy_to_maintain_brightness;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  static void main() {
    new Solution().minEnergy(5, 5, new int[][] {new int[] {6, 12}});
  }

  public long minEnergy(int n, int brightness, int[][] intervals) {
    if (brightness == 0) return 0;

    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    int start = intervals[0][0];
    int end = intervals[0][1];
    long recordedTimeUnits = 0;

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] <= end + 1) {
        end = Math.max(end, intervals[i][1]);
      } else {
        recordedTimeUnits += (long) end - start + 1;
        start = intervals[i][0];
        end = intervals[i][1];
      }
    }

    recordedTimeUnits += (long) end - start + 1;

    long longBulbsNeeded = (brightness + 2L) / 3;

    return recordedTimeUnits * longBulbsNeeded;
  }
}
