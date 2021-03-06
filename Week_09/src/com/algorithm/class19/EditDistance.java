package com.algorithm.class19;

/**
 * 72. 编辑距离
 *
 * <p>给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * <p>你可以对一个单词进行如下三种操作：
 *
 * <p>插入一个字符 删除一个字符 替换一个字符
 *
 * <p>示例 1：
 *
 * <p>输入：word1 = "horse", word2 = "ros" 输出：3 解释： horse -> rorse (将 'h' 替换为 'r') rorse -> rose (删除
 * 'r') rose -> ros (删除 'e') 示例 2：
 *
 * <p>输入：word1 = "intention", word2 = "execution" 输出：5 解释： intention -> inention (删除 't') inention
 * -> enention (将 'i' 替换为 'e') enention -> exention (将 'n' 替换为 'x') exention -> exection (将 'n' 替换为
 * 'c') exection -> execution (插入 'u')
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:51<br>
 */
public class EditDistance {
  /**
   * https://leetcode-cn.com/problems/edit-distance/solution/jian-dan-dpmiao-dong-by-sweetiee/
   *
   * @param word1
   * @param word2
   * @return
   */
  public int minDistance(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();
    int[][] dp = new int[len1 + 1][len2 + 1];
    for (int i = 0; i <= len1; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j <= len2; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= len1; i++) {
      for (int j = 1; j <= len2; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
        }
      }
    }
    return dp[len1][len2];
  }
}
