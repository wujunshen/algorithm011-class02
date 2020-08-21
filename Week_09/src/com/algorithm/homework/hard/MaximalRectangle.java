package com.algorithm.homework.hard;

import java.util.Arrays;

/**
 * 85. 最大矩形
 *
 * <p>给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * <p>示例:
 *
 * <p>输入: [ ["1","0","1","0","0"], ["1","0","1","1","1"], ["1","1","1","1","1"],
 * ["1","0","0","1","0"] ] 输出: 6
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/22 00:52<br>
 */
public class MaximalRectangle {
  /**
   * https://leetcode.com/problems/maximal-rectangle/discuss/29054/Share-my-DP-solution/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
   *
   * @param matrix
   * @return
   */
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    int maxArea = 0;
    int cols = matrix[0].length;
    int[] leftLessMin = new int[cols];
    int[] rightLessMin = new int[cols];
    // 初始化为-1，也就是最左边
    Arrays.fill(leftLessMin, -1);
    // 初始化为cols，也就是最右边
    Arrays.fill(rightLessMin, cols);
    int[] heights = new int[cols];
    for (char[] chars : matrix) {
      // 更新所有高度
      for (int col = 0; col < cols; col++) {
        if (chars[col] == '1') {
          heights[col] += 1;
        } else {
          heights[col] = 0;
        }
      }
      // 更新所有leftLessMin
      // 记录上次出现 0 的位置
      int boundary = -1;
      for (int col = 0; col < cols; col++) {
        if (chars[col] == '1') {
          // 和上次出现 0 的位置比较
          leftLessMin[col] = Math.max(leftLessMin[col], boundary);
        } else {
          // 当前是 0 代表当前高度是 0，所以初始化为 -1，防止对下次循环的影响
          leftLessMin[col] = -1;
          // 更新 0 的位置
          boundary = col;
        }
      }
      // 右边同理
      boundary = cols;
      for (int col = cols - 1; col >= 0; col--) {
        if (chars[col] == '1') {
          rightLessMin[col] = Math.min(rightLessMin[col], boundary);
        } else {
          rightLessMin[col] = cols;
          boundary = col;
        }
      }

      // 更新所有面积
      for (int col = cols - 1; col >= 0; col--) {
        int area = (rightLessMin[col] - leftLessMin[col] - 1) * heights[col];
        maxArea = Math.max(area, maxArea);
      }
    }
    return maxArea;
  }
}
