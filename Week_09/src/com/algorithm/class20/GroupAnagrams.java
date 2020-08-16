package com.algorithm.class20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
 * @date 2020/8/16 22:35<br>
 */
public class GroupAnagrams {
  /**
   * https://leetcode-cn.com/problems/group-anagrams/solution/zi-fu-chuan-pai-xu-by-vame-2/
   *
   * @param strs
   * @return
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    if (strs.length == 0) {
      return new ArrayList<>();
    }
    Map<String, List<String>> result = new HashMap<>();
    for (String s : strs) {
      char[] a = s.toCharArray();
      Arrays.sort(a);
      String key = String.valueOf(a);
      if (!result.containsKey(key)) {
        result.put(key, new ArrayList<>());
      }
      result.get(key).add(s);
    }
    return new ArrayList<>(result.values());
  }
}
