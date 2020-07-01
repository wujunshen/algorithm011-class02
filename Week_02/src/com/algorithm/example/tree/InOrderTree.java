package com.algorithm.example.tree;

import com.algorithm.common.BinaryTree;
import com.algorithm.common.TreeData;

/**
 * 中序遍历
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/1 20:18<br>
 */
public class InOrderTree {
  public static void inOrder(BinaryTree root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    System.out.print(root.val + " ");
    inOrder(root.right);
  }

  public static void main(String[] args) {
    BinaryTree root = TreeData.init();
    inOrder(root);
  }
}
