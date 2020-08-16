package com.algorithm.class20;

/**
 * 557. 反转字符串中的单词 III
 *
 * <p>给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * <p>示例 1:
 *
 * <p>输入: "Let's take LeetCode contest" 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/16 18:46<br>
 */
public class ReverseWordsInAStringIII {
  public String reverseWords(String s) {
    String[] words = s.trim().split(" +");
    String[] result = new String[words.length];

    for (int i = 0; i < words.length; i++) {
      StringBuilder t = new StringBuilder();
      t.append(words[i]);
      result[i] = t.reverse().toString();
    }

    return String.join(" ", result);
  }
}
