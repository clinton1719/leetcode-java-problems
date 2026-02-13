package problems.p383_ransom_note;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.canConstruct2("aa", "ab"));
  }

  public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < ransomNote.length(); i++) {
      map.compute(
          ransomNote.charAt(i),
          (character, count) -> {
            if (count == null) {
              return 1;
            }
            return ++count;
          });
    }

    for (int i = 0; i < magazine.length(); i++) {
      char currentChar = magazine.charAt(i);
      map.computeIfPresent(currentChar, (character, count) -> --count);
      if (map.containsKey(currentChar) && map.get(currentChar) == 0) {
        map.remove(currentChar);
      }
    }

    return map.isEmpty();
  }

  public boolean canConstruct2(String ransomNote, String magazine) {
    int[] ransomArray = new int[26];
    int ransomLength = ransomNote.length();

    for (int i = 0; i < ransomLength; i++) {
      ransomArray[ransomNote.charAt(i) - 'a']++;
    }

    for (int i = 0; i < magazine.length(); i++) {
      int currentChar = magazine.charAt(i) - 'a';
      ransomArray[currentChar]--;

      if (ransomArray[currentChar] >= 0) {
        ransomLength--;
      }

      if (ransomLength == 0) return true;
    }

    return ransomLength == 0;
  }
}
