package com.algorithm.homework.medium;

/**
 * 74. 搜索二维矩阵
 *
 * <p>编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * <p>每行中的整数从左到右按升序排列。 每行的第一个整数大于前一行的最后一个整数。 示例 1:
 *
 * <p>输入: matrix = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] target = 3 输出: true 示例 2:
 *
 * <p>输入: matrix = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] target = 13 输出: false
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 23:18<br>
 */
public class SearchA2dMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix.length < 1) {
      return false;
    }
    int row = getRow(matrix, target);
    return find(matrix[row], target);
  }

  public int getRow(int[][] matrix, int target) {
    int top = 0;
    int bottom = matrix.length - 1;
    int col = matrix[0].length - 1;
    while (top < bottom) {
      int mid = (top + bottom) / 2;
      if (matrix[mid][col] < target) {
        top = mid + 1;
      } else {
        bottom = mid;
      }
    }
    return top;
  }

  /**
   * 二分查找
   *
   * @param data
   * @param target
   * @return
   */
  public boolean find(int[] data, int target) {
    int l = 0;
    int r = data.length - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (data[mid] == target) {
        return true;
      } else if (data[mid] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return false;
  }
}
