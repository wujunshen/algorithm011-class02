package com.algorithm.homework.hard;

/**
 * 37. 解数独
 *
 * <p>编写一个程序，通过已填充的空格来解决数独问题。
 *
 * <p>一个数独的解法需遵循如下规则：
 *
 * <p>数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 空白格用 '.' 表示。
 *
 * <p>一个数独。
 *
 * <p>答案被标成红色。
 *
 * <p>Note:
 *
 * <p>给定的数独序列只包含数字 1-9 和字符 '.' 。 你可以假设给定的数独只有唯一解。 给定数独永远是 9x9 形式的。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/5 20:28<br>
 */
public class SudokuSolver {
  /**
   * https://leetcode-cn.com/problems/sudoku-solver/solution/zi-cong-wo-xue-hui-liao-hui-su-suan-fa-zhong-yu-hu/%E5%9B%9E%E6%BA%AF%E7%AE%97%E6%B3%95%E8%AF%A6%E8%A7%A3%E4%BF%AE%E8%AE%A2%E7%89%88.md
   *
   * @param board
   */
  public void solveSudoku(char[][] board) {
    // 初始化
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        backtrack(board, row, col);
      }
    }
  }

  public boolean backtrack(char[][] board, int i, int j) {
    int m = 9;
    int n = 9;
    if (j == n) {
      // 穷举到最后一列的话就换到下一行重新开始。
      return backtrack(board, i + 1, 0);
    }

    if (i == m) {
      // 找到一个可行解，触发 base case
      return true;
    }

    // 如果该位置是预设的数字，不用我们操心
    if (board[i][j] != '.') {
      return backtrack(board, i, j + 1);
    }

    for (char ch = '1'; ch <= '9'; ch++) {
      // 如果遇到不合法的数字，就跳过
      if (!isValid(board, i, j, ch)) {
        continue;
      }

      board[i][j] = ch;
      // 如果找到一个可行解，立即结束
      if (backtrack(board, i, j + 1)) {
        return true;
      }
      board[i][j] = '.';
    }
    // 穷举完 1~9，依然没有找到可行解，此路不通
    return false;
  }

  /**
   * 判断 board[i][j] 是否可以填入 n
   *
   * @param board
   * @param r
   * @param c
   * @param n
   * @return
   */
  private boolean isValid(char[][] board, int r, int c, char n) {
    for (int i = 0; i < 9; i++) {
      // 判断列是否存在重复
      if (board[r][i] == n) {
        return false;
      }

      // 判断行是否存在重复
      if (board[i][c] == n) {
        return false;
      }

      // 判断 3 x 3 方框是否存在重复
      if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n) {
        return false;
      }
    }
    return true;
  }
}
