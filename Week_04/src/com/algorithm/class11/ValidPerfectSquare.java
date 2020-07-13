package com.algorithm.class11;

/**
 * 367. 有效的完全平方数
 *
 * <p>给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * <p>说明：不要使用任何内置的库函数，如  sqrt。
 *
 * <p>示例 1：
 *
 * <p>输入：16 输出：True 示例 2：
 *
 * <p>输入：14 输出：False
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 23:13<br>
 */
public class ValidPerfectSquare {
  public boolean isPerfectSquare(int num) {
    if (num == 1) {
      return true;
    }
    int left = 1;
    int right = num / 2;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if ((long) mid * mid > num) {
        right = mid - 1;
      } else if ((long) mid * mid < num) {
        left = mid + 1;
      } else {
        return true;
      }
    }
    return false;
  }
}
