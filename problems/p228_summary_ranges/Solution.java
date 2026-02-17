package problems.p228_summary_ranges;

import java.util.*;

public class Solution {
  static void main() {
    int[] nums = {1, 2};
    Solution solution = new Solution();
    System.out.println(solution.summaryRanges(new int[] {-2147483648,0,2,3,4,6,8,9}));
  }

  public List<String> summaryRanges(int[] nums) {
    if (nums.length == 0) return new ArrayList<>();
    List<String> answer = new ArrayList<>();
    int previousNum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if ((long) nums[i] - nums[i - 1] > 1) {
        if (previousNum == nums[i - 1]) {
          answer.add(String.valueOf(previousNum));
        } else {
          answer.add(previousNum + "->" + nums[i - 1]);
        }
        previousNum = nums[i];
      }
    }

    if (previousNum == nums[nums.length - 1]) {
      answer.add(String.valueOf(previousNum));
    } else {
      answer.add(previousNum + "->" + nums[nums.length - 1]);
    }

    return answer;
  }
}
