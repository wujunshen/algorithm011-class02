package com.algorithm.class20;

/**
 * 115. 不同的子序列
 *
 * <p>给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *
 * <p>一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * <p>题目数据保证答案符合 32 位带符号整数范围。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：S = "rabbbit", T = "rabbit" 输出：3 解释：
 *
 * <p>如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。 (上箭头符号 ^ 表示选取的字母)
 *
 * <p>rabbbit ^^^^ ^^ rabbbit ^^ ^^^^ rabbbit ^^^ ^^^ 示例 2：
 *
 * <p>输入：S = "babgbag", T = "bag" 输出：5 解释：
 *
 * <p>如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 (上箭头符号 ^ 表示选取的字母)
 *
 * <p>babgbag ^^ ^ babgbag ^^ ^ babgbag ^ ^^ babgbag ^ ^^ babgbag ^^^ 通过次数17,338提交次数35,548
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/22 01:17<br>
 */
public class DistinctSubsequences {
  /**
   * https://leetcode-cn.com/problems/distinct-subsequences/solution/jian-dan-yi-dong-de-qu-jian-dpsi-lu-jian-ji-ming-l/
   *
   * @param S
   * @param T
   * @return
   */
  public int numDistinct(String S, String T) {
    int n = S.length();
    int m = T.length();
    int[][] dp = new int[n + 1][m + 1];

    // 初始化，如果S是空串，但是T不是空串，那么出现次数为0
    for (int j = 0; j <= m; j++) {
      dp[0][j] = 0;
    }
    // 初始化，如果S不是空串，但是T是空串，出现次数为1
    for (int i = 0; i <= n; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        // 初始值就是不想等的情况
        dp[i][j] = dp[i - 1][j];
        if (S.charAt(i - 1) == T.charAt(j - 1)) {
          dp[i][j] += dp[i - 1][j - 1];
        }
      }
    }
    return dp[n][m];
  }
}
