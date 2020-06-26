package com.algorithm.class4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 *
 * <p>给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * <p>有效字符串需满足：
 *
 * <p>左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 *
 * <p>示例 1:
 *
 * <p>输入: "()" 输出: true
 *
 * <p>示例 2:
 *
 * <p>输入: "()[]{}" 输出: true
 *
 * <p>示例 3:
 *
 * <p>输入: "(]" 输出: false
 *
 * <p>示例 4:
 *
 * <p>输入: "([)]" 输出: false
 *
 * <p>示例 5:
 *
 * <p>输入: "{[]}" 输出: true
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/27 00:33<br>
 */
public class ValidParenthese {
  private static final Map<Character, Character> CHARACTER_MAP =
      new HashMap<>() {
        {
          put('{', '}');
          put('[', ']');
          put('(', ')');
          put('?', '?');
        }
      };

  public boolean isValid(String s) {
    if (s.length() > 0 && !CHARACTER_MAP.containsKey(s.charAt(0))) {
      return false;
    }
    LinkedList<Character> stack =
        new LinkedList<>() {
          {
            add('?');
          }
        };
    for (Character c : s.toCharArray()) {
      if (CHARACTER_MAP.containsKey(c)) {
        stack.addLast(c);
      } else if (!CHARACTER_MAP.get(stack.removeLast()).equals(c)) {
        return false;
      }
    }
    return stack.size() == 1;
  }
}
