package problems.p122_best_time_to_buy_and_sell_stock_ii;

public class Solution {
  static void main() {
    int[] nums = {7, 1, 5, 3, 6, 4};
    Solution solution = new Solution();
    System.out.println(solution.maxProfit(nums));
  }

  public int maxProfit(int[] prices) {
    int profit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        profit += prices[i] - prices[i - 1];
      }
    }

    return profit;
  }
}
