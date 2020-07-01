package com.algorithm.class6;

import com.algorithm.common.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 *
 * <p>给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * <p>例如，给定一个 3叉树 :
 *
 * <p>
 *
 * <p>
 *
 * <p>返回其层序遍历:
 *
 * <p>[ [1], [3,2,4], [5,6] ]
 *
 * <p>说明:
 *
 * <p>树的深度不会超过 1000。 树的节点总数不会超过 5000。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/1 22:28<br>
 */
public class NaryTreeLevelOrderTraversal {
  /**
   * 迭代解法
   *
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int count = queue.size();
      // 外层循环为一层
      List<Integer> list = new ArrayList<>();
      while (count-- > 0) {
        // 将当前元素的非空子节点压入栈
        TreeNode cur = queue.poll();
        list.add(cur.val);
        for (TreeNode node : cur.children) {
          if (node != null) {
            queue.add(node);
          }
        }
      }
      res.add(list);
    }
    return res;
  }
}
