package com.algorithm.class9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 *
 * <p>给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * <p>
 *
 * <p>示例： 二叉树：[3,9,20,null,null,15,7],
 *
 * <p>3 / \ 9 20 / \ 15 7 返回其层次遍历结果：
 *
 * <p>[ [3], [9,20], [15,7] ]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 09:00<br>
 */
public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> level = new LinkedList<>();
      for (int i = 0; i < size; ++i) {
        TreeNode cur = q.peek();
        q.poll();
        if (cur == null) {
          continue;
        }
        level.add(cur.val);
        q.offer(cur.left);
        q.offer(cur.right);
      }
      if (!level.isEmpty()) {
        result.add(level);
      }
    }
    return result;
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
