package com.algorithm.class14;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 773. 滑动谜题
 *
 * <p>在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 *
 * <p>一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 *
 * <p>最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 *
 * <p>给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 *
 * <p>示例：
 *
 * <p>输入：board = [[1,2,3],[4,0,5]] 输出：1 解释：交换 0 和 5 ，1 步完成 输入：board = [[1,2,3],[5,4,0]] 输出：-1
 * 解释：没有办法完成谜板 输入：board = [[4,1,2],[5,0,3]] 输出：5 解释： 最少完成谜板的最少移动次数是 5 ， 一种移动路径: 尚未移动:
 * [[4,1,2],[5,0,3]] 移动 1 次: [[4,1,2],[0,5,3]] 移动 2 次: [[0,1,2],[4,5,3]] 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]] 移动 5 次: [[1,2,3],[4,5,0]] 输入：board = [[3,2,4],[1,5,0]] 输出：14 提示：
 *
 * <p>board 是一个如上所述的 2 x 3 的数组. board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sliding-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/7 02:01<br>
 */
public class SlidingPuzzle {
  /**
   * https://leetcode-cn.com/problems/sliding-puzzle/solution/bfsjie-fa-a-java-by-sheng-guang-hui-zhi-cai-ni/
   *
   * @param board
   * @return
   */
  public int slidingPuzzle(int[][] board) {
    // find index of zero in board
    int[] index = findIndexOfZero(board);
    if (index.length == 0) {
      return -1;
    }
    // create start State
    State start = new State(board, 0, index[0], index[1]);
    // PQ
    PriorityQueue<State> pq = new PriorityQueue<>();
    pq.add(start);
    // Set
    Set<State> visited = new HashSet<>();
    visited.add(start);
    // moves
    int[][] moves = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    while (!pq.isEmpty()) {
      // poll State by priority
      State currState = pq.poll();
      if (currState.isGoal()) {
        return currState.taken;
      }
      for (int[] move : moves) {
        int x = currState.zeroSetX + move[0];
        int y = currState.zeroSetY + move[1];
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
          continue;
        }
        State newState = currState.swap(x, y);
        if (newState != null && visited.add(newState)) {
          pq.offer(newState);
        }
      }
    }
    return -1;
  }

  private int[] findIndexOfZero(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 0) {
          return new int[] {i, j};
        }
      }
    }
    return new int[] {};
  }
}

class State implements Comparable<State> {
  int[][] stateBoard;
  int taken;
  int zeroSetX;
  int zeroSetY;

  public State(int[][] stateBoard, int taken, int zeroSetX, int zeroSetY) {
    // 这里新建数组的原因是：直接赋地址的话, 若通过当前State的stateBoard创建了一个NewState,
    // 修改NewState.stateBoard的同时也会修改this.stateBoard
    this.stateBoard = new int[2][3];
    for (int i = 0; i < 2; i++) {
      System.arraycopy(stateBoard[i], 0, this.stateBoard[i], 0, 3);
    }
    this.taken = taken;
    this.zeroSetX = zeroSetX;
    this.zeroSetY = zeroSetY;
  }

  /**
   * swap board where x = zeroX, y = zeroY
   *
   * @param x
   * @param y
   * @return State
   */
  public State swap(int x, int y) {
    State res = new State(stateBoard, taken + 1, x, y);
    int temp = res.stateBoard[x][y];
    res.stateBoard[x][y] = res.stateBoard[zeroSetX][zeroSetY];
    res.stateBoard[zeroSetX][zeroSetY] = temp;
    return res;
  }

  /**
   * priority distance
   *
   * @return
   */
  public int distance() {
    int result = 0;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        if (stateBoard[i][j] == 0) {
          continue;
        }
        // 二维坐标曼哈顿距离计算：res = |x - i| + |y - j|
        int val = stateBoard[i][j] - 1;
        int x = val / 3;
        int y = val % 3;
        result += Math.abs(x - i) + Math.abs(y - j);
      }
    }
    return result;
  }

  public boolean isGoal() {
    return distance() == 0;
  }

  /**
   * compare all states in PQ while poll or remove
   *
   * @param that
   * @return
   */
  @Override
  public int compareTo(State that) {
    return this.distance() + this.taken - that.distance() - that.taken;
  }

  @Override
  public boolean equals(Object obj) {
    return Arrays.deepEquals(((State) obj).stateBoard, this.stateBoard);
  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(stateBoard);
  }
}
