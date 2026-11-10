package problems.p502_ipo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.findMaximizedCapital(2, 0, new int[] {1, 2, 3}, new int[] {0, 1, 1}));
  }

  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int projects = capital.length;
    PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

    for (int i = 0; i < projects; i++) {
      minCapitalHeap.offer(new int[] {capital[i], profits[i]});
    }

    PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);

    while (k > 0) {
      while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
        maxProfitHeap.offer(minCapitalHeap.poll()[1]);
      }

      if (maxProfitHeap.isEmpty()) {
        break;
      }

      w += maxProfitHeap.poll();
      k--;
    }

    return w;
  }
}
