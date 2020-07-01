package com.algorithm.class5;

import com.algorithm.common.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 *
 * <p>给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * <p>例如，给定一个 3叉树 :
 *
 * <p>
 *
 * <p>
 *
 * <p>返回其后序遍历: [5,6,3,2,4,1].
 *
 * <p>
 *
 * <p>说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/1 21:45<br>
 */
public class NaryTreePostOrderTraversal {
  /**
   * 迭代解法
   *
   * @param root
   * @return
   */
  public List<Integer> postOrder(TreeNode root) {
    LinkedList<TreeNode> treeLinkedList = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
      return output;
    }

    treeLinkedList.add(root);

    while (!treeLinkedList.isEmpty()) {
      TreeNode node = treeLinkedList.pollLast();
      output.addFirst(node.val);
      for (TreeNode item : node.children) {
        if (item != null) {
          treeLinkedList.add(item);
        }
      }
    }
    return output;
  }
}
