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

  public static void main(String[] args) {
    String str = "10908asd0hiqjde3lq9l";

    System.out.println("value is:" + myAtoi(str));
  }
}
