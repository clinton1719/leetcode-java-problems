package problems.p392_is_subsequence;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.isSubsequence("aaaaaa", "bbaaaa"));
  }

  public boolean isSubsequence(String s, String t) {
    int i = 0, j = 0;
    int sLen = s.length(), tLen = t.length();

    while (i < sLen && j < tLen) {
      while (j < tLen && t.charAt(j) != s.charAt(i)) j++;

      if (j < tLen && s.charAt(i) == t.charAt(j)) {
        i++;
        j++;
      }
    }

    return i == sLen;
  }
}
