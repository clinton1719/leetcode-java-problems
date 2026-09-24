package problems.p322_coin_change;

import java.util.Arrays;

public class Solution {

  static void main() {
    Solution solution = new Solution();
    System.out.println(solution.coinChange(new int[] {1, 2, 5}, 11));
  }

  public int coinChange(int[] coins, int amount) {
    final int INF = 1 << 30;
    int coinsLength = coins.length;
    int[][] dp = new int[coinsLength + 1][amount + 1];

    for (int[] coinRow : dp) {
      Arrays.fill(coinRow, INF);
    }

    dp[0][0] = 0;

    for (int i = 1; i <= coinsLength; i++) {
      for (int j = 0; j <= amount; j++) {
        dp[i][j] = dp[i - 1][j];

        if (j >= coins[i - 1]) {
          dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i - 1]] + 1);
        }
      }
    }

    return dp[coinsLength][amount] == INF ? -1 : dp[coinsLength][amount];
  }
}
