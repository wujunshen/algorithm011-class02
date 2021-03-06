package com.algorithm.homework.easy;

/**
 * 191. 位1的个数
 *
 * <p>编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：00000000000000000000000000001011 输出：3 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为
 * '1'。 示例 2：
 *
 * <p>输入：00000000000000000000000010000000 输出：1 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为
 * '1'。 示例 3：
 *
 * <p>输入：11111111111111111111111111111101 输出：31 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31
 * 位为 '1'。
 *
 * <p>提示：
 *
 * <p>请注意，在某些语言（如
 * Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。 在 Java
 * 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *
 * <p>进阶: 如果多次调用这个函数，你将如何优化你的算法？
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/11 22:37<br>
 */
public class NumberOf1Bits {
  public static void main(String[] args) {
    int n = 10;
    hammingWeight(n);
    //    System.out.println(hammingWeight(n));
  }

  private static String binaryToDecimal(int n) {
    StringBuilder str = new StringBuilder();
    while (n != 0) {
      str.insert(0, n % 2);
      n = n / 2;
    }
    return str.toString();
  }

  /**
   * https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
   *
   * <p>you need to treat n as an unsigned value
   *
   * @param n
   * @return
   */
  public static int hammingWeight(int n) {
    int sum = 0;
    // 在二进制表示中，数字 n 中最低位的 1 总是对应 n - 1 中的 0 。因此，将 n 和 n - 1 与运算总是能把 n 中最低位的 1 变成 0
    // ，并保持其他位不变。
    while (n != 0) {
      System.out.println(binaryToDecimal(n));
      sum++;
      n &= (n - 1);
      System.out.println(binaryToDecimal(n));
    }
    return sum;
  }
}
