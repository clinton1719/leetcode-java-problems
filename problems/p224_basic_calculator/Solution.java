package problems.p224_basic_calculator;

import java.util.Stack;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.calculate("1-(     -2)"));
  }

  public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();

    int result = 0;
    int currentSign = 1;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (Character.isDigit(c)) {
        int startIndex = i;
        int number = 0;

        while (startIndex < s.length() && Character.isDigit(s.charAt(startIndex))) {
          number = (number * 10) + (s.charAt(startIndex++) - '0');
        }

        result += currentSign * number;
        i = startIndex - 1;
      } else if (c == '+') {
        currentSign = 1;
      } else if (c == '-') {
        currentSign = -1;
      } else if (c == '(') {
        stack.push(result);
        stack.push(currentSign);

        result = 0;
        currentSign = 1;
      } else if (c == ')') {
        result = (stack.pop() * result) + stack.pop();
      }
    }

    return result;
  }
}
