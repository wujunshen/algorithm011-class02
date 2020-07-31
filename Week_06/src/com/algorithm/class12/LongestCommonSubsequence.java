package com.algorithm.class12;

/**
 * 1143. 最长公共子序列
 *
 * <p>给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * <p>一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 例如，"ace" 是 "abcde"
 * 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * <p>若这两个字符串没有公共子序列，则返回 0。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入：text1 = "abcde", text2 = "ace" 输出：3 解释：最长公共子序列是 "ace"，它的长度为 3。 示例 2:
 *
 * <p>输入：text1 = "abc", text2 = "abc" 输出：3 解释：最长公共子序列是 "abc"，它的长度为 3。 示例 3:
 *
 * <p>输入：text1 = "abc", text2 = "def" 输出：0 解释：两个字符串没有公共子序列，返回 0。
 *
 * <p>提示:
 *
 * <p>1 <= text1.length <= 1000 1 <= text2.length <= 1000 输入的字符串只含有小写英文字符。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/29 17:37<br>
 */
public class LongestCommonSubsequence {
  public int longestCommonSubsequence(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        // 获取两个串字符
        char c1 = text1.charAt(i);
        char c2 = text2.charAt(j);
        if (c1 == c2) {
          // 去找它们前面各退一格的值加1即可
          dp[i + 1][j + 1] = dp[i][j] + 1;
        } else {
          // 要么是text1往前退一格，要么是text2往前退一格，两个的最大值
          dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
        }
      }
    }
    return dp[m][n];
  }
}
