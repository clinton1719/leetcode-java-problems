package problems.p3264_final_array_state_after_k_multiplication_operations_i;

import java.util.PriorityQueue;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    solution.getFinalState(new int[] {2, 1, 3, 5, 6}, 5, 2);
  }

  public int[] getFinalState(int[] nums, int k, int multiplier) {
    PriorityQueue<int[]> heap =
        new PriorityQueue<>(
            (a, b) -> {
              if (a[0] == b[0]) return a[1] - b[1];

              return a[0] - b[0];
            });

    for (int i = 0; i < nums.length; i++) {
      heap.offer(new int[] {nums[i], i});
    }

    while (k > 0) {
      int[] item = heap.poll();
      int newValue = item[0] * multiplier;

      nums[item[1]] *= multiplier;
      heap.offer(new int[] {nums[item[1]], item[1]});
      k--;
    }

    return nums;
  }
}
