package problems.p703_kth_largest_element_in_a_stream;

import java.util.*;

public class Solution {

  class KthLargest {
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
      heap = new PriorityQueue<>();

      for (int num : nums) {
        heap.offer(num);
        if (heap.size() > k) {
          heap.poll();
        }
      }
      this.k = k;
    }

    public int add(int val) {
      heap.add(val);
      if (heap.size() > k) {
        heap.poll();
      }
      return heap.peek();
    }
  }
}
