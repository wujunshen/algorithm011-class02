package com.algorithm.class20;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/22 17:13<br>
 */
public class LongestPalindromicSubStringDP {
  /**
   * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
   *
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    // 特判
    int len = s.length();
    if (len < 2) {
      return s;
    }

    int maxLen = 1;
    int begin = 0;

    // dp[i][j] 表示 s[i, j] 是否是回文串
    boolean[][] dp = new boolean[len][len];
    char[] charArray = s.toCharArray();

    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }
    for (int j = 1; j < len; j++) {
      for (int i = 0; i < j; i++) {
        if (charArray[i] != charArray[j]) {
          dp[i][j] = false;
        } else {
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }

        // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
        if (dp[i][j] && j - i + 1 > maxLen) {
          maxLen = j - i + 1;
          begin = i;
        }
      }
    }
    return s.substring(begin, begin + maxLen);
  }
}
