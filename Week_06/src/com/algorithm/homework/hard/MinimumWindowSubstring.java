package com.algorithm.homework.hard;

/**
 * 76. 最小覆盖子串
 *
 * <p>给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * <p>示例：
 *
 * <p>输入: S = "ADOBECODEBANC", T = "ABC" 输出: "BANC" 说明：
 *
 * <p>如果 S 中不存这样的子串，则返回空字符串 ""。 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:55<br>
 */
public class MinimumWindowSubstring {
  /**
   * https://leetcode-cn.com/problems/minimum-window-substring/solution/java-yi-ge-shu-zu-ji-lu-pin-shu-de-hua-dong-chuang/
   *
   * @param s
   * @param t
   * @return
   */
  public String minWindow(String s, String t) {
    if (s == null || t == null || s.length() == 0 || t.length() == 0) {
      return "";
    }
    // 定义一个数字，用来记录字符串 t 中出现字符的频率，也就是窗口内需要匹配的字符和相应的频率
    int[] map = new int[128];
    for (char c : t.toCharArray()) {
      map[c]++;
    }
    int left = 0;
    int right = 0;
    // 匹配字符的个数
    int match = 0;
    // 最大的子串的长度
    int minLen = s.length() + 1;
    // 子串的起始位置 子串结束的位置(如果不存在这样的子串的话，start，end 都是 0，s.substring 截取就是 “”
    int start = 0;
    int end = 0;
    while (right < s.length()) {
      // 右边界的那个字符
      char charRight = s.charAt(right);
      // 可以理解为需要匹配的字符 charRight 减少了一个
      map[charRight]--;
      // 如果字符 charRight 在 t 中存在，那么经过这一次操作，只要个数大于等于 0，说明匹配了一个
      // 若字符 charRight 不在 t 中，那么 map[charRight] < 0, 不进行任何操作
      if (map[charRight] >= 0) {
        match++;
      }
      right++; // 右边界右移，这样下面就变成了 [)，方便计算窗口大小

      // 只要窗口内匹配的字符达到了要求，右边界固定，左边界收缩
      while (match == t.length()) {
        int size = right - left;
        if (size < minLen) {
          minLen = size;
          start = left;
          end = right;
        }
        // 左边的那个字符
        char charLeft = s.charAt(left);
        // 左边的字符要移出窗口
        map[charLeft]++;
        // 不在 t 中出现的字符，移出窗口，最终能够达到的最大值 map[charLeft] = 0
        // 如果恰好移出了需要匹配的一个字符，那么这里 map[charLeft] > 0, 也就是还要匹配字符 charLeft，此时 match--
        if (map[charLeft] > 0) {
          match--;
        }
        left++; // 左边界收缩
      }
    }
    return s.substring(start, end);
  }
}
