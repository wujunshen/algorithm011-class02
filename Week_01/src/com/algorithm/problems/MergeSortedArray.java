package com.algorithm.problems;

/**
 * 88. 合并两个有序数组
 *
 * <p>给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * <p>说明:
 *
 * <p>初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * <p>示例:
 *
 * <p>输入: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 *
 * <p>输出: [1,2,2,3,5,6]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/26 22:20<br>
 */
public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int len1 = m - 1;
    int len2 = n - 1;
    int len = m + n - 1;

    while (len1 >= 0 && len2 >= 0) {
      // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
      nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
    }
    // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
    System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
  }
}
