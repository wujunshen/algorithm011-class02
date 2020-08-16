package com.algorithm.class20;

/**
 * 14. 最长公共前缀
 *
 * <p>编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * <p>如果不存在公共前缀，返回空字符串 ""。
 *
 * <p>示例 1:
 *
 * <p>输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
 *
 * <p>输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
 *
 * <p>所有输入只包含小写字母 a-z 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/16 18:04<br>
 */
public class LongestCommonPrefix {
  /**
   * https://leetcode-cn.com/problems/longest-common-prefix/solution/hua-jie-suan-fa-14-zui-chang-gong-gong-qian-zhui-b/
   *
   * @param strs
   * @return
   */
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String result = strs[0];
    for (int i = 1; i < strs.length; i++) {
      int j = 0;
      for (; j < result.length() && j < strs[i].length(); j++) {
        if (result.charAt(j) != strs[i].charAt(j)) {
          break;
        }
      }
      result = result.substring(0, j);
      if (result.equals("")) {
        return result;
      }
    }
    return result;
  }
}
