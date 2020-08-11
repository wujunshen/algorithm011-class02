package com.algorithm.class16;

import java.util.ArrayList;
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
  private static final List<List<String>> RESULT = new ArrayList<>();
  private static int lim;
  private static int[] isQueen;
  private static int n;

  /**
   * https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-wen-ti-wei-yun-suan-jie-fa-by-linkcc/
   *
   * @param nn
   * @return
   */
  public List<List<String>> solveNQueens(int nn) {
    n = nn;
    // 防止越界
    lim = (1 << n) - 1;
    isQueen = new int[n];
    test(0, 0, 0, 0);
    List<List<String>> r = new ArrayList<>(RESULT);
    RESULT.clear(); // 清空链表
    return r;
  }

  /**
   * @param row 为1的位表示已有皇后的列
   * @param left 当前行对应的列是受正斜线影响
   * @param right 当前行对应的列是受反斜线影响
   * @param k
   */
  private void test(int row, int left, int right, int k) {
    int pos, p;
    if (row != lim) {
      // 能放的位置
      pos = lim & ~(row | left | right);
      while (pos != 0) {
        // 找到最右边的可行位置
        p = pos & -pos;
        pos -= p;
        // 记录下当前选择的位置
        isQueen[k] = p;
        test(row + p, (left + p) << 1, (right + p) >> 1, k + 1);
      }
    } else { // 位置填满则记录下当前选择
      char[] c = new char[n];
      List<String> s = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int clo = isQueen[i];
        // 因为对称所以可以反序填
        for (int j = 0; j < n; j++, clo >>= 1) {
          if ((clo & 1) == 1) {
            c[j] = 'Q';
          } else {
            c[j] = '.';
          }
        }
        s.add(String.valueOf(c));
      }
      RESULT.add(s);
    }
  }
}
