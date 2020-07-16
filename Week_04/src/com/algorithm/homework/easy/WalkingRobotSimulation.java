package com.algorithm.homework.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. 模拟行走机器人
 *
 * <p>机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 *
 * <p>-2：向左转 90 度 -1：向右转 90 度 1 <= x <= 9：向前移动 x 个单位长度 在网格上有一些格子被视为障碍物。
 *
 * <p>第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 *
 * <p>机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 *
 * <p>返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入: commands = [4,-1,3], obstacles = [] 输出: 25 解释: 机器人将会到达 (3, 4) 示例 2：
 *
 * <p>输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]] 输出: 65 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
 *
 * <p>提示：
 *
 * <p>0 <= commands.length <= 10000 0 <= obstacles.length <= 10000 -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000 答案保证小于 2 ^ 31
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 11:07<br>
 */
public class WalkingRobotSimulation {
  public int robotSim(int[] commands, int[][] obstacles) {
    // 建立方向集数组，数组下标0123对应方向北东南西
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    // 方向
    int direction = 0;
    // 当前为位置
    int x = 0;
    int y = 0;
    // 最大欧式距离平方
    int result = 0;
    // 将阻碍点转为hashSet,方便快速查找
    Set<String> hashSet = new HashSet<>();
    for (int[] obs : obstacles) {
      hashSet.add(obs[0] + "," + obs[1]);
    }
    for (int com : commands) {
      // 如果com为-1，-2则计算转向后的方向
      if (com == -1) {
        // 向右转90°
        direction = (direction + 1) % 4;
      } else if (com == -2) {
        // 向左转90°==向右转270°
        direction = (direction + 3) % 4;
      } else if (com > 0) {
        while (com-- > 0) {
          // 计算下一节点x,y轴位置
          int nextX = x + directions[direction][0];
          int nextY = y + directions[direction][1];
          // 判断下一节点，是否为障碍点
          if (!hashSet.contains(nextX + "," + nextY)) {
            x = nextX;
            y = nextY;
            result = Math.max(result, x * x + y * y);
          } else {
            break;
          }
        }
      }
    }
    return result;
  }
}
