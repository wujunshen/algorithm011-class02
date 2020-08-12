package com.algorithm.class18;

/**
 * 1244. 力扣排行榜
 *
 * <p>新一轮的「力扣杯」编程大赛即将启动，为了动态显示参赛者的得分数据，需要设计一个排行榜 Leaderboard。
 *
 * <p>请你帮忙来设计这个 Leaderboard 类，使得它有如下 3 个函数：
 *
 * <p>addScore(playerId, score)： 假如参赛者已经在排行榜上，就给他的当前得分增加 score 点分值并更新排行。
 * 假如该参赛者不在排行榜上，就把他添加到榜单上，并且将分数设置为 score。 top(K)：返回前 K 名参赛者的 得分总和。
 * reset(playerId)：将指定参赛者的成绩清零。题目保证在调用此函数前，该参赛者已有成绩，并且在榜单上。 请注意，在初始状态下，排行榜是空的。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：
 * ["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
 * [[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]] 输出：
 * [null,null,null,null,null,null,73,null,null,null,141]
 *
 * <p>解释： Leaderboard leaderboard = new Leaderboard (); leaderboard.addScore(1,73); // leaderboard =
 * [[1,73]]; leaderboard.addScore(2,56); // leaderboard = [[1,73],[2,56]];
 * leaderboard.addScore(3,39); // leaderboard = [[1,73],[2,56],[3,39]]; leaderboard.addScore(4,51);
 * // leaderboard = [[1,73],[2,56],[3,39],[4,51]]; leaderboard.addScore(5,4); // leaderboard =
 * [[1,73],[2,56],[3,39],[4,51],[5,4]]; leaderboard.top(1); // returns 73; leaderboard.reset(1); //
 * leaderboard = [[2,56],[3,39],[4,51],[5,4]]; leaderboard.reset(2); // leaderboard =
 * [[3,39],[4,51],[5,4]]; leaderboard.addScore(2,51); // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
 * leaderboard.top(3); // returns 141 = 51 + 51 + 39;
 *
 * <p>提示：
 *
 * <p>1 <= playerId, K <= 10000 题目保证 K 小于或等于当前参赛者的数量 1 <= score <= 100 最多进行 1000 次函数调用
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/design-a-leaderboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/12 23:15<br>
 */
public class Leaderboard {
  private final int[][] array = new int[12000][];
  int index = 0;

  /**
   * https://leetcode-cn.com/problems/design-a-leaderboard/solution/java-er-wei-shu-zu-cha-ru-pai-xu-gao-xiao-shi-xian/
   *
   * @param playerId
   * @param score
   */
  public void addScore(int playerId, int score) {
    int[] arrT = new int[2];
    arrT[0] = playerId;
    arrT[1] = score;
    int pot = search(playerId);
    if (pot == -1) {
      pot = index;
    }
    insert(arrT, pot);
  }

  private void insert(int[] arrT, int pot) {
    int i = pot;
    if (pot != index) {
      arrT[1] = array[pot][1] + arrT[1];
    }
    if (index != 0) {
      for (i = pot; i > 0 && arrT[1] > array[i - 1][1]; i--) {
        array[i] = array[i - 1];
      }
    }
    array[i] = arrT;
    if (pot == index) {
      index++;
    }
  }

  public int top(int k) {
    int tempInd = Math.min(k, index);
    int sum = 0;
    for (int i = 0; i < tempInd; i++) {
      sum += array[i][1];
    }

    return sum;
  }

  public void reset(int playerId) {
    int ret = search(playerId);
    int[] origin = array[ret];
    origin[1] = 0;
    if (index - ret + 1 >= 0) {
      System.arraycopy(array, ret + 1, array, ret + 1 - 1, index - ret + 1);
    }
    array[index - 1] = origin;
  }

  public int search(int playerId) {
    for (int i = 0; i < index; i++) {
      if (array[i][0] == playerId) {
        return i;
      }
    }
    return -1;
  }
}
