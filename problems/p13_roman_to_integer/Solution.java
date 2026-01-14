package problems.p13_roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int romanToInt(String s) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);

    int total = 0;
    for (int i = 0; i < s.length(); i++) {
      int currentVal = map.get(s.charAt(i));

      if (i < s.length() - 1 && currentVal < map.get(s.charAt(i + 1))) {
        total -= currentVal;
      } else {
        total += currentVal;
      }
    }
    return total;
  }

  static void main() {
    String s = "MCMXCIV";
    Solution solution = new Solution();
    System.out.println(solution.romanToInt(s));
  }
}
