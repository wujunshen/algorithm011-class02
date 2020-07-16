package com.algorithm.homework.medium;

/**
 * 55. 跳跃游戏
 *
 * <p>给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * <p>数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * <p>判断你是否能够到达最后一个位置。
 *
 * <p>示例 1:
 *
 * <p>输入: [2,3,1,1,4] 输出: true 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。 示例 2:
 *
 * <p>输入: [3,2,1,0,4] 输出: false 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 11:08<br>
 */
public class JumpGame {
  public boolean canJump(int[] nums) {
    if (nums[0] == 0 && nums.length > 1) {
      return false;
    } // 特判，数组第一个元素为0且数组元素大于一个的时候，必定不能到达

    // 未跳过的0的数量
    int count = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 0) {
        count++; // 遇到0，未跳过的0计数+1
        for (int j = 0; j < i; j++) {
          if (nums[j] >= i - j + 1) {
            count--; // 如果遇到的这个0前面有数字可以跳过它，那么未跳过的0计数-1
            break; // 跳过之后就去寻找下一个0
          }
        }
      }
    }
    // 如果所有的0都能跳过，那么未跳过的0计数为0，返回true
    return count == 0;
  }
}
