package problems.p6_zigzag_conversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.convert("PAYPALISHIRING", 3));
  }

  public String convert(String s, int numRows) {
    if (numRows == 1) return s;
    List<StringBuilder> rows = new ArrayList<>();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < numRows; i++) {
      rows.add(new StringBuilder());
    }

    int currRow = 0;
    boolean isDown = false;

    for (char c : s.toCharArray()) {
      rows.get(currRow).append(c);

      if (currRow == 0 || currRow == numRows - 1) {
        isDown = !isDown;
      }

      currRow += isDown ? 1 : -1;
    }

    for (StringBuilder row : rows) {
      result.append(row);
    }

    return result.toString();
  }
}
