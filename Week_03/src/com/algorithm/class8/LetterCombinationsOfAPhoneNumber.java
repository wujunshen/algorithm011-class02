package com.algorithm.class8;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * <p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * <p>示例:
 *
 * <p>输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/7 17:45<br>
 */
public class LetterCombinationsOfAPhoneNumber {
  private final String[] letterMap = {
    " ", // 0
    "", // 1
    "abc", // 2
    "def", // 3
    "ghi", // 4
    "jkl", // 5
    "mno", // 6
    "pqrs", // 7
    "tuv", // 8
    "wxyz" // 9
  };

  private ArrayList<String> res;

  public List<String> letterCombinations(String digits) {
    res = new ArrayList<>();
    if (digits.equals("")) {
      return res;
    }

    findCombination(digits, 0, "");
    return res;
  }

  private void findCombination(String digits, int index, String s) {
    if (index == digits.length()) {
      res.add(s);
      return;
    }

    Character c = digits.charAt(index);
    String letters = letterMap[c - '0'];
    for (int i = 0; i < letters.length(); i++) {
      findCombination(digits, index + 1, s + letters.charAt(i));
    }
  }
}
