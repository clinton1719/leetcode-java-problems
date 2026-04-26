package problems.p3913_sort_vowels_by_frequency;

import java.util.*;

public class Solution {
  Set vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));

  public String sortVowels(String s) {

    Map<Character, Integer> freqMap = new HashMap<>();
    Map<Character, Integer> orderMap = new HashMap<>();
    int order = 0;

    List<Integer> vowelPositions = new ArrayList<>();
    char[] arr = s.toCharArray();

    for (int i = 0; i < arr.length; i++) {
      char c = arr[i];
      if (vowels.contains(c)) {
        vowelPositions.add(i);
        freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        orderMap.putIfAbsent(c, order++);
      }
    }

    List<Character> uniqueVowels = new ArrayList<>(freqMap.keySet());
    uniqueVowels.sort(
        (a, b) -> {
          if (!freqMap.get(a).equals(freqMap.get(b))) {
            return freqMap.get(b) - freqMap.get(a);
          }
          return orderMap.get(a) - orderMap.get(b);
        });

    List<Character> sortedVowels = new ArrayList<>();
    for (char c : uniqueVowels) {
      int freq = freqMap.get(c);
      for (int i = 0; i < freq; i++) {
        sortedVowels.add(c);
      }
    }

    for (int i = 0; i < vowelPositions.size(); i++) {
      arr[vowelPositions.get(i)] = sortedVowels.get(i);
    }

    return new String(arr);
  }
}
