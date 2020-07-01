package com.algorithm.common;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/1 20:20<br>
 */
public class TreeData {
  public static BinaryTree init() {
    BinaryTree node0 = new BinaryTree(6);
    BinaryTree node1 = new BinaryTree(5);
    BinaryTree node2 = new BinaryTree(8);
    BinaryTree node3 = new BinaryTree(3);
    BinaryTree node4 = new BinaryTree(4);
    BinaryTree node5 = new BinaryTree(9);
    BinaryTree node6 = new BinaryTree(1);
    BinaryTree node7 = new BinaryTree(2);

    node0.left = node1;
    node0.right = node2;
    node1.left = node3;
    node1.right = node4;
    node2.right = node5;
    node3.left = node6;
    node3.right = node7;

    return node0;
  }
}
