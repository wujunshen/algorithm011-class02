package com.algorithm.class18;

/**
 * 242. 有效的字母异位词
 *
 * <p>给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * <p>示例 1:
 *
 * <p>输入: s = "anagram", t = "nagaram" 输出: true 示例 2:
 *
 * <p>输入: s = "rat", t = "car" 输出: false 说明: 你可以假设字符串只包含小写字母。
 *
 * <p>进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/12 22:59<br>
 */
public class ValidAnagram {
  /**
   * https://leetcode-cn.com/problems/valid-anagram/solution/4xing-javadai-ma-shi-yong-tong-lai-jie-jue-ben-ti-/
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isAnagram(String s, String t) {
    int[] b = new int[26];
    for (int i = 0; i < s.length(); i++) {
      b[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      if (--b[t.charAt(i) - 'a'] < 0) {
        return false;
      }
    }
    return s.length() == t.length();
  }
}
