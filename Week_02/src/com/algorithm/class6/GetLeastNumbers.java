package com.algorithm.class6;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 40. 最小的k个数
 *
 * <p>输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [3,2,1], k = 2 输出：[1,2] 或者 [2,1] 示例 2：
 *
 * <p>输入：arr = [0,1,2,1], k = 1 输出：[0]
 *
 * <p>限制：
 *
 * <p>0 <= k <= arr.length <= 10000 0 <= arr[i] <= 10000
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/2 19:03<br>
 */
public class GetLeastNumbers {
  public int[] getLeastNumbers(int[] arr, int k) {
    if (k == 0 || arr.length == 0) {
      return new int[0];
    }
    // 默认是小根堆，实现大根堆需要重写一下比较器。
    Queue<Integer> priorityQueue = new PriorityQueue<>((v1, v2) -> v2 - v1);
    for (int num : arr) {
      if (priorityQueue.size() < k) {
        priorityQueue.offer(num);
      } else if (num < priorityQueue.peek()) {
        priorityQueue.poll();
        priorityQueue.offer(num);
      }
    }

    // 返回堆中的元素
    int[] res = new int[priorityQueue.size()];
    int idx = 0;
    for (int num : priorityQueue) {
      res[idx++] = num;
    }
    return res;
  }
}
