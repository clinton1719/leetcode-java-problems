package problems.p77_combinations;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.combine(4, 2));
  }

  private static void backtrack(
      List<List<Integer>> result, List<Integer> currentList, int n, int k, int start) {
    if (currentList.size() == k) {
      result.add(new ArrayList<>(currentList));
      return;
    }

    for (int i = start; i <= n; i++) {
      currentList.add(i);
      backtrack(result, currentList, n, k, i + 1);
      currentList.removeLast();
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), n, k, 1);
    return result;
  }
}
