package com.algorithm.homework.medium;

/**
 * 200. 岛屿数量
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
 * <p>输入: [ ['1','1','1','1','0'], ['1','1','0','1','0'], ['1','1','0','0','0'],
 * ['0','0','0','0','0'] ] 输出: 1 示例 2:
 *
 * <p>输入: [ ['1','1','0','0','0'], ['1','1','0','0','0'], ['0','0','1','0','0'],
 * ['0','0','0','1','1'] ] 输出: 3 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 09:52<br>
 */
public class NumberOfIslands {
  public int numIslands(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          dfs(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  private void dfs(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
      return;
    }
    grid[i][j] = '0';
    dfs(grid, i + 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i - 1, j);
    dfs(grid, i, j - 1);
  }
}
