package com.algorithm.homework.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * <p>数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * <p>
 *
 * <p>示例：
 *
 * <p>输入：n = 3 输出：[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/7 16:41<br>
 */
public class GenerateParentheses {
  private void generate(String item, int left, int right, List<String> result) {
    // 左括号和右括号满足上述条件的前提下都为n个，添加这个答案
    if (left == 0 && right == 0) {
      result.add(item);
      return;
    }
    // 左括号的个数小于n 才能继续放左括号
    if (left > 0) {
      generate(item + "(", left - 1, right, result);
    }
    // 左括号个数必须大于右括号的放置个数 才能继续放右括号
    if (left < right) {
      generate(item + ")", left, right - 1, result);
    }
  }

  /**
   * https://leetcode-cn.com/problems/generate-parentheses/solution/java-shi-ji-xing-dai-ma-ac-ji-yu-hui-su-si-xiang-d/
   *
   * @param n
   * @return
   */
  public List<String> generateParenthesis(int n) {
    // 左括号个数必须大于右括号的放置个数
    // 才能继续放右括号
    // 左括号的个数小于n
    // 才能继续放左括号
    // 左括号和右括号满足上述条件的前提下都为n个，添加这个答案
    List<String> result = new ArrayList<>();
    generate("", n, n, result);
    return result;
  }
}
