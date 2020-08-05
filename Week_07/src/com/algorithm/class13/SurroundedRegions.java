package com.algorithm.class13;

import com.algorithm.template.UnionFindOptimize;

/**
 * 130. 被围绕的区域
 *
 * <p>给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * <p>找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * <p>示例:
 *
 * <p>X X X X X O O X X X O X X O X X 运行你的函数后，矩阵变为：
 *
 * <p>X X X X X X X X X X X X X O X X 解释:
 *
 * <p>被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/5 19:42<br>
 */
public class SurroundedRegions {
  static int rows;
  static int cols;

  public static void main(String[] args) {
    char[][] grid =
        new char[][] {
          {'X', 'X', 'X', 'X'},
          {'X', 'O', 'O', '1'},
          {'X', 'X', 'O', 'X'},
          {'X', 'O', 'X', 'X'}
        };

    solve(grid);

    for (char[] chars : grid) {
      for (int j = 0; j < grid[0].length; j++) {
        System.out.print(chars[j]);
      }
      System.out.println();
    }
    //        X X X X
    //        X X X X
    //        X X X X
    //        X O X X
  }

  public static void solve(char[][] board) {
    if (board == null || board.length == 0) {
      return;
    }

    rows = board.length;
    cols = board[0].length;

    // 多申请一个空间
    UnionFindOptimize uf = new UnionFindOptimize(rows * cols + 1);
    // 所有边界的 O 节点都和 dummy 节点合并
    int dummyNode = rows * cols;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == 'O') {
          // 当前节点在边界就和 dummy 合并
          if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
            uf.union(dummyNode, node(i, j));
          } else {
            // 将上下左右的 O 节点和当前节点合并
            if (board[i - 1][j] == 'O') {
              uf.union(node(i, j), node(i - 1, j));
            }
            if (board[i + 1][j] == 'O') {
              uf.union(node(i, j), node(i + 1, j));
            }
            if (board[i][j - 1] == 'O') {
              uf.union(node(i, j), node(i, j - 1));
            }
            if (board[i][j + 1] == 'O') {
              uf.union(node(i, j), node(i, j + 1));
            }
          }
        }
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        // 判断是否和 dummy 节点是一类
        if (uf.isConnected(node(i, j), dummyNode)) {
          board[i][j] = 'O';
        } else {
          board[i][j] = 'X';
        }
      }
    }
  }

  static int node(int i, int j) {
    return i * cols + j;
  }
}
