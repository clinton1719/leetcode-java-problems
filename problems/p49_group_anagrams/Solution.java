package problems.p49_group_anagrams;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
      char[] arr = s.toCharArray();
      Arrays.sort(arr);
      String key = new String(arr);

      map.putIfAbsent(key, new ArrayList<>());
      map.get(key).add(s);
    }

    return new ArrayList<>(map.values());
  }

  private static String generateHash(String word) {
    int[] hashArr = new int[26];
    for (int i = 0; i < word.length(); i++) {
      hashArr[word.charAt(i) - 'a']++;
    }

    StringBuilder hashString = new StringBuilder();
    for (int i = 0; i < hashArr.length; i++) {
      if (hashArr[i] > 0) {
        hashString.append((char) ((int) 'a' + i)).append(hashArr[i]);
      }
    }

    return hashString.toString();
  }

  public List<List<String>> groupAnagrams2(String[] strs) {
    Map<String, List<String>> map = new HashMap();

    for (String word : strs) {
      String hash = generateHash(word);
      map.computeIfAbsent(hash, k -> new ArrayList<>()).add(word);
    }

    List<List<String>> result = new ArrayList<>();
    result.addAll(map.values());
    return result;
  }
}
