package com.algorithm.class6;

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
 * @date 2020/7/2 19:12<br>
 */
public class SlidingWindowMaximum {

  public int[] maxSlidingWindow(int[] nums, int k) {
    int[] ans = new int[nums.length - k + 1];
    int maxIndex = -1;
    int j = 0;
    for (int i = 0; i < nums.length - k + 1; i++) {
      if (i <= maxIndex && maxIndex < i + k) {
        if (nums[maxIndex] <= nums[i + k - 1]) {
          maxIndex = i + k - 1;
        }
      } else {
        maxIndex = i;
        for (int m = i; m <= i + k - 1; m++) {
          if (nums[maxIndex] < nums[m]) {
            maxIndex = m;
          }
        }
      }
      ans[j++] = nums[maxIndex];
    }
    return ans;
  }
}
