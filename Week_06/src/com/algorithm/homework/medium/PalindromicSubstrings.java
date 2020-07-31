package com.algorithm.homework.medium;

/**
 * 647. 回文子串
 *
 * <p>给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * <p>具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * <p>示例 1:
 *
 * <p>输入: "abc" 输出: 3 解释: 三个回文子串: "a", "b", "c". 示例 2:
 *
 * <p>输入: "aaa" 输出: 6 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa". 注意:
 *
 * <p>输入的字符串长度不会超过1000。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:50<br>
 */
public class PalindromicSubstrings {
  public int countSubstrings(String s) {
    if (s.length() == 0) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }
    // s里回文子串的个数
    int sum = 0;
    // 字符串长度
    int n = s.length();
    // 对角线上的先加上
    sum += n;

    // 从下标0处开始使用
    boolean[][] countPalindrome = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      countPalindrome[i][i] = true;
    }

    // 填表方向与矩阵连乘积问题相同，只是针对每一个当前问题，用到的已解决子问题的位置不同
    // 待检查字符串长度
    for (int r = 2; r <= n; r++) {
      for (int i = 0; i < n - r + 1; i++) {
        int j = i + r - 1;
        // 2个字符
        final boolean b = s.charAt(i) == s.charAt(j);
        if (r == 2) {
          if (b) {
            countPalindrome[i][j] = true;
            sum += 1;
          } else {
            countPalindrome[i][j] = false;
          }
          // 3个以上字符
        } else {
          // 状态转移方程
          countPalindrome[i][j] = countPalindrome[i + 1][j - 1] && b;
          if (countPalindrome[i][j]) {
            sum += 1;
          }
        }
      }
    }

    return sum;
  }
}
