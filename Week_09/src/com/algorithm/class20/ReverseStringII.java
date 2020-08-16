package com.algorithm.class20;

/**
 * 541. 反转字符串 II
 *
 * <p>给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * <p>如果剩余字符少于 k 个，则将剩余字符全部反转。 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * <p>示例:
 *
 * <p>输入: s = "abcdefg", k = 2 输出: "bacdfeg"
 *
 * <p>提示：
 *
 * <p>该字符串只包含小写英文字母。 给定字符串的长度和 k 在 [1, 10000] 范围内。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/16 18:19<br>
 */
public class ReverseStringII {
  private char[] chars;

  /**
   * https://leetcode-cn.com/problems/reverse-string-ii/solution/1ms-zui-hao-li-jie-de-javaban-by-gnuhpc/
   *
   * @param s
   * @param k
   * @return
   */
  public String reverseStr(String s, int k) {
    chars = s.toCharArray();
    int len = chars.length;
    for (int i = 0; i < len; ) {
      int left = len - i;
      if (left < k) {
        reverse(i, len - 1);
        break;
      } else {
        reverse(i, i + k - 1);
        i += 2 * k;
      }
    }
    return new String(chars);
  }

  /**
   * 翻转
   *
   * @param start
   * @param end
   */
  private void reverse(int start, int end) {
    char tmp;
    while (start < end) {
      tmp = chars[start];
      chars[start] = chars[end];
      chars[end] = tmp;
      start++;
      end--;
    }
  }
}
