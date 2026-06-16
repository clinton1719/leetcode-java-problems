package problems.p3960_frequency_balance_subarray;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

  static void main() {
    new Solution().getLength(new int[] {1, 2, 2, 1, 2, 3, 3, 3});
  }

  public int getLength(int[] nums) {
    int n = nums.length;
    int ans = 1;

    for (int left = 0; left < n; left++) {

      Map<Integer, Integer> freq = new HashMap<>();
      Map<Integer, Integer> freqCount = new HashMap<>();

      for (int right = left; right < n; right++) {

        int x = nums[right];

        int oldFreq = freq.getOrDefault(x, 0);

        if (oldFreq > 0) {
          int cnt = freqCount.get(oldFreq);
          if (cnt == 1) {
            freqCount.remove(oldFreq);
          } else {
            freqCount.put(oldFreq, cnt - 1);
          }
        }

        int newFreq = oldFreq + 1;

        freq.put(x, newFreq);
        freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);

        if (isBalanced(freq, freqCount, right - left + 1)) {
          ans = Math.max(ans, right - left + 1);
        }
      }
    }

    return ans;
  }

  private boolean isBalanced(Map<Integer, Integer> freq, Map<Integer, Integer> freqCount, int len) {

    if (len == 1) {
      return true;
    }

    if (freq.size() == 1) {
      return true;
    }

    if (freqCount.size() != 2) {
      return false;
    }

    Iterator<Integer> it = freqCount.keySet().iterator();

    int a = it.next();
    int b = it.next();

    int minFreq = Math.min(a, b);
    int maxFreq = Math.max(a, b);

    return maxFreq == 2 * minFreq;
  }
}
