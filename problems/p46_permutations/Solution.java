package problems.p46_permutations;

import java.util.*;

public class Solution {
  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.permute(new int[] {1, 2, 3}));
  }

  private static void backtrack(
      List<List<Integer>> result, List<Integer> currentList, int n, int[] nums) {
    if (currentList.size() == n) {
      result.add(new ArrayList<>(currentList));
      return;
    }

    for (int i = 0; i < n; i++) {
      if (currentList.contains(nums[i])) continue;

      currentList.add(nums[i]);

      backtrack(result, currentList, n, nums);

      currentList.removeLast();
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), nums.length, nums);
    return result;
  }
}
