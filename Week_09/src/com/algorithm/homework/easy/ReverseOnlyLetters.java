package com.algorithm.homework.easy;

/**
 * 917. 仅仅反转字母
 *
 * <p>给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入："ab-cd" 输出："dc-ba" 示例 2：
 *
 * <p>输入："a-bC-dEf-ghIj" 输出："j-Ih-gfE-dCba" 示例 3：
 *
 * <p>输入："Test1ng-Leet=code-Q!" 输出："Qedo1ct-eeLg=ntse-T!"
 *
 * <p>提示：
 *
 * <p>S.length <= 100 33 <= S[i].ASCIIcode <= 122  S 中不包含 \ or "
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/16 18:55<br>
 */
public class ReverseOnlyLetters {
  /**
   * https://leetcode-cn.com/problems/reverse-only-letters/solution/xiao-lu-100dai-ma-jian-ji-by-mark-42/
   *
   * @param s
   * @return
   */
  public String reverseOnlyLetters(String s) {
    char[] chars = s.toCharArray();
    int i = 0;
    int j = chars.length - 1;
    while (i < j) {
      while (i < j && (chars[i] < 'A' || (chars[i] > 'Z' && chars[i] < 'a') || chars[i] > 'z')) {
        i++;
      }
      while (i < j && (chars[j] < 'A' || (chars[j] > 'Z' && chars[j] < 'a') || chars[j] > 'z')) {
        j--;
      }
      if (i < j) {
        chars[i] ^= chars[j];
        chars[j] ^= chars[i];
        chars[i++] ^= chars[j--];
      }
    }
    return String.valueOf(chars);
  }
}
