package problems.p139_word_break;

import java.util.*;

public class Solution {
  private Map<Integer, Boolean> memo;

  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.wordBreakMemo(
            "catsandog", new ArrayList<>(List.of("cats", "dog", "sand", "and", "cat"))));
  }

  // brute force, won't work
  private static boolean recursionFirstCase(String s, List<String> wordDict, int i) {
    if (i == s.length()) return true;

    for (String word : wordDict) {
      if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
        if (recursionFirstCase(s, wordDict, i + word.length())) return true;
      }
    }
    return false;
  }

  public boolean wordBreakRecursion(String s, List<String> wordDict) {
    return recursionFirstCase(s, wordDict, 0);
  }

  public boolean wordBreakRecursionOptimized(String s, List<String> wordDict) {
    Set<String> dict = new HashSet<>(wordDict);
    return recursionSecondCase(s, dict, 0);
  }

  // still won't pass
  private boolean recursionSecondCase(String s, Set<String> dict, int i) {
    if (i == s.length()) return true;

    for (int j = i; j < s.length(); j++) {
      if (dict.contains(s.substring(i, j + 1))) {
        if (recursionSecondCase(s, dict, j + 1)) return true;
      }
    }

    return false;
  }

  public boolean wordBreakMemo(String s, List<String> wordDict) {
    memo = new HashMap<>();
    memo.put(s.length(), true);
    return recursionMemo(s, wordDict, 0);
  }

  private boolean recursionMemo(String s, List<String> wordDict, int i) {
    if (memo.containsKey(i)) {
      return memo.get(i);
    }

    for (String word : wordDict) {
      if (i + word.length() <= s.length() && word.equals(s.substring(i, i + word.length()))) {
        if (recursionMemo(s, wordDict, i + word.length())) {
          memo.put(i, true);
          return true;
        }
      }
    }

    memo.put(i, false);
    return false;
  }
}
