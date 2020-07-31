package com.algorithm.homework.medium;

/**
 * 221. 最大正方形
 *
 * <p>在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * <p>示例:
 *
 * <p>输入:
 *
 * <p>1 0 1 0 0 1 0 1 1 1 1 1 1 1 1 1 0 0 1 0
 *
 * <p>输出: 4
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:48<br>
 */
public class MaximalSquare {
  /**
   * https://leetcode-cn.com/problems/maximal-square/solution/221-zui-da-zheng-fang-xing-tu-jie-shi-pin-yan-shi-/
   *
   * @param matrix
   * @return
   */
  public int maximalSquare(char[][] matrix) {
    int n = matrix.length;
    if (n == 0) {
      return 0;
    }
    int m = matrix[0].length;
    if (m == 0) {
      return 0;
    }
    int[][] dp = new int[n][m];
    int result = 0;
    // 初始化base case
    for (int i = 0; i < n; i++) {
      dp[i][0] = matrix[i][0] - '0';
      result = Math.max(dp[i][0], result);
    }
    for (int i = 0; i < m; i++) {
      dp[0][i] = matrix[0][i] - '0';
      result = Math.max(dp[0][i], result);
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (matrix[i][j] == '1') {
          // 计算dp[i][j];
          dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
          result = Math.max(dp[i][j], result);
        }
      }
    }
    return result * result;
  }
}
