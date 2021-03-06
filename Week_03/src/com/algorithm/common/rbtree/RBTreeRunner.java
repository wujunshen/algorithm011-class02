package com.algorithm.common.rbtree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/10 01:33<br>
 */
public class RBTreeRunner {
  public static void main(String[] args) {
    RBTree<String> bst = new RBTree<>();

    bst.addNode(new RBTreeNode<>("d"));
    bst.addNode(new RBTreeNode<>("c"));
    bst.addNode(new RBTreeNode<>("b"));
    bst.addNode(new RBTreeNode<>("f"));
    bst.addNode(new RBTreeNode<>("a"));
    bst.addNode(new RBTreeNode<>("e"));
    bst.addNode(new RBTreeNode<>("g"));
    bst.addNode(new RBTreeNode<>("h"));

    System.out.println("\n====================================================================");
    printTree(bst.getRoot());
    System.out.println("\n一共" + bst.getSize() + "个节点");
    // c(黑;;)
    // b(黑;c;左)	e(红;c;右)
    // a(红;b;左)	d(黑;e;左)	g(黑;e;右)
    // f(红;g;左)	h(红;g;右)

    System.out.println("\n====================================================================");
    bst.remove(new RBTreeNode<>("c"));

    printTree(bst.getRoot());
    System.out.println("\n一共" + bst.getSize() + "个节点");
    // d(黑;;)
    // b(黑;d;左)	g(红;d;右)
    // a(红;b;左)	e(黑;g;左)	h(黑;g;右)
    // f(红;e;右)

    System.out.println("\n====================================================================");
    RBTreeNode<String> node = bst.find(new RBTreeNode<>("c"));
    if (node != null) {
      System.out.println("节点值: " + node.getValue() + ",节点颜色: " + (node.isBlack() ? "黑" : "红"));
    } else {
      System.out.println("Nil节点");
    }

    System.out.println("\n====================================================================");
    node = bst.find(new RBTreeNode<>("f"));
    System.out.println("节点值: " + node.getValue() + ",节点颜色: " + (node.isBlack() ? "黑" : "红"));
  }

  /**
   * 打印红黑树，树中每层都在一行显示
   *
   * @param root 根节点
   */
  private static void printTree(RBTreeNode<String> root) {
    Queue<RBTreeNode<String>> queue = new LinkedList<>();
    Queue<RBTreeNode<String>> queue2 = new LinkedList<>();
    if (root == null) {
      return;
    }
    queue.add(root);
    boolean firstQueue = true;

    while (!queue.isEmpty() || !queue2.isEmpty()) {
      Queue<RBTreeNode<String>> q = firstQueue ? queue : queue2;
      RBTreeNode<String> node = q.poll();

      if (node != null) {
        RBTreeNode<String> parentNode = node.getParent();
        String position = parentNode == null ? "" : node == parentNode.getLeft() ? "左" : "右";
        String parentNodeStr = parentNode == null ? "" : parentNode.toString();
        String color = node.isRed() ? "红" : "黑";
        System.out.print(node + "(" + color + ";" + parentNodeStr + ";" + position + ")\t");
        if (node.getLeft() != null) {
          (firstQueue ? queue2 : queue).add(node.getLeft());
        }
        if (node.getRight() != null) {
          (firstQueue ? queue2 : queue).add(node.getRight());
        }
      } else {
        System.out.println();
        firstQueue = !firstQueue;
      }
    }
  }
}
