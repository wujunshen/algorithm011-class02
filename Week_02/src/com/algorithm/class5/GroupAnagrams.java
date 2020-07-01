package com.algorithm.class5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 *
 * <p>给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * <p>示例:
 *
 * <p>输入: ["eat", "tea", "tan", "ate", "nat", "bat"] 输出: [ ["ate","eat","tea"], ["nat","tan"],
 * ["bat"] ] 说明：
 *
 * <p>所有输入均为小写字母。 不考虑答案输出的顺序。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/1 00:30<br>
 */
public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>(16);

    for (String str : strs) {
      char[] c = str.toCharArray();
      Arrays.sort(c);
      String s = new String(c);
      List<String> list;
      if (map.containsKey(s)) {
        list = map.get(s);
      } else {
        list = new LinkedList<>();
      }
      list.add(str);
      map.put(s, list);
    }

    return new LinkedList<>(map.values());
  }
}
