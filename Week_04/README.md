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

## 二分查找

### 概念

二分查找又叫作折半查找，要求待查找的序列**有序**，每次查找都取中间位置的值与待查值进行比较，如果中间位置的值比待查值大，则在序列的左半部分继续执行该查找过程，如果中间位置的值比待查值小，则在序列的右半部分继续执行该查找过程，直到查找到值为止，否则在序列中没有待查值

### 原理

在有序数组[3,4,6,20,40,45,51,62,70,99,110]中查找key=20的数据，根据二分查找，只需查找2次便能命中数据。这里需要强调的一点是，二分查找要求要查找的集合是有序的，如果不是有序集合，则先要通过排序算法排序后再进行查找

### 代码模板

```
public class BinarySearch {
  public static int binarySearch(int[] array, int a) {
    int low = 0;
    int high = array.length - 1;
    int mid;
    while (low < high) {
      // 中间位置
      mid = (low + high) / 2;
      if (array[mid] == a) {
        return mid;
      } else if (a > array[mid]) {
        // 向右查找
        low = mid + 1;
      } else {
        // 向左查找
        high = mid - 1;
      }
    }
    return -1;
  }
}
```
## 旋转数组二分查找

### 找规律

假设旋转数组是 [4, 5, 6, 7, 0, 1, 2]  把所有可能的旋转情况罗列出来

1. [0,1,2,4,5,6,7]
2. [1,2,4,5,6,7,0]
3. [2,4,5,6,7,0,1]
4. [4,5,6,7,0,1,2]
5. [5,6,7,0,1,2,4]
6. [6,7,0,1,2,4,5]
7. [7,0,1,2,4,5,6]

一共7种情况，以mid为界限，arr[m]<arr[r]情况下，也就是第1，5，6，7这4种都是都是右半部分单调递增
arr[m]>=arr[r]情况下，左半部分是单调递增的

也就是每次根据l和r求出m后，m左边[l, m-1]和右边[m+1, r]这两部分中至少一个部分是有序的

因此可以分成下列3种情况

1. arr[m]=X，返回m
2. arr[m]<arr[r]，位于m位置右侧是有序的；当arr[m]<X<arr[r]时，则l=m+1，否则r=m-1
3. arr[m]>=arr[r]，位于m位置左侧是有序的；当arr[l]<X<arr[m]时，则r=m-1，否则l=m+1

### 代码
```
public class BinarySearchRotateArray {

  public int search(int[] array, int length, int x) {
    int l = 0;
    int r = length - 1;
    int m;

    // 循环条件
    while (l <= r) {
      m = (l + r) / 2;
      // 找到了，终止
      if (array[m] == x) {
        return m;
      }
      // 右侧有序
      if (array[m] < array[r]) {
        if (array[m] < x && array[r] >= x) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      } else { // 左侧有序
        if (array[m] > x && array[l] <= x) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      }
    }
    return -1;
  }
}
```