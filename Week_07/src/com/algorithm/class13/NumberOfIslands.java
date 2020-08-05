package com.algorithm.class13;

import com.algorithm.template.UnionFindOptimize;

/**
 * https://leetcode-cn.com/problems/number-of-islands/solution/bing-cha-ji-cha-ji-zhong-lian-tong-fen-liang-de-sh/
 *
 * <p>200. 岛屿数量
 *
 * <p>给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * <p>岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * <p>此外，你可以假设该网格的四条边均被水包围。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: { {'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'},
 * {'0','0','0','0','0'} } 输出: 1 示例 2:
 *
 * <p>输入: { {'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'},
 * {'0','0','0','1','1'} } 输出: 3 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 09:52<br>
 */
public class NumberOfIslands {

  public static void main(String[] args) {
    char[][] grid =
        new char[][] {
          {'1', '1', '1', '1', '0'},
          {'1', '1', '0', '1', '0'},
          {'1', '1', '0', '0', '0'},
          {'0', '0', '0', '0', '0'}
        };

    int numIslands = numIslands(grid);
    System.out.println("numIslands is:" + numIslands);

    grid =
        new char[][] {
          {'1', '1', '0', '0', '0'},
          {'1', '1', '0', '0', '0'},
          {'0', '0', '1', '0', '0'},
          {'0', '0', '0', '1', '1'}
        };
    numIslands = numIslands(grid);
    System.out.println("numIslands is:" + numIslands);
  }

  /**
   * 使用并查集
   *
   * @param grid
   * @return
   */
  public static int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    UnionFindOptimize uf = new UnionFindOptimize(grid);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          // 二维矩阵m*n,z在一维数组的位置是：（第几行×矩阵宽度）+ 在第几列
          // 前面已经执行过，不用往回查
          if (i + 1 < m && grid[i + 1][j] == '1') {
            uf.union(i * n + j, (i + 1) * n + j);
          }
          if (j + 1 < n && grid[i][j + 1] == '1') {
            uf.union(i * n + j, i * n + j + 1);
          }
        }
      }
    }
    return uf.count();
  }
}
