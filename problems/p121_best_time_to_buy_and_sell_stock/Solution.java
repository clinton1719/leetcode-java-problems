package problems.p121_best_time_to_buy_and_sell_stock;

public class Solution {
  public int maxProfit(int[] prices) {
    int maxProfit = 0;
    int buy = Integer.MAX_VALUE;

    for (int price : prices) {
      int profit = price - buy;
      if (profit > maxProfit) maxProfit = profit;

      if (price < buy) buy = price;
    }

    return maxProfit;
  }

  static void main() {
    int[] nums = {7, 1, 5, 3, 6, 4};
    Solution solution = new Solution();
    System.out.println(solution.maxProfit(nums));
  }
}
