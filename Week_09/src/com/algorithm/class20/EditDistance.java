package com.algorithm.class20;

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
   * https://leetcode-cn.com/problems/edit-distance/solution/dong-tai-gui-hua-java-by-liweiwei1419/
   *
   * @param word1
   * @param word2
   * @return
   */
  public int minDistance(String word1, String word2) {
    // 由于 word1.charAt(i) 操作会去检查下标是否越界，因此
    // 在 Java 里，将字符串转换成字符数组是常见额操作

    char[] word1Array = word1.toCharArray();
    char[] word2Array = word2.toCharArray();

    int len1 = word1Array.length;
    int len2 = word2Array.length;

    // 多开一行一列是为了保存边界条件，即字符长度为 0 的情况，这一点在字符串的动态规划问题中比较常见
    int[][] dp = new int[len1 + 1][len2 + 1];

    // 初始化：当 word 2 长度为 0 时，将 word1 的全部删除
    for (int i = 1; i <= len1; i++) {
      dp[i][0] = i;
    }
    // 当 word1 长度为 0 时，就插入所有 word2 的字符
    for (int j = 1; j <= len2; j++) {
      dp[0][j] = j;
    }

    // 注意：填写 dp 数组的时候，由于初始化多设置了一行一列，横、纵坐标有个偏移
    for (int i = 0; i < len1; i++) {
      for (int j = 0; j < len2; j++) {
        // 这是最佳情况
        if (word1Array[i] == word2Array[j]) {
          dp[i + 1][j + 1] = dp[i][j];
          continue;
        }

        // 否则在以下三种情况中选出步骤最少的，这是「动态规划」的「最优子结构」
        // 1、在下标 i 处插入一个字符
        int insert = dp[i + 1][j] + 1;
        // 2、替换一个字符
        int replace = dp[i][j] + 1;
        // 3、删除一个字符
        int delete = dp[i][j + 1] + 1;
        dp[i + 1][j + 1] = Math.min(Math.min(insert, replace), delete);
      }
    }

    // 打印状态表格进行调试
    //        for (int i = 0; i <=len1; i++) {
    //            System.out.println(Arrays.toString(dp[i]));
    //        }
    return dp[len1][len2];
  }
}
