package com.algorithm.class12;

/**
 * 188. 买卖股票的最佳时机 IV
 *
 * <p>给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * <p>设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * <p>注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * <p>示例 1:
 *
 * <p>输入: [2,4,1], k = 2 输出: 2 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2
 * = 2 。 示例 2:
 *
 * <p>输入: [3,2,6,5,0,3], k = 2 输出: 7 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润
 * = 6-2 = 4 。   随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:41<br>
 */
public class BestTimeToBuyAndSellStockIV {
  /**
   * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
   *
   * @param k
   * @param prices
   * @return
   */
  public int maxProfit(int k, int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int n = prices.length;
    if (k > n / 2) {
      return bestTimeToBuyAndSellStockII(prices);
    }

    int[][][] dp = new int[n][k + 1][2];
    for (int i = 0; i < n; i++) {
      for (int j = k; j >= 1; j--) {
        if (i - 1 == -1) {
          dp[i][j][0] = 0;
          dp[i][j][1] = -prices[i];
          continue;
        }
        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
      }
    }
    // 穷举了 n × max_k × 2 个状态，正确。
    return dp[n - 1][k][0];
  }

  private int bestTimeToBuyAndSellStockII(int[] prices) {
    int unHoldStockProfit = 0;
    int holdStockProfit = Integer.MIN_VALUE;
    for (int price : prices) {
      int temp = unHoldStockProfit;
      unHoldStockProfit = Math.max(unHoldStockProfit, holdStockProfit + price);
      holdStockProfit = Math.max(holdStockProfit, temp - price);
    }
    return unHoldStockProfit;
  }
}
