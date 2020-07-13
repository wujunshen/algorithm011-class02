package com.algorithm.template;

import java.util.HashSet;
import java.util.LinkedList;
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
  public int bfs(TreeNode start, TreeNode target) {
    // 核心数据结构
    Queue<TreeNode> q = new LinkedList<>();
    // 避免走回头路
    Set<TreeNode> visited = new HashSet<>();
    // 相邻节点
    Queue<TreeNode> adj = new LinkedList<>();
    // 将起点加入队列
    q.offer(start);
    visited.add(start);
    // 记录扩散的步数
    int step = 0;

    while (!q.isEmpty()) {
      /* 将当前队列中的所有节点向四周扩散 */
      for (int i = 0; i < q.size(); i++) {
        TreeNode cur = q.poll();
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
        for (TreeNode x : adj) {
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
}

class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }
}
