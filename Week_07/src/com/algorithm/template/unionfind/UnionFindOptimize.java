package com.algorithm.template.unionfind;

/**
 * https://leetcode-cn.com/problems/friend-circles/solution/union-find-suan-fa-xiang-jie-by-labuladong/
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/5 15:51<br>
 */
public class UnionFindOptimize {
  /** 连通分量个数 */
  private int count;
  /** 存储一棵树 */
  private int[] parent;
  /** 记录树的“重量” */
  private int[] size;

  public UnionFindOptimize(int n) {
    this.count = n;
    parent = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }

  public UnionFindOptimize(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    parent = new int[m * n];
    size = new int[m * n];
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (grid[i][j] == '1') {
          // 二维变一维
          parent[i * n + j] = i * n + j;
          size[i * n + j] = 1;
          count++;
        }
      }
    }
  }

  /**
   * 求合并集合，如果相等说明已在同一个集合，不相等则合并，且子节点小的集合连在子节点多的集合下，避免头重脚轻的树形结构
   *
   * @param p
   * @param q
   */
  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) {
      return;
    }

    // 小树接到大树下面，较平衡
    if (size[rootP] > size[rootQ]) {
      parent[rootQ] = rootP;
      size[rootP] += size[rootQ];
    } else {
      parent[rootP] = rootQ;
      size[rootQ] += size[rootP];
    }
    count--;
  }

  /**
   * 判断是否连通，就是求两个点是否是同一集合下
   *
   * @param p
   * @param q
   * @return
   */
  public boolean isConnected(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    return rootP == rootQ;
  }

  /**
   * 查找节点是否在集合中，并返回节点值
   *
   * <p>同时进行路径压缩，把时间复杂度从O(logN)压缩成O(1)
   *
   * @param x
   * @return
   */
  private int find(int x) {
    while (parent[x] != x) {
      // 进行路径压缩
      parent[x] = parent[parent[x]];
      x = parent[x];
    }
    return x;
  }

  /**
   * 获取连通分量个数
   *
   * @return
   */
  public int count() {
    return count;
  }
}
