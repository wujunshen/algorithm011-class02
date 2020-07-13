# 学习笔记

## 广度优先遍历

### 概念

广度优先遍历(Breadth First Search),又叫宽度优先遍历或横向优先遍历，是从根结点开始沿着树的宽度搜索遍历

### 代码模板

```
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
```

## 深度优先遍历

### 概念

深度优先搜索(Depth First Search)是沿着树的深度遍历树的节点，尽可能深的搜索树的分支

### 代码模板

```
public class DFS {
      // 递归模板
      boolean DFS(Node cur, Node target, Set<Node> visited) {
          return true if cur is target;
          for (next : each neighbor of cur) {
              if (next is not in visited) {
                  add next to visted;
                  return true if DFS(next, target, visited) == true;
              }
          }
          return false;
      }
}
```

## 贪心

### 概念

是一种在每步选择中都采取当前状态下最好或最优(最有利)选择，从而希望结果是全局最好或最优的算法

#### 和动态规划的不同

不同点在于贪心对每个子问题的解决方法都作出选择，不能回退。动态规划则会保存以前的运算结果，并根据之前结果对当前进行选择，有回退功能

### 形成条件

问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解。这种子问题最优解被称为最优子结构

### 使用场景

解决最优化问题，比如: 哈夫曼编码

一旦一个问题可以通过贪心算法来解决，那么它可能是解决这个问题的最佳方案。因为其高效性和求得答案比较接近最优结果，贪心算法可以当做辅助算法或直接解决一些要求结果不特别精确的问题
