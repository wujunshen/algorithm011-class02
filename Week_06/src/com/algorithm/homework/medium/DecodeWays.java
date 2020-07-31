package com.algorithm.homework.medium;

/**
 * 91. 解码方法
 *
 * <p>一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * <p>'A' -> 1 'B' -> 2 ... 'Z' -> 26 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * <p>示例 1:
 *
 * <p>输入: "12" 输出: 2 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。 示例 2:
 *
 * <p>输入: "226" 输出: 3 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:48<br>
 */
public class DecodeWays {
  /**
   * https://leetcode-cn.com/problems/decode-ways/solution/javajie-ti-si-lu-xiang-jie-by-zackqf/
   *
   * @param s
   * @return
   */
  public int numDecodings(String s) {
    char[] arr = s.toCharArray();
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = arr[0] == '0' ? 0 : 1;
    if (s.length() <= 1) {
      return dp[1];
    }
    for (int i = 2; i <= s.length(); i++) {
      int n = (arr[i - 2] - '0') * 10 + (arr[i - 1] - '0');
      if (arr[i - 1] == '0' && arr[i - 2] == '0') {
        return 0;
      } else if (arr[i - 2] == '0') {
        dp[i] = dp[i - 1];
      } else if (arr[i - 1] == '0') {
        if (n > 26) {
          return 0;
        }
        dp[i] = dp[i - 2];
      } else if (n > 26) {
        dp[i] = dp[i - 1];
      } else {
        dp[i] = dp[i - 1] + dp[i - 2];
      }
    }
    return dp[dp.length - 1];
  }
}
