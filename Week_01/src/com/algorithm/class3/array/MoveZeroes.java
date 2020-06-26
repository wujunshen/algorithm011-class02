package com.algorithm.class3.array;

/**
 * 283. 移动零
 *
 * <p>给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * <p>示例:
 *
 * <p>输入: [0,1,0,3,12] 输出: [1,3,12,0,0] 说明:
 *
 * <p>必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/26 22:35<br>
 */
public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int index = 0;

    for (int num : nums) {
      if (num != 0) {
        nums[index++] = num;
      }
    }

    while (index < nums.length) {
      nums[index++] = 0;
    }
  }
}
