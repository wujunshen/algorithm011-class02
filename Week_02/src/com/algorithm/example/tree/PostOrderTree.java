package com.algorithm.example.tree;

import com.algorithm.common.BinaryTree;
import com.algorithm.common.TreeData;

/**
 * 后序遍历
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/1 20:19<br>
 */
public class PostOrderTree {
  public static void postOrder(BinaryTree root) {
    if (root == null) {
      return;
    }
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.val + " ");
  }

  public static void main(String[] args) {
    BinaryTree root = TreeData.init();
    postOrder(root);
  }
}
