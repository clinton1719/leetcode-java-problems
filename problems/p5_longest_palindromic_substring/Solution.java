package problems.p5_longest_palindromic_substring;

import java.util.Arrays;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.longestPalindrome("babad"));
  }

  public String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];

    for (boolean[] arr : dp) {
      Arrays.fill(arr, true);
    }

    int startIndex = 0;
    int maxLength = 1;

    for (int i = n - 2; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        dp[i][j] = false;
        if (s.charAt(i) == s.charAt(j)) {
          if (dp[i + 1][j - 1]) {
            dp[i][j] = true;

            if (j - i + 1 > maxLength) {
              maxLength = j - i + 1;
              startIndex = i;
            }
          }
        }
      }
    }

    return s.substring(startIndex, startIndex + maxLength);
  }
}
