package com.algorithm.homework.hard;

import java.util.Arrays;

/**
 * 410. 分割数组的最大值
 *
 * <p>给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * <p>注意: 数组长度 n 满足以下条件:
 *
 * <p>1 ≤ n ≤ 1000 1 ≤ m ≤ min(50, n) 示例:
 *
 * <p>输入: nums = [7,2,5,10,8] m = 2
 *
 * <p>输出: 18
 *
 * <p>解释: 一共有四种方法将nums分割为2个子数组。 其中最好的方式是将其分为[7,2,5] 和 [10,8]， 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:54<br>
 */
public class SplitArrayLargestSum {
  /**
   * https://leetcode-cn.com/problems/split-array-largest-sum/solution/dong-tai-gui-hua-jie-fen-ge-shu-zu-ired-fox-by-a-f/
   *
   * @param nums
   * @param m
   * @return
   */
  public int splitArray(int[] nums, int m) {
    int n = nums.length;
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    int[] prefix = new int[n + 1];
    for (int i = 0; i < n; i++) {
      prefix[i + 1] = nums[i] + prefix[i];
    }
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= Math.min(m, i); j++) {
        for (int k = 0; k < i; k++) {
          dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], prefix[i] - prefix[k]));
        }
      }
    }
    return dp[n][m];
  }
}
