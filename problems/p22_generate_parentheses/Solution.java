package problems.p22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.generateParenthesis(3));
  }

  private static void backtrack(
      List<String> result,
      int leftPar,
      int rightPar,
      StringBuilder currentCombination,
      int maxPar) {
    if (leftPar == maxPar && rightPar == maxPar) {
      result.add(currentCombination.toString());
      return;
    }

    if (leftPar > 0 && rightPar < maxPar && rightPar < leftPar) {
      backtrack(result, leftPar, rightPar + 1, currentCombination.append(')'), maxPar);
      currentCombination.deleteCharAt(currentCombination.length() - 1);
    }
    if (leftPar < maxPar) {
      backtrack(result, leftPar + 1, rightPar, currentCombination.append('('), maxPar);
      currentCombination.deleteCharAt(currentCombination.length() - 1);
    }
  }

  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(result, 0, 0, new StringBuilder(), n);
    return result;
  }
}
