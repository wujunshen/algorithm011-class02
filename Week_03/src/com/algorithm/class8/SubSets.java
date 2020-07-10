package com.algorithm.class8;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * <p>给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * <p>说明：解集不能包含重复的子集。
 *
 * <p>示例:
 *
 * <p>输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/subsets 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/7 17:34<br>
 */
public class SubSets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(0, nums, res, new ArrayList<>());
    return res;
  }

  private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
    res.add(new ArrayList<>(tmp));
    for (int j = i; j < nums.length; j++) {
      tmp.add(nums[j]);
      backtrack(j + 1, nums, res, tmp);
      tmp.remove(tmp.size() - 1);
    }
  }
}
