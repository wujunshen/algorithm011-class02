package com.algorithm.homework.medium;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * <p>假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * <p>( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * <p>请找出其中最小的元素。
 *
 * <p>你可以假设数组中不存在重复元素。
 *
 * <p>示例 1:
 *
 * <p>输入: [3,4,5,1,2] 输出: 1 示例 2:
 *
 * <p>输入: [4,5,6,7,0,1,2] 输出: 0
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 23:19<br>
 */
public class FindMinimumInRotatedSortedArray {
  public int findMin(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    // 如果不排除这种情况，[1,2]就会出错。
    if (nums[r] > nums[l]) {
      return nums[l];
    }
    while (l < r) {
      int mid = l + ((r - l) >> 1);
      // 左边有序，排除左边
      if (nums[0] <= nums[mid]) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    return nums[l];
  }
}
