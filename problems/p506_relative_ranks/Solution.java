package problems.p506_relative_ranks;

import java.util.*;

public class Solution {
  int sum = 0;

  static void main() {
    Solution solution = new Solution();
    String[] arr = solution.findRelativeRanks(new int[] {5, 4, 3, 2, 1});
    for (String s : arr) {
      System.out.println(s);
    }
  }

  public String[] findRelativeRanks(int[] score) {
    String[] result = new String[score.length];
    PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

    for (int i = 0; i < score.length; i++) {
      heap.offer(new int[] {score[i], i});
    }

    int count = 1;
    while (!heap.isEmpty()) {
      int[] value = heap.poll();
      int index = value[1];

      if (count == 1) {
        result[index] = "Gold Medal";
      } else if (count == 2) {
        result[index] = "Silver Medal";
      } else if (count == 3) {
        result[index] = "Bronze Medal";
      } else {
        result[index] = String.valueOf(count);
      }

      count++;
    }

    return result;
  }
}
