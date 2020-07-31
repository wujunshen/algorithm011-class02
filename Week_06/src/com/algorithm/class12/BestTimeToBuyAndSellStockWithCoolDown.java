package com.algorithm.class12;

/**
 * 309. 最佳买卖股票时机含冷冻期
 *
 * <p>给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * <p>设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * <p>你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 示例:
 *
 * <p>输入: [1,2,3,0,2] 输出: 3 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * <p>来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:42<br>
 */
public class BestTimeToBuyAndSellStockWithCoolDown {
  /**
   * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
   *
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    int unHoldStockProfit = 0;
    int holdStockProfit = Integer.MIN_VALUE;
    // 代表 dp[i-2][0]
    int unHoldStockProfitWithCoolDown = 0;
    for (int price : prices) {
      int temp = unHoldStockProfit;
      unHoldStockProfit = Math.max(unHoldStockProfit, holdStockProfit + price);
      holdStockProfit = Math.max(holdStockProfit, unHoldStockProfitWithCoolDown - price);
      unHoldStockProfitWithCoolDown = temp;
    }
    return unHoldStockProfit;
  }
}
