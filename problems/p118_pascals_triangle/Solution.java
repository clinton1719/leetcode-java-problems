package problems.p118_pascals_triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.generate(5));
  }

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
      List<Integer> row = new ArrayList<>();
      for (int j = 0; j < i + 1; j++) {
        if (j == 0 || j == i) {
          row.add(1);
          continue;
        }
        row.add(result.getLast().get(j) + result.getLast().get(j - 1));
      }
      result.add(row);
    }

    return result;
  }
}
