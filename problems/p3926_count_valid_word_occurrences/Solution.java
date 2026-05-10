package problems.p3926_count_valid_word_occurrences;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

  static void main() {
    new Solution()
        .countWordOccurrences(
            new String[] {"hello wor", "ld hello"}, new String[] {"hello", "world", "wor"});
  }

  public int[] countWordOccurrences(String[] chunks, String[] queries) {
    int n = queries.length;
    int[] ans = new int[n];

    StringBuilder sb = new StringBuilder();
    for (String chunk : chunks) {
      sb.append(chunk);
    }

    String string = sb.toString();

    Pattern pattern = Pattern.compile("[a-z]+(-[a-z]+)*");
    Matcher matcher = pattern.matcher(string);

    Map<String, Integer> wordCounts = new HashMap<>();

    while (matcher.find()) {
      String word = matcher.group();
      wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
    }

    for (int i = 0; i < n; i++) {
      ans[i] = wordCounts.getOrDefault(queries[i], 0);
    }

    return ans;
  }
}
