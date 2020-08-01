package com.algorithm.homework.hard;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 *
 * <p>给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。
 *
 * <p>示例:
 *
 * <p>输入: matrix = [[1,0,1],[0,-2,3]], k = 2 输出: 2 解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k
 * 的最大数字（k = 2）。 说明：
 *
 * <p>矩阵内的矩形区域面积必须大于 0。 如果行数远大于列数，你将如何解答呢？
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:52<br>
 */
public class MaxSumOfRectangleNoLargerThanK {
  /**
   * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/discuss/83634/Java-233mm-solution-with-dynamic-programming
   *
   * @param matrix
   * @param target
   * @return
   */
  public int maxSumSubmatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int maxValue = Integer.MIN_VALUE;
    int h = matrix.length;
    int w = matrix[0].length;
    int[] dp;

    for (int i = 0; i < w; i++) {
      dp = new int[h];
      for (int j = i; j < w; j++) {
        for (int k = 0; k < h; k++) {
          dp[k] = dp[k] + matrix[k][j];
        }
        int p = getVal2(dp, target);
        if (maxValue < p) {
          maxValue = p;
        }
      }
    }
    return maxValue;
  }

  public int getVal2(int[] dp, int t) {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < dp.length; i++) {
      sum += dp[i];
      int cur = sum;

      for (int j = -1; j <= i; j++) {
        if (j == -1) {
          cur = sum;
        } else {
          cur -= dp[j];
        }
        if (cur > t) {
          continue;
        }
        if (i != j) {
          max = Math.max(max, cur);
        }
      }
    }
    return max;
  }
}
