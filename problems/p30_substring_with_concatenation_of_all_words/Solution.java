package problems.p30_substring_with_concatenation_of_all_words;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    List<Integer> ans =
        solution.findSubstring(
            "wordgoodgoodgoodbestword", new String[] {"word", "good", "best", "good"});
    ans.forEach(System.out::println);
  }

  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    Map<String, Integer> wordCount = new HashMap<>();

    // create a hash to handle duplicate words
    for (String word : words) {
      wordCount.merge(word, 1, Integer::sum);
    }

    int wordLength = words[0].length();
    int n = words.length;

    // we only need to loop through words[0].length characters
    for (int startPos = 0; startPos < wordLength; startPos++) {
      int left = startPos;
      int right = startPos;
      Map<String, Integer> currentWindow = new HashMap<>();

      while (right + wordLength <= s.length()) {
        String currentWord = s.substring(right, right + wordLength);
        right += wordLength;

        // cannot use this window since unknown word, so skip to end
        if (!wordCount.containsKey(currentWord)) {
          currentWindow.clear();
          left = right;
          continue;
        }

        currentWindow.merge(currentWord, 1, Integer::sum);

        // in case duplicate count is more, then remove left words one by one until condition
        // satisfied
        while (currentWindow.get(currentWord) > wordCount.get(currentWord)) {
          String leftWord = s.substring(left, left + wordLength);

          if (currentWindow.merge(leftWord, -1, Integer::sum) == 0) {
            currentWindow.remove(leftWord);
          }

          left += wordLength;
        }

        // if window length is achieved, add the result
        if (right - left == wordLength * n) {
          result.add(left);
        }
      }
    }

    return result;
  }
}
