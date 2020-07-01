package com.algorithm.class6;

import com.algorithm.common.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 *
 * <p>给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * <p>例如，给定一个 3叉树 :
 *
 * <p>
 *
 * <p>
 *
 * <p>返回其前序遍历: [1,3,5,6,2,4]。
 *
 * <p>
 *
 * <p>说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/1 22:15<br>
 */
public class NaryTreePreOrderTraversal {
  /**
   * 递归
   *
   * @param root
   * @return
   */
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }
    result.add(root.val);
    for (TreeNode treeNode : root.children) {
      result.addAll(preOrder(treeNode));
    }
    return result;
  }

  /**
   * 迭代解法
   *
   * @param root
   * @return
   */
  public List<Integer> preorder2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> arrayDeque = new ArrayDeque<>();
    arrayDeque.push(root);
    while (!arrayDeque.isEmpty()) {
      TreeNode cur = arrayDeque.pop();
      // 头结点加入结果集
      result.add(cur.val);
      // 将该节点的子节点从右往左压入栈
      List<TreeNode> nodeList = cur.children;
      for (int i = nodeList.size() - 1; i >= 0; i--) {
        arrayDeque.push(nodeList.get(i));
      }
    }
    return result;
  }
}
