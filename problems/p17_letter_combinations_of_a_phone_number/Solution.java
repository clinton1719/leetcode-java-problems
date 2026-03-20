package problems.p17_letter_combinations_of_a_phone_number;

import java.util.*;

public class Solution {
  String[] phone_map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.letterCombinations("23"));
  }

  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) return Collections.emptyList();
    List<String> result = new ArrayList<>();
    backTrack("", digits, result);
    return result;
  }

  private void backTrack(String combination, String digitsRem, List<String> result) {
    if (digitsRem.isEmpty()) {
      result.add(combination);
    } else {
      String currentDigit = phone_map[digitsRem.charAt(0) - '2'];
      for (char c : currentDigit.toCharArray()) {
        backTrack(combination + c, digitsRem.substring(1), result);
      }
    }
  }
}
