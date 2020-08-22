package com.algorithm.homework.easy;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * <p>给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * <p>
 *
 * <p>示例：
 *
 * <p>s = "leetcode" 返回 0
 *
 * <p>s = "loveleetcode" 返回 2
 *
 * <p>提示：你可以假定该字符串只包含小写字母。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/16 17:21<br>
 */
public class FirstUniqueCharacterInAString {
  /**
   * https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/marveljian-dan-de-xue-xi-bi-ji-387-by-marvel_ty/
   *
   * @param s
   * @return
   */
  public int firstUniqChar(String s) {
    int index = -1;
    for (char c = 'a'; c <= 'z'; c++) {
      int first = s.indexOf(c);
      int last = s.lastIndexOf(c);
      if (first != -1 && first == last) {
        if (index == -1) {
          index = first;
        } else {
          index = Math.min(index, first);
        }
      }
    }
    return index;
  }
}
