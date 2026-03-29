package problems.p215_kth_largest_element_in_an_array;

import java.util.PriorityQueue;

public class Solution {
  static void main() {
    int[] nums = {1, 2};
    Solution solution = new Solution();
    System.out.println(solution.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
  }

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>();

    for (int num : nums) {
      heap.offer(num);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    return heap.peek();
  }
}
