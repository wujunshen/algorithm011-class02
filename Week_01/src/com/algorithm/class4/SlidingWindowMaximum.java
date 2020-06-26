package com.algorithm.class4;

import java.util.Arrays;

/**
 * 239. 滑动窗口最大值
 *
 * <p>给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * <p>返回滑动窗口中的最大值。
 *
 * <p>
 *
 * <p>进阶：
 *
 * <p>你能在线性时间复杂度内解决此题吗？
 *
 * <p>
 *
 * <p>示例:
 *
 * <p>输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3 输出: [3,3,5,5,6,7] 解释:
 *
 * <p>滑动窗口的位置 最大值 --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5 3 6 7 3 1 3 [-1 -3 5] 3
 * 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3 -1 -3 5 [3 6 7] 7
 *
 * <p>提示：
 *
 * <p>1 <= nums.length <= 10^5 -10^4 <= nums[i] <= 10^4 1 <= k <= nums.length
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/27 00:44<br>
 */
public class SlidingWindowMaximum {
  /**
   * res[left]记录着当前最大值 窗口移除和增加时与res[left]进行比较
   * 保存最大的值的出现次数，当左侧移除掉的元素等于最大值时，次数减1，仅当次数等于0时，进行一下k次遍历，更新最大值
   *
   * <p>作者：lovXin
   * 链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/jian-dan-fang-fa-yi-li-jie-bu-dui-lie-zhi-you-ji-d/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] res = new int[nums.length + 1 - k];
    int maxCount = 1;

    // 初始的max值
    int max = findMax(Arrays.copyOfRange(nums, 0, k));

    res[0] = max;

    for (int left = 0; left < nums.length - k; left++) {
      if (nums[left] < res[left] && nums[left + k] < res[left]) {
        res[left + 1] = res[left];
        continue;
      }

      if (nums[left + k] > res[left]) {
        res[left + 1] = nums[left + k];
        maxCount = 1;
        continue;
      }

      if (nums[left + k] == res[left]) {
        res[left + 1] = nums[left + k];
        maxCount++;
        continue;
      }

      if (nums[left] == res[left]) {
        maxCount--;
        if (maxCount == 0) {
          res[left + 1] = findMax(Arrays.copyOfRange(nums, left + 1, left + k + 1));
          maxCount = 1;
        } else {
          res[left + 1] = res[left];
        }
      }
    }
    return res;
  }

  int findMax(int[] array) {
    int out = Integer.MIN_VALUE;
    for (int num : array) {
      out = Math.max(num, out);
    }
    return out;
  }
}
