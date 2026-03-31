package problems.p373_find_k_pairs_with_smallest_sums;

import java.util.*;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.kSmallestPairs(new int[] {1, 7, 11}, new int[] {2, 4, 6}, 3));
  }

  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new ArrayList<>();
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    Set<String> visited = new HashSet<>();

    minHeap.offer(new int[] {nums1[0] + nums2[0], 0, 0});
    visited.add("00");

    int n = nums1.length;
    int m = nums2.length;

    while (k-- > 0 && !minHeap.isEmpty()) {
      int[] pair = minHeap.poll();

      int i = pair[1];
      int j = pair[2];

      result.add(new ArrayList<>(List.of(nums1[i], nums2[j])));

      if (i + 1 < n && visited.add(i + 1 + "," + j)) {
        minHeap.offer(new int[] {nums1[i + 1] + nums2[j], i + 1, j});
      }

      if (j + 1 < m && visited.add(i + "," + (j + 1))) {
        minHeap.offer(new int[] {nums1[i] + nums2[j + 1], i, j + 1});
      }
    }

    return result;
  }
}
