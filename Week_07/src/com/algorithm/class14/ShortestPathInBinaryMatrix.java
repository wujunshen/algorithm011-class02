package com.algorithm.class14;

/**
 * 1091. 二进制矩阵中的最短路径
 *
 * <p>在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 *
 * <p>一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 *
 * <p>相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角） C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]） 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：[[0,1],[1,0]]
 *
 * <p>输出：2
 *
 * <p>示例 2：
 *
 * <p>输入：[[0,0,0],[1,1,0],[1,1,0]]
 *
 * <p>输出：4
 *
 * <p>
 *
 * <p>提示：
 *
 * <p>1 <= grid.length == grid[0].length <= 100 grid[i][j] 为 0 或 1
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/shortest-path-in-binary-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/7 02:00<br>
 */
public class ShortestPathInBinaryMatrix {}
