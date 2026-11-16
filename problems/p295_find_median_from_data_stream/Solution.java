package problems.p295_find_median_from_data_stream;

import java.util.PriorityQueue;

public class Solution {

  static void main() {
    MedianFinder obj = new MedianFinder();
    obj.addNum(1);
    obj.addNum(2);
    System.out.println(obj.findMedian());
    obj.addNum(3);
    System.out.println(obj.findMedian());
  }

  static class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
      maxHeap = new PriorityQueue<>((a, b) -> b - a);
      minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
      maxHeap.offer(num);
      // Move the largest element from maxHeap to minHeap to maintain order
      minHeap.offer(maxHeap.poll());

      // Balance the heaps - ensure minHeap doesn't have more than 1 extra element
      if (minHeap.size() - maxHeap.size() > 1) {
        maxHeap.offer(minHeap.poll());
      }
    }

    public double findMedian() {
      return minHeap.size() == maxHeap.size()
          ? (minHeap.peek() + maxHeap.peek()) / 2.0
          : minHeap.peek();
    }
  }
}
