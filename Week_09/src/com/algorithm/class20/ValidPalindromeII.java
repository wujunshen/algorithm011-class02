package com.algorithm.class20;

/**
 * 680. 验证回文字符串 Ⅱ
 *
 * <p>给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * <p>示例 1:
 *
 * <p>输入: "aba" 输出: True 示例 2:
 *
 * <p>输入: "abca" 输出: True 解释: 你可以删除c字符。 注意:
 *
 * <p>字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/16 23:31<br>
 */
public class ValidPalindromeII {
  /**
   * https://leetcode-cn.com/problems/valid-palindrome-ii/solution/java-zhi-guan-si-lu-yong-shi-8mschao-guo-8965-by-w/
   *
   * @param s
   * @return
   */
  public boolean validPalindrome(String s) {
    char[] chars = s.toCharArray();
    int i = 0, j = chars.length - 1;
    while (i < j) {
      if (chars[i] != chars[j]) {
        return isOky(chars, i + 1, j) || isOky(chars, i, j - 1);
      }
      i++;
      j--;
    }
    return true;
  }

  public boolean isOky(char[] chars, int i, int j) {
    while (i < j) {
      if (chars[i++] != chars[j--]) {
        return false;
      }
    }
    return true;
  }
}
