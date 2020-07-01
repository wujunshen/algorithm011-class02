package com.algorithm.example.tree;

import com.algorithm.common.BinaryTree;
import com.algorithm.common.TreeData;

/**
 * 前序遍历
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/1 20:17<br>
 */
public class PreOrderTree {
  public static void preOrder(BinaryTree root) {
    // 结束条件
    if (root == null) {
      return;
    }
    // 递归主体
    System.out.print(root.val + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public static void main(String[] args) {
    BinaryTree root = TreeData.init();
    preOrder(root);
  }
}
