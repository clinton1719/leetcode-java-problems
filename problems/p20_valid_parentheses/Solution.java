package problems.p20_valid_parentheses;

import java.util.*;

public class Solution {
  static void main() {
    int[] nums = {1, 2};
    Solution solution = new Solution();
    System.out.println(solution.isValid("([)]"));
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);

      if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
        stack.push(currentChar);
      } else {
        if (stack.isEmpty()) return false;

        char top = stack.pop();

        if (currentChar == ')' && top != '(') return false;
        if (currentChar == '}' && top != '{') return false;
        if (currentChar == ']' && top != '[') return false;
      }
    }

    return stack.isEmpty();
  }
}
