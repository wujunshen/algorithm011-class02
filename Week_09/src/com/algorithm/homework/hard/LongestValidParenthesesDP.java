package com.algorithm.homework.hard;

/**
 * 32. 最长有效括号
 *
 * <p>给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * <p>示例 1:
 *
 * <p>输入: "(()" 输出: 2 解释: 最长有效括号子串为 "()" 示例 2:
 *
 * <p>输入: ")()())" 输出: 4 解释: 最长有效括号子串为 "()()"
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:51<br>
 */
public class LongestValidParenthesesDP {
  /**
   * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zhan-he-dong-tai-gui-hua-liang-chong-jie-fa-by-ree/
   *
   * @param s
   * @return
   */
  public int longestValidParentheses(String s) {
    int max = 0;
    s = " " + s;
    int[] dp = new int[s.length()];
    for (int i = 2; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        if (s.charAt(i - 1) == '(') {
          dp[i] = dp[i - 2] + 2;
        } else if (s.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
        }
        max = Math.max(max, dp[i]);
      }
    }
    return max;
  }
}
