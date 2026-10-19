package problems.p135_candy;

import java.util.Arrays;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.candy(new int[] {1, 2, 87, 87, 87, 2, 1}));
  }

  public int candy(int[] ratings) {
    int n = ratings.length;
    int[] candies = new int[n];
    Arrays.fill(candies, 1);

    // Left to right: satisfy the left-neighbour condition
    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) {
        candies[i] = candies[i - 1] + 1;
      }
    }

    // Right to left: satisfy the right-neighbour condition
    int total = candies[n-1];
    for (int i = n - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        candies[i] = Math.max(candies[i], candies[i + 1] + 1);
      }
      total += candies[i];
    }

    return total;
  }
}
