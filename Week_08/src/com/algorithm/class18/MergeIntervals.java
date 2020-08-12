package com.algorithm.class18;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 *
 * <p>给出一个区间的集合，请合并所有重叠的区间。
 *
 * <p>示例 1:
 *
 * <p>输入: [[1,3],[2,6],[8,10],[15,18]] 输出: [[1,6],[8,10],[15,18]] 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为
 * [1,6]. 示例 2:
 *
 * <p>输入: [[1,4],[4,5]] 输出: [[1,5]] 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/12 23:02<br>
 */
public class MergeIntervals {
  /**
   * https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
   *
   * @param intervals
   * @return
   */
  public int[][] merge(int[][] intervals) {
    // 先按照区间起始位置排序
    Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
    // 遍历区间
    int[][] result = new int[intervals.length][2];
    int idx = -1;
    for (int[] interval : intervals) {
      // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
      // 则不合并，直接将当前区间加入结果数组。
      if (idx == -1 || interval[0] > result[idx][1]) {
        result[++idx] = interval;
      } else {
        // 反之将当前区间合并至结果数组的最后区间
        result[idx][1] = Math.max(result[idx][1], interval[1]);
      }
    }
    return Arrays.copyOf(result, idx + 1);
  }
}
