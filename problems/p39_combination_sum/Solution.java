package problems.p39_combination_sum;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.combinationSum(new int[] {2, 3, 6, 7}, 7));
  }

  private static void backtrack(
      List<List<Integer>> result,
      List<Integer> currentList,
      int target,
      int[] candidates,
      int start) {
    if (target == 0) {
      result.add(new ArrayList<>(currentList));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      if (candidates[i] > target) break;

      currentList.add(candidates[i]);

      backtrack(result, currentList, target - candidates[i], candidates, i);

      currentList.removeLast();
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(result, new ArrayList<>(), target, candidates, 0);
    return result;
  }
}
