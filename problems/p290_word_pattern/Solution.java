package problems.p290_word_pattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
  }

  public boolean wordPattern(String pattern, String s) {
    Map<Character, String> map = new HashMap<>(pattern.length());
    String[] sArr = s.split(" ");
    Set<String> strings = new HashSet<>(sArr.length);

    if (sArr.length != pattern.length()) return false;

    for (int i = 0; i < pattern.length(); i++) {
      char c = pattern.charAt(i);
      if (map.containsKey(c)) {
        if (!map.get(c).equals(sArr[i])) {
          return false;
        }
      } else {
        if (strings.contains(sArr[i])) {
          return false;
        }
        map.put(c, sArr[i]);
        strings.add(sArr[i]);
      }
    }

    return true;
  }

    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (int i = 0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}
