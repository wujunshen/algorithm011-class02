package com.algorithm.class20;

/**
 * 709. 转换成小写字母
 *
 * <p>实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入: "Hello" 输出: "hello" 示例 2：
 *
 * <p>输入: "here" 输出: "here" 示例 3：
 *
 * <p>输入: "LOVELY" 输出: "lovely"
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/to-lower-case
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/16 16:51<br>
 */
public class ToLowerCase {
  /**
   * https://leetcode-cn.com/problems/to-lower-case/solution/yi-chong-fei-chang-jian-dan-de-cao-zuo-by-ffza4ym7/
   *
   * @param str
   * @return
   */
  public String toLowerCase(String str) {
    char[] chars = str.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      if (chars[i] <= 90 && chars[i] >= 65) {
        chars[i] = (char) (chars[i] + 32);
      }
    }
    return String.valueOf(chars);
  }
}
