package com.algorithm.homework.hard;

/**
 * 52. N皇后 II
 *
 * <p>n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * <p>上图为 8 皇后问题的一种解法。
 *
 * <p>给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * <p>示例:
 *
 * <p>输入: 4 输出: 2 解释: 4 皇后问题存在如下两个不同的解法。 [  [".Q..",  // 解法 1   "...Q",   "Q...",   "..Q."],
 *
 * <p> ["..Q.",  // 解法 2   "Q...",   "...Q",   ".Q.."] ]
 *
 * <p>提示：
 *
 * <p>皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N-1 步，可进可退。（引用自
 * 百度百科 - 皇后 ） 通过次数29,180提交次数36,876
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/11 19:21<br>
 */
public class NqueensII {
  private static int size;
  private static int count;

  // https://leetcode-cn.com/problems/n-queens-ii/solution/hui-su-wei-yun-suan-by-yangxu-3/
  // 看这个加深理解
  /**
   * 使用三个整形分别标记每一层哪些格子可以放置皇后，这三个整形分别代表列、左斜下、右斜下（_col, ld, rd_），二进制位为 11 代表不能放置，00 代表可以放置
   *
   * @param row 列
   * @param ld 左斜下
   * @param rd 右斜下
   */
  private static void solve(int row, int ld, int rd) {
    if (row == size) {
      count++;
      return;
    }
    // 将所有能放置 Q 的位置由 0 变成 1，以便进行后续的位遍历
    int pos = size & (~(row | ld | rd));
    while (pos != 0) {
      // x & -x 代表除最后一位 1 保留，其它位全部为 0
      int p = pos & (-pos);
      // pos &= pos - 1; x & (x - 1) 代表将最后一位 1 变成 0
      pos -= p;

      solve(row | p, (ld | p) << 1, (rd | p) >> 1);
    }
  }

  public static int totalNQueens(int n) {
    count = 0;
    size = (1 << n) - 1;
    solve(0, 0, 0);
    return count;
  }

  public static void main(String[] args) {
    int result = totalNQueens(4);

    System.out.println("result: " + result);
  }
}
