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

