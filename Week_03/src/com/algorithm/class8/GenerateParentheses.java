package com.algorithm.class8;

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
  List<String> res = new ArrayList<>();

  public List<String> generateParenthesis(int n) {
    dfs(n, n, "");
    return res;
  }

  private void dfs(int left, int right, String curStr) {
    // 左右括号都不剩余了，递归终止
    if (left == 0 && right == 0) {
      res.add(curStr);
      return;
    }

    // 如果左括号还剩余的话，可以拼接左括号
    if (left > 0) {
      dfs(left - 1, right, curStr + "(");
    }

    // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
    if (right > left) {
      dfs(left, right - 1, curStr + ")");
    }
  }
}
