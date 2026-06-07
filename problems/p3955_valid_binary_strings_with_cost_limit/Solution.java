package problems.p3955_valid_binary_strings_with_cost_limit;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  static void main() {
    new Solution().generateValidStrings(3, 1);
  }

  public List<String> generateValidStrings(int n, int k) {
    List<String> answer = new ArrayList<>();

    backtrack(0, answer, new StringBuilder(), true, 0, k, n);

    return answer;
  }

  private void backtrack(
      int index,
      List<String> answer,
      StringBuilder binary,
      boolean isPreviousZero,
      int cost,
      int k,
      int n) {
    if (index == n) {
      answer.add(binary.toString());
      return;
    }

    binary.append("0");
    backtrack(index + 1, answer, binary, true, cost, k, n);
    binary.deleteCharAt(binary.length() - 1);

    if (isPreviousZero && cost + index <= k) {
      binary.append("1");
      backtrack(index + 1, answer, binary, false, cost + index, k, n);
      binary.deleteCharAt(binary.length() - 1);
    }
  }
}
