package com.algorithm.class12;

/**
 * 63. 不同路径 II
 *
 * <p>一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * <p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * <p>现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * <p>网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * <p>说明：m 和 n 的值均不超过 100。
 *
 * <p>示例 1:
 *
 * <p>输入: [   [0,0,0],   [0,1,0],   [0,0,0] ] 输出: 2 解释: 3x3 网格的正中间有一个障碍物。 从左上角到右下角一共有 2 条不同的路径： 1.
 * 向右 -> 向右 -> 向下 -> 向下 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/29 17:31<br>
 */
public class UniquePathsII {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int n = obstacleGrid[0].length;
    int[] dp = new int[n + 1];
    dp[1] = 1;

    for (int[] ints : obstacleGrid) {
      for (int j = 1; j <= n; j++) {
        if (ints[j - 1] == 1) {
          dp[j] = 0;
        } else {
          dp[j] += dp[j - 1];
        }
      }
    }
    return dp[n];
  }
}
