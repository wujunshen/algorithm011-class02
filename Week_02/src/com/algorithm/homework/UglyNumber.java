package com.algorithm.homework;

/**
 * 剑指 Offer 49. 丑数
 *
 * <p>我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * <p>
 *
 * <p>示例:
 *
 * <p>输入: n = 10 输出: 12 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 说明:
 *
 * <p>1 是丑数。 n 不超过1690。 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/2 19:36<br>
 */
public class UglyNumber {
  public int nthUglyNumber(int n) {
    if (n <= 0) {
      return -1;
    }
    int[] dp = new int[n];
    dp[0] = 1;
    int p2, p3, p5;
    p2 = p3 = p5 = 0;
    for (int i = 1; i < n; i++) {
      dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
      if (dp[p2] * 2 == dp[i]) {
        p2++;
      }
      if (dp[p3] * 3 == dp[i]) {
        p3++;
      }
      if (dp[p5] * 5 == dp[i]) {
        p5++;
      }
    }
    return dp[n - 1];
  }
}
