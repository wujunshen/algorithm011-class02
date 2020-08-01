package com.algorithm.homework.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * 403. 青蛙过河
 *
 * <p>一只青蛙想要过河。 假定河流被等分为 x 个单元格，并且在每一个单元格内都有可能放有一石子（也有可能没有）。 青蛙可以跳上石头，但是不可以跳入水中。
 *
 * <p>给定石子的位置列表（用单元格序号升序表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一个石子上）。 开始时， 青蛙默认已站在第一个石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格1跳至单元格2）。
 *
 * <p>如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 *
 * <p>请注意：
 *
 * <p>石子的数量 ≥ 2 且 < 1100； 每一个石子的位置序号都是一个非负整数，且其 < 231； 第一个石子的位置永远是0。 示例 1:
 *
 * <p>[0,1,3,5,6,8,12,17]
 *
 * <p>总共有8个石子。 第一个石子处于序号为0的单元格的位置, 第二个石子处于序号为1的单元格的位置, 第三个石子在序号为3的单元格的位置， 以此定义整个数组...
 * 最后一个石子处于序号为17的单元格的位置。
 *
 * <p>返回 true。即青蛙可以成功过河，按照如下方案跳跃： 跳1个单位到第2块石子, 然后跳2个单位到第3块石子, 接着 跳2个单位到第4块石子, 然后跳3个单位到第6块石子,
 * 跳4个单位到第7块石子, 最后，跳5个单位到第8个石子（即最后一块石子）。 示例 2:
 *
 * <p>[0,1,2,3,4,8,9,11]
 *
 * <p>返回 false。青蛙没有办法过河。 这是因为第5和第6个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/frog-jump
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/31 00:53<br>
 */
public class FrogJump {
  /**
   * https://leetcode-cn.com/problems/frog-jump/solution/acw-dong-tai-gui-hua-by-acw_weian-3/
   *
   * @param stones
   * @return
   */
  public boolean canCross(int[] stones) {
    int n = stones.length;
    Set<Integer>[] set = new HashSet[n];
    set[0] = new HashSet<>();
    set[0].add(0);
    int max = 1;
    int tmp;
    for (int i = 1; i < n; i++) {
      set[i] = new HashSet<>();
      for (int k = i - 1; k >= 0; k--) {
        tmp = stones[i] - stones[k];
        if (tmp > max) {
          break;
        }
        // 表示位置k可以抵达
        if (set[k].size() > 0) {
          // 枚举抵达位置k的所有步数
          for (Integer step : set[k]) {
            if (Math.abs(tmp - step) <= 1) {
              max = Math.max(max, tmp + 1);
              set[i].add(tmp);
            }
          }
        }
      }
    }
    return set[n - 1].size() > 0;
  }
}
