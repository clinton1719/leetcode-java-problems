package problems.p188_best_time_to_buy_and_sell_stock_iv;

public class Solution {
  private Integer[][][] dp;
  private int[] prices;
  private int n;

  static void main() {
    int k = 2;
    int[] prices = new int[] {2, 4, 1};
    Solution solution = new Solution();
    System.out.println(solution.maxProfit(k, prices));
  }

  public int maxProfit(int k, int[] prices) {
    n = prices.length;
    this.prices = prices;
    dp = new Integer[n][k + 1][2];
    return dfs(0, k, 0);
  }

  private int dfs(int day, int transactionsLeft, int isHolding) {
    if (day >= n) return 0;

    // memoised value - early return
    if (dp[day][transactionsLeft][isHolding] != null) {
      return dp[day][transactionsLeft][isHolding];
    }

    // do nothing
    int maxProfit = dfs(day + 1, transactionsLeft, isHolding);

    // sell
    if (isHolding == 1) {
      maxProfit = Math.max(maxProfit, prices[day] + dfs(day + 1, transactionsLeft, 0));
    } else if (transactionsLeft > 0) {
      maxProfit = Math.max(maxProfit, -prices[day] + dfs(day + 1, transactionsLeft - 1, 1));
    }

    return dp[day][transactionsLeft][isHolding] = maxProfit;
  }
}
