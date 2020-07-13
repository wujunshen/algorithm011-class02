package com.algorithm.class10;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 *
 * <p>给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: coins = [1, 2, 5], amount = 11 输出: 3 解释: 11 = 5 + 5 + 1 示例 2:
 *
 * <p>输入: coins = [2], amount = 3 输出: -1
 *
 * <p>说明: 你可以认为每种硬币的数量是无限的。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 11:00<br>
 */
public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    // 注意：因为要比较的是最小值，不可能是结果的初始化值就得赋一个最大值
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        // 如果可包含coin，那么剩余钱是i−coins，要兑换的硬币数是 dp[i−coins]+1
        if (coin <= i) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }
    return dp[amount] <= amount ? dp[amount] : -1;
  }
}
