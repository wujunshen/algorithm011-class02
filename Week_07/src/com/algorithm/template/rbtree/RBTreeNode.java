package com.algorithm.template.rbtree;

/**
 * 红黑树特点
 *
 * <p>1. 每节点要么是黑色，要么是红色
 *
 * <p>2. 根节点是黑色
 *
 * <p>3. 每个叶子节点（NIL）是黑色
 *
 * <p>4. 每个红色节点的两个子节点和父节点一定都是黑色（从每个叶子节点到根节点的所有路径上不能有两个连续的红色节点）
 *
 * <p>5. 任意一节点到每个叶子节点的路径都包含数量相同的黑色节点（黑高） 从5又可推理出
 *
 * <p>6. 如果一个节点存在黑色子节点，那么该节点肯定有两个子结点
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/8 17:28<br>
 */
public class RBTreeNode<T extends Comparable<T>> {
  /** 节点值 */
  private T value;
  /** 父节点指针 */
  private RBTreeNode<T> parent;
  /** 左子树指针 */
  private RBTreeNode<T> left;
  /** 右子树指针 */
  private RBTreeNode<T> right;
  /** 节点颜色是红还是黑（非红） */
  private boolean isRed;

  public RBTreeNode() {}

  public RBTreeNode(T value) {
    this.value = value;
  }

  public boolean isRed() {
    return isRed;
  }

  public void setRed(boolean red) {
    isRed = red;
  }

  boolean isBlack() {
    return !isRed;
  }

  void makeRed() {
    isRed = true;
  }

  void makeBlack() {
    isRed = false;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public RBTreeNode<T> getParent() {
    return parent;
  }

  public void setParent(RBTreeNode<T> parent) {
    this.parent = parent;
  }

  public RBTreeNode<T> getLeft() {
    return left;
  }

  public void setLeft(RBTreeNode<T> left) {
    this.left = left;
  }

  public RBTreeNode<T> getRight() {
    return right;
  }

  public void setRight(RBTreeNode<T> right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return value.toString();
  }
}
