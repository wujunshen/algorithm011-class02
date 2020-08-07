package com.algorithm.class14.astar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
  List<Point> queue = new LinkedList<>();
  Map<Integer, Point> hash = new HashMap<>();

  /**
   * https://leetcode-cn.com/problems/sudoku-solver/solution/javadi-gui-asou-suo-by-he-yun-fei/
   *
   * @param board
   */
  public void solveSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          Point point = new Point(i, j);
          queue.add(point);
          hash.put(i * 9 + j, point);
        }
      }
    }
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          remove(i, j, board[i][j]);
        }
      }
    }
    solve(board, queue.size());
  }

  private Point removeSingle(int i, int j, char c) {
    if (hash.containsKey(i * 9 + j) && hash.get(i * 9 + j).set.contains(c)) {
      Point point = hash.get(i * 9 + j);
      point.set.remove(c);
      return point;
    }
    return null;
  }

  private List<Point> remove(int i, int j, char c) {
    List<Point> result = new ArrayList<>();
    for (int k = 0; k < 9; k++) {
      Point point = removeSingle(i, k, c);
      if (point != null) {
        result.add(point);
      }
      point = removeSingle(k, j, c);
      if (point != null) {
        result.add(point);
      }
    }

    int x = i / 3 * 3;
    int y = j / 3 * 3;
    for (int k = 0; k < 3; k++) {
      for (int l = 0; l < 3; l++) {
        Point point = removeSingle(x + k, y + l, c);
        if (point != null) {
          result.add(point);
        }
      }
    }
    return result;
  }

  private boolean solve(char[][] board, int left) {
    if (left != 0) {
      Point point =
          queue.stream().filter(p -> !p.solved).min(Point::compareTo).orElse(new Point(-1, -1));
      point.solved = true;
      for (char c : new ArrayList<>(point.set)) {
        board[point.x][point.y] = c;
        List<Point> backup = remove(point.x, point.y, c);
        if (solve(board, left - 1)) {
          return true;
        }
        for (Point p : backup) {
          p.set.add(c);
        }
      }
      point.solved = false;
      return false;
    }

    return true;
  }
}

class Point implements Comparable<Point> {
  final int x;
  final int y;
  final Set<Character> set = new HashSet<>();
  boolean solved = false;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
    for (int i = 0; i < 9; i++) {
      set.add((char) ('1' + i));
    }
  }

  @Override
  public int compareTo(Point o) {
    int compare = Integer.compare(this.set.size(), o.set.size());
    return compare == 0 ? Integer.compare(x * 9 + y, o.x * 9 + o.y) : compare;
  }
}
