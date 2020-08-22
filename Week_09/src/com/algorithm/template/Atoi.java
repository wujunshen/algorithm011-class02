package com.algorithm.template;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/16 16:46<br>
 */
public class Atoi {
  public static int myAtoi(String str) {
    int index = 0, sign = 1, total = 0;
    // 1. Empty string
    if (str.length() == 0) {
      return 0;
    }
    // 2. Remove Spaces
    while (str.charAt(index) == ' ') {
      index++;
    }
    if (index == str.length()) {
      // 去掉前导空格以后到了末尾了
      return 0;
    }
    // 3. Handle signs
    if (str.charAt(index) == '+' || str.charAt(index) == '-') {
      sign = str.charAt(index) == '+' ? 1 : -1;
      index++;
    }

    // 4. Convert number and avoid overflow
    while (index < str.length()) {
      int digit = str.charAt(index) - '0';
      if (digit < 0 || digit > 9) {
        break;
      }
      // check if total will be overflow after 10 times and add digit
      if (Integer.MAX_VALUE / 10 < total
          || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }
      total = 10 * total + digit;
      index++;
    }
    return total * sign;
  }

  /**
   * 输入: "42" 输出: 42 示例 2:
   *
   * <p>输入: " -42" 输出: -42 解释: 第一个非空白字符为 '-', 它是一个负号。   我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。 示例 3:
   *
   * <p>输入: "4193 with words" 输出: 4193 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。 示例 4:
   *
   * <p>输入: "words and 987" 输出: 0 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。 因此无法执行有效的转换。 示例 5:
   *
   * <p>输入: "-91283472332" 输出: -2147483648 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。   因此返回 INT_MIN
   * (−231) 。
   *
   * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @param args
   */
  public static void main(String[] args) {
    String str = "42";
    System.out.println("value is:" + myAtoi(str));

    str = " -42";
    System.out.println("value is:" + myAtoi(str));

    str = "4193 with words";
    System.out.println("value is:" + myAtoi(str));

    str = "words and 987";
    System.out.println("value is:" + myAtoi(str));

    str = "-91283472332";
    System.out.println("value is:" + myAtoi(str));
  }
}
