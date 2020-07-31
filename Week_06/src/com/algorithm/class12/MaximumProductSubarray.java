package com.algorithm.class12;

/**
 * 152. 乘积最大子数组
 *
 * <p>给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: [2,3,-2,4] 输出: 6 解释: 子数组 [2,3] 有最大乘积 6。 示例 2:
 *
 * <p>输入: [-2,0,-1] 输出: 0 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/30 20:42<br>
 */
public class MaximumProductSubarray {
  public int maxProduct(int[] nums) {
    int prevMin = nums[0];
    int prevMax = nums[0];
    int result = nums[0];

    int tempMax;
    int tempMin;

    for (int i = 1; i < nums.length; i++) {
      tempMax = nums[i] * prevMax;
      tempMin = nums[i] * prevMin;
      prevMax = Math.max(Math.max(tempMax, tempMin), nums[i]);
      prevMin = Math.min(Math.min(tempMax, tempMin), nums[i]);
      result = Math.max(result, prevMax);
    }
    return result;
  }
}
