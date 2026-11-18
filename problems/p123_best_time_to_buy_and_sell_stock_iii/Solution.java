package problems.p123_best_time_to_buy_and_sell_stock_iii;

public class Solution {
  static void main() {
    int[] prices = new int[] {3, 3, 5, 0, 0, 3, 1, 4};
    Solution solution = new Solution();
    System.out.println(solution.maxProfit(prices));
  }

  public int maxProfit(int[] prices) {
    int f1 = -prices[0]; // first buy stage, negative since we start with no funds
    int f2 = 0; // first sell
    int f3 = -prices[0]; // second buy, hypothetically no profit first buy
    int f4 = 0; //  second sell

    for (int i = 1; i < prices.length; i++) {
      int price = prices[i];

      f1 = Math.max(f1, -price);

      f2 = Math.max(f2, f1 + price);

      f3 = Math.max(f3, f2 - price);

      f4 = Math.max(f4, f3 + price);
    }

    return f4;
  }
}
