package problems.p150_evaluate_reverse_polish_notation;

import java.util.Stack;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(
        solution.evalRPN(
            new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
  }

  private static String checkOperator(String token) {
    return switch (token) {
      case "+" -> "SUM";
      case "-" -> "DIFF";
      case "*" -> "MUL";
      case "/" -> "DIV";
      default -> null;
    };
  }

  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {
      String value = checkOperator(token);
      if (value != null) {
        int b = stack.pop();
        int a = stack.pop();

        if (value.equals("SUM")) {
          stack.push(a + b);
        }
        if (value.equals("DIFF")) {
          stack.push(a - b);
        }
        if (value.equals("MUL")) {
          stack.push(a * b);
        }
        if (value.equals("DIV")) {
          stack.push(a / b);
        }
      } else {
        stack.push(Integer.valueOf(token));
      }
    }

    return stack.pop();
  }
}
