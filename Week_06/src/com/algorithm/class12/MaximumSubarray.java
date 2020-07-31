package com.algorithm.class12;

/**
 * 53. 最大子序和
 *
 * <p>给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * <p>示例:
 *
 * <p>输入: [-2,1,-3,4,-1,2,1,-5,4] 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 进阶:
 *
 * <p>如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/30 20:23<br>
 */
public class MaximumSubarray {
  public int maxSubArray(int[] nums) {
    if (nums == null) {
      return 0;
    }

    // 全局最大值
    int max = nums[0];
    // 前一个子组合的最大值,状态压缩
    int subMax = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (subMax > 0) {
        // 前一个子组合最大值大于0，正增益
        subMax = subMax + nums[i];
      } else {
        // 前一个子组合最大值小于0，抛弃前面的结果
        subMax = nums[i];
      }
      // 计算全局最大值
      max = Math.max(max, subMax);
    }

    return max;
  }
}
