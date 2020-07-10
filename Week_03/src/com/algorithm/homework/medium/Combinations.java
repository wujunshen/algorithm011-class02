package com.algorithm.homework.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 *
 * <p>给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * <p>示例:
 *
 * <p>输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/7 17:11<br>
 */
public class Combinations {
  public List<List<Integer>> combine(int n, int k) {
    if (k == n || k == 0) {
      List<Integer> row = new LinkedList<>();
      for (int i = 1; i <= k; ++i) {
        row.add(i);
      }
      return new LinkedList<>(Collections.singletonList(row));
    }
    // n - 1 里边选 k - 1 个
    List<List<Integer>> result = combine(n - 1, k - 1);
    // 每个结果加上 n
    result.forEach(e -> e.add(n));
    // 把 n - 1 个选 k 个的结果也加入
    result.addAll(combine(n - 1, k));
    return result;
  }
}
