package com.algorithm.homework.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 *
 * <p>定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * <p>如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * <p>所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * <p>示例 1:
 *
 * <p>输入: s = "egg", t = "add" 输出: true 示例 2:
 *
 * <p>输入: s = "foo", t = "bar" 输出: false 示例 3:
 *
 * <p>输入: s = "paper", t = "title" 输出: true 说明: 你可以假设 s 和 t 具有相同的长度。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/22 17:32<br>
 */
public class IsomorphicStrings {
  /**
   * https://leetcode-cn.com/problems/isomorphic-strings/solution/tong-gou-zi-fu-chuan-by-xiao-shi-hou-2/
   *
   * @param s
   * @param t
   * @return
   */
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (!map.containsKey(s.charAt(i))) {
        if (map.containsValue(t.charAt(i))) {
          return false;
        }
        map.put(s.charAt(i), t.charAt(i));
      } else {
        if (map.get(s.charAt(i)) != t.charAt(i)) {
          return false;
        }
      }
    }
    return true;
  }
}
