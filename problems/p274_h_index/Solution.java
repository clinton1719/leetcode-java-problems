package problems.p274_h_index;


import java.util.Arrays;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.hIndex(new int[] {3, 0, 6, 1, 5}));
  }

    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);

        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }

        return 0;
    }
}
