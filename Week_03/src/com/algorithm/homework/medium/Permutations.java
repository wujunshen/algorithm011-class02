package com.algorithm.homework.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 *
 * <p>给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * <p>示例:
 *
 * <p>输入: [1,2,3] 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/7 17:12<br>
 */
public class Permutations {
  public List<List<Integer>> result = new LinkedList<>();

  public List<List<Integer>> permute(int[] nums) {
    if (nums.length == 0) {
      return result;
    }
    allPer(nums, new LinkedList<>());
    return result;
  }

  public void allPer(int[] nums, LinkedList<Integer> trace) {
    // 结束条件：组合的深度等于所有元素的数量
    if (trace.size() == nums.length) {
      result.add(new LinkedList(trace));
      return;
    }
    // 在选择列表中选出
    for (int num : nums) {
      // 进行剪枝操作，如果当前元素已经在组合当中了，那么我们就跳过这步
      if (trace.contains(num)) {
        continue;
      }
      // 做出当前选择
      trace.add(num);
      allPer(nums, trace);
      // 撤销当前选择
      trace.removeLast();
    }
  }
}
