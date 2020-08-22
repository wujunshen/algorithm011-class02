package com.algorithm.homework.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * <p>给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * <p>字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * <p>说明：
 *
 * <p>字母异位词指字母相同，但排列不同的字符串。 不考虑答案输出的顺序。 示例 1:
 *
 * <p>输入: s: "cbaebabacd" p: "abc"
 *
 * <p>输出: [0, 6]
 *
 * <p>解释: 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。  示例 2:
 *
 * <p>输入: s: "abab" p: "ab"
 *
 * <p>输出: [0, 1, 2]
 *
 * <p>解释: 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。 起始索引等于 2 的子串是
 * "ab", 它是 "ab" 的字母异位词。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/16 23:14<br>
 */
public class FindAllAnagramsInAString {
  /**
   * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/chuang-kou-shu-zu-pai-xu-pan-duan-yi-wei-ci-by-bie/
   *
   * @param s
   * @param p
   * @return
   */
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> resultList = new ArrayList<>();
    if (s == null || s.length() == 0 || s.length() < p.length()) {
      return resultList;
    }

    char[] pChar = p.toCharArray();
    Arrays.sort(pChar);
    int pLen = p.length();
    for (int i = 0; i < s.length() - pLen + 1; i++) {
      String curr = s.substring(i, i + pLen);
      char[] currChar = curr.toCharArray();
      Arrays.sort(currChar);
      if (Arrays.equals(pChar, currChar)) {
        resultList.add(i);
      }
    }
    return resultList;
  }
}
