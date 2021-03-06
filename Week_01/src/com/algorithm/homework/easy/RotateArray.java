package com.algorithm.homework.easy;

/**
 * 189. 旋转数组
 *
 * <p>给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * <p>示例 1:
 *
 * <p>输入: [1,2,3,4,5,6,7] 和 k = 3 输出: [5,6,7,1,2,3,4] 解释: 向右旋转 1 步: [7,1,2,3,4,5,6] 向右旋转 2 步:
 * [6,7,1,2,3,4,5] 向右旋转 3 步: [5,6,7,1,2,3,4] 示例 2:
 *
 * <p>输入: [-1,-100,3,99] 和 k = 2 输出: [3,99,-1,-100] 解释: 向右旋转 1 步: [99,-1,-100,3] 向右旋转 2 步:
 * [3,99,-1,-100]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/25 23:13<br>
 */
public class RotateArray {
  public void rotate(int[] nums, int k) {
    k = k % nums.length;

    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}
