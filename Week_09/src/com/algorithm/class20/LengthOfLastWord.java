package com.algorithm.class20;

/**
 * 58. 最后一个单词的长度
 *
 * <p>给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * <p>如果不存在最后一个单词，请返回 0 。
 *
 * <p>说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 * <p>
 *
 * <p>示例:
 *
 * <p>输入: "Hello World" 输出: 5
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/16 16:58<br>
 */
public class LengthOfLastWord {
  public int lengthOfLastWord(String s) {
    String[] a = s.split(" ");
    int length = a.length;
    if (length == 0) {
      return 0;
    }
    return a[length - 1].length();
  }
}
