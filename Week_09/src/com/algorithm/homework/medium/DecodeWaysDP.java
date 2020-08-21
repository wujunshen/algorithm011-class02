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
public class DecodeWaysDP {
  /**
   * https://leetcode-cn.com/problems/decode-ways/solution/java-jian-dan-dp-shi-jian-ji-bai-100-by-jiafeilee/
   *
   * @param s
   * @return
   */
  public int numDecodings(String s) {
    char[] nums = s.toCharArray();
    int len = nums.length;
    // dp[i] 表示从第i+1个数到第n个数的所有方案数
    int[] dp = new int[len + 1];
    dp[len] = 1;
    // 从右往左
    for (int i = len - 1; i >= 0; i--) {
      // 注意判断0字符
      if (nums[i] == '0') {
        // 当开始位为0字符时不满足任意一个字母的解析，跳过
        continue;
      }
      int num = 0;
      for (int j = i; j < len && j - i < 2; j++) {
        num = num * 10 + (nums[j] - '0');
        // 对子状态dp[j+1]为0开头的也可进行添加，因为没有赋值为dp[j+1]为0
        if (num <= 26) {
          dp[i] += dp[j + 1];
        }
      }
    }
    return dp[0];
  }
}
