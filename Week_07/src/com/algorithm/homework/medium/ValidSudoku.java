package com.algorithm.homework.medium;

/**
 * 36. 有效的数独
 *
 * <p>判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * <p>数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * <p>上图是一个部分填充的有效的数独。
 *
 * <p>数独部分空格内已填入了数字，空白格用 '.' 表示
 *
 * <p>示例 1:
 *
 * <p>输入: [ ["5","3",".",".","7",".",".",".","."], ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."], ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"], ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."], [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"] ] 输出: true 示例 2:
 *
 * <p>输入: [   ["8","3",".",".","7",".",".",".","."],   ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],   ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],   ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],   [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"] ] 输出: false 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 说明:
 *
 * <p>一个有效的数独（部分已被填充）不一定是可解的。 只需要根据以上规则，验证已经填入的数字是否有效即可。 给定数独序列只包含数字 1-9 和字符 '.' 。 给定数独永远是 9x9 形式的。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/5 20:26<br>
 */
public class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    if (board == null || board.length > 9 || board[0].length > 9) {
      return false;
    }

    return backTrace(board, 0, 0);
  }

  public boolean backTrace(char[][] board, int row, int col) {
    // 如果col越界，那么重新指向下一行
    if (col == 9) {
      return backTrace(board, row + 1, 0);
    }
    // 如果row越界，说明遍历完成，那么当前返回true
    if (row == 9) {
      return true;
    }

    // 如果当前位置没有显示数字，直接跳向下一个位置
    if (board[row][col] == '.') {
      return backTrace(board, row, col + 1);
    }
    // 这个位置数字已给出，需要试探，
    if (board[row][col] != '.') {
      // 如果在当前位置上不成立直接返回false
      if (!isValid(board, row, col)) {
        return false;
      }
      // 如果这个位置上成立。直接试探下一个位置
      return backTrace(board, row, col + 1);
    }

    // 如果全部遍历之后，没有false那么就返回true
    return true;
  }

  private boolean isValid(char[][] board, int row, int col) {
    char ch = board[row][col];
    // 三个方向，任一方向，其它8个位置上的数和当前位置ch不能相同
    for (int k = 0; k < 9; k++) {
      // 同一行九个位置已出现 ch
      if (board[row][k] == ch) {
        if (k != col) {
          return false;
        }
      }
      // 同一列九个位置中已出现 ch
      if (board[k][col] == ch) {
        if (k != row) {
          return false;
        }
      }

      // 看其他8个位置是否出现ch
      // 同一个子数独九个位置中已出现 ch
      if (board[(row / 3) * 3 + k / 3][(col / 3) * 3 + k % 3] == ch) {
        if ((row / 3) * 3 + k / 3 != row && (col / 3) * 3 + k % 3 != col) {
          return false;
        }
      }
    }
    return true;
  }
}
