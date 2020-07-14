package com.algorithm.homework.medium;

/**
 * 529. 扫雷游戏
 *
 * <p>让我们一起来玩扫雷游戏！
 *
 * <p>给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1'
 * 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 *
 * <p>现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * <p>如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 *
 * <p>示例 1：
 *
 * <p>输入:
 *
 * <p>[['E', 'E', 'E', 'E', 'E'], ['E', 'E', 'M', 'E', 'E'], ['E', 'E', 'E', 'E', 'E'], ['E', 'E',
 * 'E', 'E', 'E']]
 *
 * <p>Click : [3,0]
 *
 * <p>输出:
 *
 * <p>[['B', '1', 'E', '1', 'B'], ['B', '1', 'M', '1', 'B'], ['B', '1', '1', '1', 'B'], ['B', 'B',
 * 'B', 'B', 'B']]
 *
 * <p>解释:
 *
 * <p>示例 2：
 *
 * <p>输入:
 *
 * <p>[['B', '1', 'E', '1', 'B'], ['B', '1', 'M', '1', 'B'], ['B', '1', '1', '1', 'B'], ['B', 'B',
 * 'B', 'B', 'B']]
 *
 * <p>Click : [1,2]
 *
 * <p>输出:
 *
 * <p>[['B', '1', 'E', '1', 'B'], ['B', '1', 'X', '1', 'B'], ['B', '1', '1', '1', 'B'], ['B', 'B',
 * 'B', 'B', 'B']]
 *
 * <p>解释:
 *
 * <p>
 *
 * <p>注意：
 *
 * <p>输入矩阵的宽和高的范围为 [1,50]。 点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
 * 输入面板不会是游戏结束的状态（即有地雷已被挖出）。 简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minesweeper
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 09:53<br>
 */
public class MineSweeper {
  public char[][] updateBoard(char[][] board, int[] click) {
    // M 雷置状态后直接退出
    if (board[click[0]][click[1]] == 'M') {
      board[click[0]][click[1]] = 'X';
      return board;
    }
    processCur(board, click[0], click[1]);
    return board;
  }

  private void processCur(char[][] board, int x, int y) {
    if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) {
      return;
    }

    // 只有E为未遍历
    if (board[x][y] != 'E') {
      return;
    }

    // 判断当前位置与多少雷相邻
    int curCount = mineCount(board, x, y);
    if (curCount > 0) {
      // 与雷相邻，更新当前状态，结束递归
      board[x][y] = (char) ('0' + curCount);
      return;
    }

    board[x][y] = 'B';
    // 对周围的位置进行处理
    processCur(board, x - 1, y - 1);
    processCur(board, x - 1, y);
    processCur(board, x - 1, y + 1);
    processCur(board, x, y - 1);
    processCur(board, x, y + 1);
    processCur(board, x + 1, y - 1);
    processCur(board, x + 1, y);
    processCur(board, x + 1, y + 1);
  }

  private int mineCount(char[][] board, int x, int y) {
    int count = 0;
    if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == 'M') {
      count++;
    }
    if (x - 1 >= 0 && board[x - 1][y] == 'M') {
      count++;
    }
    if (x - 1 >= 0 && y + 1 < board[0].length && board[x - 1][y + 1] == 'M') {
      count++;
    }
    if (y - 1 >= 0 && board[x][y - 1] == 'M') {
      count++;
    }
    if (y + 1 < board[0].length && board[x][y + 1] == 'M') {
      count++;
    }
    if (x + 1 < board.length && y - 1 >= 0 && board[x + 1][y - 1] == 'M') {
      count++;
    }
    if (x + 1 < board.length && board[x + 1][y] == 'M') {
      count++;
    }
    if (x + 1 < board.length && y + 1 < board[0].length && board[x + 1][y + 1] == 'M') {
      count++;
    }
    return count;
  }
}
