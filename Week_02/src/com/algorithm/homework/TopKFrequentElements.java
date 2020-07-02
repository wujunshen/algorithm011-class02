package com.algorithm.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 *
 * <p>给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: nums = [1,1,1,2,2,3], k = 2 输出: [1,2] 示例 2:
 *
 * <p>输入: nums = [1], k = 1 输出: [1]
 *
 * <p>提示：
 *
 * <p>你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 你可以按任意顺序返回答案。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/2 19:58<br>
 */
public class TopKFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    // 统计每个数字出现的次数
    for (int num : nums) {
      if (map.get(num) == null) {
        // 数字不存在于map中
        map.put(num, 1);
      } else {
        // 数字存在map中，取出次数并且加1
        int tmp = map.get(num);
        map.put(num, tmp + 1);
      }
    }
    // 创建大顶堆
    // 底层基于链表，只能设置初始长度，不能设置固定大小的堆。
    PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
    // 添加到堆中，完成堆化
    // 数组中有几个不同的key，堆中就有多少个元素，这些元素是按照其在map中的出现次数排序
    for (int num : map.keySet()) {
      heap.add(num);
    }
    // 转换成数组
    // 此处最好返回列表
    if (k > heap.size()) {
      return new int[] {};
    }
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = heap.poll();
    }
    return res;
  }
}
