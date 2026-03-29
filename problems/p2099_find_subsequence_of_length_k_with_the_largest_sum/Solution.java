package problems.p2099_find_subsequence_of_length_k_with_the_largest_sum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    solution.maxSubsequence(new int[] {2, 1, 3, 3}, 2);
  }

  public int[] maxSubsequence(int[] nums, int k) {
    PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

    for (int i = 0; i < nums.length; i++) {
      heap.offer(new int[] {nums[i], i});

      if (heap.size() > k) {
        heap.poll();
      }
    }

    int[][] kNums = heap.toArray(new int[0][0]);
    Arrays.sort(kNums, Comparator.comparingInt((a) -> a[1]));
    int[] result = new int[k];

    for (int i = 0; i < kNums.length; i++) {
      result[i] = kNums[i][0];
    }
    return result;
  }
}
