package com.algorithm.template;

import com.algorithm.common.BinaryTreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/12 21:49<br>
 */
public class BFS {
  /**
   * 计算从起点 start 到终点 target 的最近距离
   *
   * @param start 起始节点
   * @param target 终止节点
   * @return 步数
   */
  public int bfs(BinaryTreeNode start, BinaryTreeNode target) {
    // 核心数据结构
    Queue<BinaryTreeNode> q = new LinkedList<>();
    // 避免走回头路
    Set<BinaryTreeNode> visited = new HashSet<>();
    // 相邻节点
    Queue<BinaryTreeNode> adj = new LinkedList<>();
    // 将起点加入队列
    q.offer(start);
    visited.add(start);
    // 记录扩散的步数
    int step = 0;

    while (!q.isEmpty()) {
      /* 将当前队列中的所有节点向四周扩散 */
      for (int i = 0; i < q.size(); i++) {
        BinaryTreeNode cur = q.poll();
        /* 划重点: 这里判断是否到达终点 */
        if (cur == target) {
          return step;
        }

        /* 将cur的相邻节点加入队列 */
        if (cur.left != null) {
          adj.offer(cur.left);
        }
        if (cur.right != null) {
          adj.offer(cur.right);
        }
        for (BinaryTreeNode x : adj) {
          if (!visited.contains(x)) {
            q.offer(x);
            visited.add(x);
          }
        }
      }
      /* 划重点: 更新步数在这里 */
      step++;
    }

    return step;
  }

  public List<List<Integer>> levelOrder(BinaryTreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
      return allResults;
    }
    Queue<BinaryTreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      int size = nodes.size();
      List<Integer> results = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        BinaryTreeNode node = nodes.poll();
        results.add(node.val);
        if (node.left != null) {
          nodes.add(node.left);
        }
        if (node.right != null) {
          nodes.add(node.right);
        }
      }
      allResults.add(results);
    }
    return allResults;
  }
}
