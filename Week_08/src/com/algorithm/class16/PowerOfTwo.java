package com.algorithm.class16;

/**
 * 231. 2的幂
 *
 * <p>给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * <p>示例 1:
 *
 * <p>输入: 1 输出: true 解释: 20 = 1 示例 2:
 *
 * <p>输入: 16 输出: true 解释: 24 = 16 示例 3:
 *
 * <p>输入: 218 输出: false
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/11 22:51<br>
 */
public class PowerOfTwo {
  /**
   * https://leetcode-cn.com/problems/power-of-two/solution/power-of-two-er-jin-zhi-ji-jian-by-jyd/
   *
   * @param n
   * @return
   */
  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }
}
