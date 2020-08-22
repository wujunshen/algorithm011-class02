package com.algorithm.class20;

/**
 * 10. 正则表达式匹配
 *
 * <p>给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * <p>'.' 匹配任意单个字符 '*' 匹配零个或多个前面的那一个元素 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * <p>说明:
 *
 * <p>s 可能为空，且只包含从 a-z 的小写字母。 p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 示例 1:
 *
 * <p>输入: s = "aa" p = "a" 输出: false 解释: "a" 无法匹配 "aa" 整个字符串。 示例 2:
 *
 * <p>输入: s = "aa" p = "a*" 输出: true 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为
 * 'a' 重复了一次。 示例 3:
 *
 * <p>输入: s = "ab" p = ".*" 输出: true 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。 示例 4:
 *
 * <p>输入: s = "aab" p = "c*a*b" 输出: true 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * <p>输入: s = "mississippi" p = "mis*is*p*." 输出: false
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/22 17:17<br>
 */
public class RegularExpressionMatching {
  /**
   * https://leetcode-cn.com/problems/regular-expression-matching/solution/10-zheng-ze-biao-da-shi-pi-pei-by-ming-zhi-shan-yo/
   *
   * @param s
   * @param p
   * @return
   */
  public boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int i = 0; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (p.charAt(j - 1) != '*') {
          dp[i][j] = match(s, p, i, j) && dp[i - 1][j - 1];
        } else {
          dp[i][j] = match(s, p, i, j - 1) ? (dp[i][j - 2] || dp[i - 1][j]) : dp[i][j - 2];
        }
      }
    }
    return dp[m][n];
  }

  public boolean match(String s, String p, int i, int j) {
    if (i == 0) {
      return false;
    }
    if (p.charAt(j - 1) == '.') {
      return true;
    }
    return s.charAt(i - 1) == p.charAt(j - 1);
  }
}
