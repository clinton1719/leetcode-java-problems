package problems.p97_interleaving_string;

import java.util.*;

public class Solution {
  Boolean[][] memo;
  int s1Length, s2Length, s3Length;
  String s1, s2, s3;

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.isInterleave("aa", "aa", "aaab"));
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) return false;
    s1Length = s1.length();
    s2Length = s2.length();
    s3Length = s3.length();
    this.s1 = s1;
    this.s2 = s2;
    this.s3 = s3;

    memo = new Boolean[s1.length() + 1][s2.length() + 1];

    return dfs(0, 0, 0);
  }

  // i for s1, j for s2 and k for s3 => s1 + s2 = s3
  private boolean dfs(int i, int j, int k) {
    if (k == s3Length && i == s1Length && j == s2Length) return true;

    if (memo[i][j] != null) {
      return memo[i][j];
    }

    boolean solution = false;
    if (i < s1Length && s1.charAt(i) == s3.charAt(k)) {
      solution = dfs(i + 1, j, k+1);
    }
    if (!solution && j < s2Length && s2.charAt(j) == s3.charAt(k)) {
      solution = dfs(i, j + 1, k+1);
    }

    memo[i][j] = solution;
    return memo[i][j];
  }
}
