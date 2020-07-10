package com.algorithm.class8;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 *
 * <p>给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * <p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: [3,2,3] 输出: 3 示例 2:
 *
 * <p>输入: [2,2,1,1,1,2,2] 输出: 2
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/7 17:44<br>
 */
public class MajorityElement {
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> counter = new HashMap<>();
    // 遍历每个数统计次数
    for (int num : nums) {
      counter.put(num, counter.getOrDefault(num, 0) + 1);
      // 如果某个数次数超过了n/2就返回
      if (counter.get(num) > nums.length / 2) {
        return num;
      }
    }
    return -1;
  }
}
