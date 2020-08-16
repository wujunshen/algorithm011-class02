package com.algorithm.class20;

/**
 * 5. 最长回文子串
 *
 * <p>给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * <p>示例 1：
 *
 * <p>输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
 *
 * <p>输入: "cbbd" 输出: "bb"
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/16 23:40<br>
 */
public class LongestPalindromicSubString {
  /**
   * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-fa-san-fa-by-snakper/
   *
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    int max = 0;
    int maxleft = 0;
    int n = s.length();

    for (int i = 0; i < 2 * n - 1; i++) {
      // 中心发散法，包括空隙在内共有2*n-1个中心
      int left = i / 2;
      // 余数为0，中心为字符，余数为1，中心为空隙
      int right = left + i % 2;
      // 最长回文子串长度
      int length = 0;

      while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
        length = right - left + 1;
        left--;
        right++;
      }

      if (max < length) {
        // 取length后left--，这里加回来
        maxleft = left + 1;
        max = length;
      }
    }

    return s.substring(maxleft, maxleft + max);
  }
}
