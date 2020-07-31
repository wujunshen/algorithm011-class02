package com.algorithm.class12;

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
 * @date 2020/7/30 20:51<br>
 */
public class CoinChangeDP {
  public int coinChange(int[] coins, int amount) {
    // 自底向上的动态规划
    if (coins.length == 0) {
      return -1;
    }

    // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
    int[] memo = new int[amount + 1];
    // 给memo赋初值，最多的硬币数就是全部使用面值1的硬币进行换
    // amount + 1 是不可能达到的换取数量，于是使用其进行填充
    Arrays.fill(memo, amount + 1);
    memo[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (i - coin >= 0) {
          // memo[i]有两种实现的方式，
          // 一种是包含当前的coins[i],那么剩余钱就是 i-coins[i],这种操作要兑换的硬币数是 memo[i-coins[j]] + 1
          // 另一种就是不包含，要兑换的硬币数是memo[i]
          memo[i] = Math.min(memo[i], memo[i - coin] + 1);
        }
      }
    }

    return memo[amount] == (amount + 1) ? -1 : memo[amount];
  }
}
