package com.algorithm.class11;

/**
 * 69. x 的平方根
 *
 * <p>实现 int sqrt(int x) 函数。
 *
 * <p>计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * <p>由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * <p>示例 1:
 *
 * <p>输入: 4 输出: 2 示例 2:
 *
 * <p>输入: 8 输出: 2 说明: 8 的平方根是 2.82842...,   由于返回类型是整数，小数部分将被舍去。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sqrtx 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/7 17:35<br>
 */
public class SqrtX {
  static int s;

  public static int mySqrt(int x) {
    s = x;
    if (x == 0) {
      return 0;
    }
    return ((int) (sqrts(x)));
  }

  /**
   * 牛顿迭代法
   *
   * <p>根号s的近似值：首先随便猜一个近似值x，然后不断令x等于x和s/x的平均数，迭代个六七次后x值就已经相当精确了。
   *
   * @param x
   * @return
   */
  public static double sqrts(double x) {
    double result = (x + s / x) / 2;
    if (result != x) {
      return sqrts(result);
    } else {
      return x;
    }
  }

  public static void main(String[] args) {
    System.out.println(mySqrt(4));
    System.out.println(mySqrt(8));
  }
}
