package com.algorithm.class13;

import com.algorithm.template.Trie;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II
 *
 * <p>给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * <p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * <p>示例:
 *
 * <p>输入: words = ["oath","pea","eat","rain"] and board = [ ['o','a','a','n'], ['e','t','a','e'],
 * ['i','h','k','r'], ['i','f','l','v'] ]
 *
 * <p>输出: ["eat","oath"] 说明: 你可以假设所有输入都由小写字母 a-z 组成。
 *
 * <p>提示:
 *
 * <p>你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
 * 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/4 11:46<br>
 */
public class WordSearchII {
  public static List<String> findWords(char[][] board, String[] words) {
    // 构建字典树
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }

    // 使用set防止重复
    Set<String> result = new HashSet<>();
    int m = board.length;
    int n = board[0].length;
    boolean[][] visited = new boolean[m][n];
    // 遍历整个二维数组
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        find(board, visited, i, j, m, n, result, trie);
      }
    }
    System.out.println(result);
    return new LinkedList<>(result);
  }

  private static void find(
      char[][] board,
      boolean[][] visited,
      int i,
      int j,
      int m,
      int n,
      Set<String> result,
      Trie cur) {
    // 边界以及是否已经访问判断
    if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
      return;
    }
    // 找下标
    int index = board[i][j] - 'a';

    cur = cur.getNext()[index];
    visited[i][j] = true;
    if (cur == null) {
      // 如果单词不匹配，回退
      visited[i][j] = false;
      return;
    }
    // 找到单词加入
    if (cur.isEnd()) {
      result.add(cur.getWord());
    }

    // 如果题目改成“相邻”单元格是那些水平相邻或垂直相邻，还有四个角相邻的单元格，就只需要把后面四行continue判断注释掉即可
    for (int k = i - 1; k <= i + 1; k++) {
      for (int h = j - 1; h <= j + 1; h++) {
        if (k == i && h == j) {
          continue;
        }
        if (k == i - 1 && h != j) {
          continue;
        }
        if (k == i + 1 && h != j) {
          continue;
        }
        if (k != i && h == j + 1) {
          continue;
        }
        if (k != i && h == j - 1) {
          continue;
        }
        find(board, visited, k, h, m, n, result, cur);
      }
    }
    // 最后要回退，因为下一个起点可能会用到上一个起点的字符
    visited[i][j] = false;
  }

  public static void main(String[] args) {
    String[] words = {"oath", "pea", "eat", "rain"};
    char[][] board = {
      {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
    };

    List<String> list = findWords(board, words);

    for (String element : list) {
      System.out.println("element:" + element);
    }
  }
}
