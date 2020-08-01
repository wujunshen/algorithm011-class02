package com.algorithm.homework.hard;

/**
 * 312. 戳气球
 *
 * <p>有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * <p>现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] *
 * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * <p>求所能获得硬币的最大数量。
 *
 * <p>说明:
 *
 * <p>你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 示例:
 *
 * <p>输入: [3,1,5,8] 输出: 167 解释: nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []   coins =
 * 3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:56<br>
 */
public class BurstBalloons {
  /**
   * https://leetcode-cn.com/problems/burst-balloons/solution/dong-tai-gui-hua-tao-lu-jie-jue-chuo-qi-qiu-wen-ti/
   *
   * @param nums
   * @return
   */
  int maxCoins(int[] nums) {
    int n = nums.length;
    // 添加两侧的虚拟气球
    int[] points = new int[n + 2];
    points[0] = points[n + 1] = 1;
    System.arraycopy(nums, 0, points, 1, n);
    // base case 已经都被初始化为 0
    int[][] dp = new int[n + 2][n + 2];
    // 开始状态转移
    // i 应该从下往上
    for (int i = n; i >= 0; i--) {
      // j 应该从左往右
      for (int j = i + 1; j < n + 2; j++) {
        // 最后戳破的气球是哪个？
        for (int k = i + 1; k < j; k++) {
          // 择优做选择
          dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]);
        }
      }
    }
    return dp[0][n + 1];
  }
}
