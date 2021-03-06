package com.algorithm.class12;

/**
 * 714. 买卖股票的最佳时机含手续费
 *
 * <p>给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * <p>你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * <p>返回获得利润的最大值。
 *
 * <p>注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * <p>示例 1:
 *
 * <p>输入: prices = [1, 3, 2, 8, 4, 9], fee = 2 输出: 8 解释: 能够达到的最大利润: 在此处买入 prices[0] = 1 在此处卖出
 * prices[3] = 8 在此处买入 prices[4] = 4 在此处卖出 prices[5] = 9 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8. 注意:
 *
 * <p>0 < prices.length <= 50000. 0 < prices[i] < 50000. 0 <= fee < 50000.
 *
 * <p>来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:43<br>
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
  /**
   * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
   *
   * @param prices
   * @param fee
   * @return
   */
  public int maxProfit(int[] prices, int fee) {
    int unHoldStockProfit = 0;
    int holdStockProfit = Integer.MIN_VALUE;
    for (int price : prices) {
      int temp = unHoldStockProfit;
      unHoldStockProfit = Math.max(unHoldStockProfit, holdStockProfit + price);
      holdStockProfit = Math.max(holdStockProfit, temp - price - fee);
    }
    return unHoldStockProfit;
  }
}
