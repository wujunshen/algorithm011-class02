package com.algorithm.homework.medium;

import com.algorithm.common.BinaryTree;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 144. 二叉树的前序遍历
 *
 * <p>给定一个二叉树，返回它的 前序 遍历。
 *
 * <p> 示例:
 *
 * <p>输入: [1,null,2,3] 1 \ 2 / 3
 *
 * <p>输出: [1,2,3] 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/1 21:42<br>
 */
public class BinaryTreePreorderTraversal {
  /**
   * 迭代解法
   *
   * @param head
   */
  public static void preOrderIteration(BinaryTree head) {
    if (head == null) {
      return;
    }

    Deque<BinaryTree> stack = new ArrayDeque<>();
    stack.push(head);
    while (!stack.isEmpty()) {
      BinaryTree node = stack.pop();
      System.out.print(node.val + " ");
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }
    }
  }
}
