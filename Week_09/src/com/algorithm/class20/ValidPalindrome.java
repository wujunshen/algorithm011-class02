package com.algorithm.class20;

/**
 * 125. 验证回文串
 *
 * <p>给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * <p>说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * <p>示例 1:
 *
 * <p>输入: "A man, a plan, a canal: Panama" 输出: true 示例 2:
 *
 * <p>输入: "race a car" 输出: false
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/16 23:25<br>
 */
public class ValidPalindrome {
  /**
   * https://leetcode-cn.com/problems/valid-palindrome/solution/marveljian-dan-de-xue-xi-bi-ji-125-by-tyanyonecanc/
   *
   * @param s
   * @return
   */
  public boolean isPalindrome(String s) {
    s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
    char[] c = s.toCharArray();
    int i = 0, j = c.length - 1;
    while (i < j) {
      if (c[i] != c[j]) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
