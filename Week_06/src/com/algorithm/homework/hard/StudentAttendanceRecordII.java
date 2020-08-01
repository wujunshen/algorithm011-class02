package com.algorithm.homework.hard;

/**
 * 552. 学生出勤记录 II
 *
 * <p>给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。 答案可能非常大，你只需返回结果mod 109 + 7的值。
 *
 * <p>学生出勤记录是只包含以下三个字符的字符串：
 *
 * <p>'A' : Absent，缺勤 'L' : Late，迟到 'P' : Present，到场 如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。
 *
 * <p>示例 1:
 *
 * <p>输入: n = 2 输出: 8 解释： 有8个长度为2的记录将被视为可奖励： "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数超过一次。 注意：n 的值不会超过100000。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/student-attendance-record-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:54<br>
 */
public class StudentAttendanceRecordII {
  /**
   * https://leetcode-cn.com/problems/student-attendance-record-ii/solution/javadong-tai-gui-hua-ru-he-yi-bu-bu-si-kao-yu-shi-/
   *
   * @param n
   * @return
   */
  public int checkRecord(int n) {
    int mod = 1000000007;
    long dp00 = 1;
    long dp01 = 1;
    long dp10 = 1;
    long dp11 = 0;
    long dp02 = 0;
    long dp12 = 0;

    for (int i = 2; i <= n; i++) {
      long t00 = dp00;
      long t10 = dp10;
      dp00 = (t00 + dp01 + dp02) % mod;
      dp10 = (t10 + dp11 + dp12 + t00 + dp01 + dp02) % mod;
      dp02 = dp01;
      dp01 = t00;
      dp12 = dp11;
      dp11 = t10;
    }

    return (int) ((dp00 + dp01 + dp02 + dp10 + dp11 + dp12) % mod);
  }
}
