package problems.p3911_k_th_smallest_remaining_even_integer_in_subarray_queries;

import java.util.*;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    solution.kthRemainingInteger(
        new int[] {1, 4, 7},
        new int[][] {new int[] {0, 2, 1}, new int[] {1, 1, 2}, new int[] {0, 0, 3}});
  }

  public int[] kthRemainingInteger(int[] nums, int[][] queries) {

    int n = nums.length;

    List<Integer> evenPos = new ArrayList<>();
    List<Integer> evenIndex = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (nums[i] % 2 == 0) {
        evenPos.add(nums[i] / 2);
        evenIndex.add(i);
      }
    }

    int[] ans = new int[queries.length];
    int qi = 0;

    for (int[] q : queries) {
      int l = q[0], r = q[1], k = q[2];

      // find range in evenIndex using binary search
      int left = lowerBound(evenIndex, l);
      int right = upperBound(evenIndex, r) - 1;

      int low = 1, high = k + (right - left + 1);

      while (low < high) {
        int mid = (low + high) / 2;

        int removed = 0;
        if (left <= right) {
          removed = countLessEqual(evenPos, left, right, mid);
        }

        if (mid - removed >= k) {
          high = mid;
        } else {
          low = mid + 1;
        }
      }

      ans[qi++] = 2 * low;
    }

    return ans;
  }

  private int lowerBound(List<Integer> list, int target) {
    int l = 0, r = list.size();
    while (l < r) {
      int m = (l + r) / 2;
      if (list.get(m) >= target) r = m;
      else l = m + 1;
    }
    return l;
  }

  private int upperBound(List<Integer> list, int target) {
    int l = 0, r = list.size();
    while (l < r) {
      int m = (l + r) / 2;
      if (list.get(m) > target) r = m;
      else l = m + 1;
    }
    return l;
  }

  private int countLessEqual(List<Integer> list, int l, int r, int x) {
    int low = l, high = r + 1;
    while (low < high) {
      int mid = (low + high) / 2;
      if (list.get(mid) <= x) low = mid + 1;
      else high = mid;
    }
    return low - l;
  }
}
