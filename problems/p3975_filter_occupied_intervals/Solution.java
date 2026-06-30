package problems.p3975_filter_occupied_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

  static void main() {
    new Solution()
        .filterOccupiedIntervals(
            new int[][] {
              new int[] {2, 6},
              new int[] {4, 8},
              new int[] {10, 10},
              new int[] {10, 12},
              new int[] {14, 16}
            },
            7,
            11);
  }

  public List<List<Integer>> filterOccupiedIntervals(
      int[][] occupiedIntervals, int freeStart, int freeEnd) {

    List<List<Integer>> result = new ArrayList<>();

    if (occupiedIntervals == null || occupiedIntervals.length == 0) {
      return result;
    }

    Arrays.sort(occupiedIntervals, Comparator.comparingInt(a -> a[0]));

    List<List<Integer>> mergedIntervals = new ArrayList<>();

    int start = occupiedIntervals[0][0];
    int end = occupiedIntervals[0][1];

    for (int i = 1; i < occupiedIntervals.length; i++) {
      if (occupiedIntervals[i][0] <= end + 1) {
        end = Math.max(end, occupiedIntervals[i][1]);
      } else {
        mergedIntervals.add(Arrays.asList(start, end));
        start = occupiedIntervals[i][0];
        end = occupiedIntervals[i][1];
      }
    }

    mergedIntervals.add(Arrays.asList(start, end));

    for (List<Integer> interval : mergedIntervals) {
      int s = interval.get(0);
      int e = interval.get(1);

      if (e < freeStart || s > freeEnd) {
        result.add(Arrays.asList(s, e));
      } else if (s >= freeStart && e <= freeEnd) {

      } else if (s < freeStart && e > freeEnd) {
        result.add(Arrays.asList(s, freeStart - 1));
        result.add(Arrays.asList(freeEnd + 1, e));
      } else if (s < freeStart) {
        result.add(Arrays.asList(s, freeStart - 1));
      } else { // e > freeEnd
        result.add(Arrays.asList(freeEnd + 1, e));
      }
    }

    return result;
  }
}
