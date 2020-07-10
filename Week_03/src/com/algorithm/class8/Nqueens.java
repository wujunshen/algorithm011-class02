package com.algorithm.class8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N皇后
 *
 * <p>n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * <p>上图为 8 皇后问题的一种解法。
 *
 * <p>给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * <p>每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * <p>示例:
 *
 * <p>输入: 4 输出: [ [".Q..", // 解法 1 "...Q", "Q...", "..Q."],
 *
 * <p>["..Q.", // 解法 2 "Q...", "...Q", ".Q.."] ] 解释: 4 皇后问题存在两个不同的解法。
 *
 * <p>提示：
 *
 * <p>皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。（引用自 百度百科 -
 * 皇后 ）
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/7 17:46<br>
 */
public class Nqueens {
  // 定义列和主副对角线
  private boolean[] col;
  private boolean[] dia1;
  private boolean[] dia2;
  private final List<List<String>> result = new ArrayList<>();

  public List<List<String>> solveNQueens(int n) {
    col = new boolean[n];
    // 对角线个数为 2 * n - 1
    dia1 = new boolean[2 * n - 1];
    dia2 = new boolean[2 * n - 1];

    // 定义每行的元素个数
    List<Integer> row = new LinkedList<>();
    // 回溯寻找符合要求的每组解
    putQueen(n, 0, row);
    return result;
  }

  /**
   * @param n 皇后个数
   * @param index 代表当前访问的行数
   * @param row 用来存放满足题意的一种情况
   */
  private void putQueen(int n, int index, List<Integer> row) {
    // 如果遍历到了最后一行，即代表已经找出一组解出来
    if (index == n) {
      // 将找到的一组解转化为棋盘格的形式后再放入 ans
      result.add(changeBoard(n, row));
      return;
    }
    // 遍历当前 index 行的所有位置(从前往后依次遍历)
    for (int i = 0; i < n; i++) {
      // index + i 表示横纵坐标相加
      // index - i + n - 1 表示横纵坐标之差
      // 如果当前位置元素与他同一列，同一主副对角线上没有重复元素
      if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
        // 则该位置即皇后放置的位置，放入 row 存储位置信息，并标记为 true
        row.add(i);
        // 此时在该元素所在的列和主副对角线上就不能在遍历找到其他元素了
        // 即标记为 true
        col[i] = true;
        dia1[index + i] = true;
        dia2[index - i + n - 1] = true;

        // 接着递归寻找下一行
        putQueen(n, index + 1, row);

        // 遍历完后再退出标记
        col[i] = false;
        dia1[index + i] = false;
        dia2[index - i + n - 1] = false;
        // 回退上一格子(回溯)
        row.remove(row.size() - 1);
      }
    }
  }

  /**
   * 将找到的一组解转化为棋盘格形式存储
   *
   * @param n
   * @param row
   * @return
   */
  private List<String> changeBoard(int n, List<Integer> row) {
    List<String> tmp = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      char[] ch = new char[n];
      // 初始化 ch 中所有位置元素为 ‘.’
      Arrays.fill(ch, '.');
      // 将 row 中已经确定下来的 Queen 位置改为 ‘Q’
      ch[row.get(i)] = 'Q';
      // 然后放入 tmp 中
      tmp.add(new String(ch));
    }
    return tmp;
  }
}
