package com.algorithm.class4;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 *
 * <p>给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * <p>求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * <p>
 *
 * <p>以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * <p>
 *
 * <p>图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * <p>
 *
 * <p>示例:
 *
 * <p>输入: [2,1,5,6,2,3] 输出: 10
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/27 00:40<br>
 */
public class LargestRectangleInHistogram {
  /**
   * 找两边第一个小于它的值
   *
   * @param heights
   * @return
   */
  public int largestRectangleArea(int[] heights) {
    int res = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    int[] newHeights = new int[heights.length + 2];
    System.arraycopy(heights, 0, newHeights, 1, heights.length);
    // System.out.println(Arrays.toString(new_heights));
    for (int i = 0; i < newHeights.length; i++) {
      // System.out.println(stack.toString());
      while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
        int cur = stack.pop();
        res = Math.max(res, (i - stack.peek() - 1) * newHeights[cur]);
      }
      stack.push(i);
    }
    return res;
  }
}
