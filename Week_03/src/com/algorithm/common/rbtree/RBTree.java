package com.algorithm.common.rbtree;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/9 15:48<br>
 */
public class RBTree<T extends Comparable<T>> {
  /** 根节点 */
  private final RBTreeNode<T> root;

  /** 红黑树的节点数 */
  private final AtomicLong size = new AtomicLong(0);

  public RBTree() {
    this.root = new RBTreeNode<>();
  }

  /**
   * 获取红黑树的节点数
   *
   * @return 节点数
   */
  public long getSize() {
    return size.get();
  }

  /**
   * 获取根节点
   *
   * @return 根节点
   */
  public RBTreeNode<T> getRoot() {
    return root.getLeft();
  }

  /**
   * 当前节点是否是根节点
   *
   * @param node 当前节点
   * @return true为根节点，false为非根节点
   */
  private boolean isRoot(RBTreeNode<T> node) {
    return root.getLeft() == node && node.getParent() == null;
  }

  /**
   * 当前节点颜色是否为黑
   *
   * @param node 当前节点
   * @return true为黑，false为红
   */
  private boolean isBlack(RBTreeNode<T> node) {
    return node == null || node.isBlack();
  }

  /**
   * 比较红黑树节点值大小
   *
   * @param parentNode 父节点
   * @param childNode 子节点
   * @return 0为相同，>0 子节点在父节点左子树 <0 子节点在父节点右子树
   */
  private int compareTo(RBTreeNode<T> parentNode, RBTreeNode<T> childNode) {
    return parentNode.getValue().compareTo(childNode.getValue());
  }

  /**
   * 获取父节点
   *
   * <p>找到应该成为当前节点父节点的节点而已，其实这个时候两个节点并没有父子关系
   *
   * @param node 当前节点
   * @return 父节点
   */
  private RBTreeNode<T> getParentNode(RBTreeNode<T> node) {
    RBTreeNode<T> rootNode = getRoot();
    RBTreeNode<T> parent = rootNode;

    while (parent != null) {
      int cmp = compareTo(parent, node);

      if (cmp == 0) {
        throw new IllegalStateException("不能重复添加相同元素");
      }

      rootNode = parent;
      if (cmp > 0) {
        parent = parent.getLeft();
      } else {
        parent = parent.getRight();
      }
    }
    return rootNode;
  }

  /**
   * 获取兄弟节点
   *
   * @param node 当前节点
   * @param parent 当前节点的父节点
   * @return 当前节点的兄弟节点
   */
  private RBTreeNode<T> getSiblingNode(RBTreeNode<T> node, RBTreeNode<T> parent) {
    parent = node == null ? parent : node.getParent();
    if (node == null) {
      return parent.getLeft() == null ? parent.getRight() : parent.getLeft();
    }
    if (node == parent.getLeft()) {
      return parent.getRight();
    } else {
      return parent.getLeft();
    }
  }

  /**
   * 获取当前节点的叔叔节点(父节点的兄弟节点)
   *
   * @param node 当前节点
   * @return 叔叔节点
   */
  private RBTreeNode<T> getUncleNode(RBTreeNode<T> node) {
    // 父节点
    RBTreeNode<T> parent = node.getParent();
    // 祖父节点
    RBTreeNode<T> grandFather = parent.getParent();
    if (grandFather == null) {
      return null;
    }
    if (parent == grandFather.getLeft()) {
      return grandFather.getRight();
    } else {
      return grandFather.getLeft();
    }
  }

  /**
   * 获取后继节点，即大于待删除节点的最小节点（大于待删除节点的都在右子树，因为红黑树本质是二叉搜索树，右子树值都大于父节点）
   *
   * @param node 待删除节点的右子节点
   * @return 后继节点
   */
  private RBTreeNode<T> getSuccessorNode(RBTreeNode<T> node) {
    RBTreeNode<T> parent = node;
    // 循环往复，把最小节点赋给node节点
    while (node != null && node.getLeft() != null) {
      parent = node;
      // 红黑树本质是二叉搜索树，左节点都小于父节点
      node = node.getLeft();
    }
    // 找到最小节点，直接返回
    if (parent == node) {
      return node;
    }

    parent.setLeft(node.getRight());
    setParent(node.getRight(), parent);

    return node;
  }

  /**
   * 设置父节点
   *
   * @param node 子节点
   * @param parent 父节点
   */
  private void setParent(RBTreeNode<T> node, RBTreeNode<T> parent) {
    if (node != null) {
      node.setParent(parent);
      if (parent == root) {
        node.setParent(null);
      }
    }
  }

  /**
   * 左旋
   *
   * <p>以某个节点作为旋转节点，其右节点变为旋转节点的父节点，右节点的左节点变为旋转节点的右节点，左节点保持不变
   *
   * @param node 旋转节点
   */
  private void leftRotate(RBTreeNode<T> node) {
    RBTreeNode<T> right = node.getRight();
    // 右节点为空说明没有节点做旋转节点的父节点，则无法左旋
    if (right == null) {
      throw new IllegalStateException("右节点为空");
    }
    RBTreeNode<T> parent = node.getParent();
    // 右节点的左节点变为旋转节点的右节点
    node.setRight(right.getLeft());
    setParent(right.getLeft(), node);

    // 右节点变为旋转节点的父节点
    right.setLeft(node);
    setParent(node, right);

    // 旋转节点为根节点
    if (parent == null) {
      // 右节点变为根节点
      root.setLeft(right);
      // 右节点作为根节点的新子树
      setParent(right, null);
    } else {
      // 旋转节点不管在左右子树哪边，现在它的位置都被它原来的右节点代替
      if (parent.getLeft() == node) {
        parent.setLeft(right);
      } else {
        parent.setRight(right);
      }
      // 右节点作为新子树
      setParent(right, parent);
    }
  }

  /**
   * 右旋
   *
   * <p>以某个节点作为旋转节点，其左节点变为旋转节点的父节点，左节点的右节点变为旋转节点的左节点，右节点保持不变
   *
   * @param node 旋转节点
   */
  private void rightRotate(RBTreeNode<T> node) {
    RBTreeNode<T> left = node.getLeft();
    // 左节点为空说明没有节点做旋转节点的父节点，则无法右旋
    if (left == null) {
      throw new IllegalStateException("左节点为空");
    }
    RBTreeNode<T> parent = node.getParent();
    // 左节点的右节点变为旋转节点的左节点
    node.setLeft(left.getRight());
    setParent(left.getRight(), node);

    // 左节点变为旋转节点的父节点
    left.setRight(node);
    setParent(node, left);

    // 旋转节点为根节点
    if (parent == null) {
      // 左节点变为根节点
      root.setLeft(left);
      // 左节点作为根节点的新子树
      setParent(left, null);
    } else {
      // 旋转节点不管在左右子树哪边，现在它的位置都被它原来的左节点代替
      if (parent.getLeft() == node) {
        parent.setLeft(left);
      } else {
        parent.setRight(left);
      }
      // 左节点作为新子树
      setParent(left, parent);
    }
  }

  /**
   * 搜索指定节点的红黑树节点，如果找不到则返回null
   *
   * @param node 指定节点
   * @return 指定节点的红黑树节点
   */
  public RBTreeNode<T> find(RBTreeNode<T> node) {
    RBTreeNode<T> rootNode = getRoot();
    while (rootNode != null) {
      int cmp = compareTo(rootNode, node);
      if (cmp < 0) {
        rootNode = rootNode.getRight();
      } else if (cmp > 0) {
        rootNode = rootNode.getLeft();
      } else {
        return rootNode;
      }
    }
    return null;
  }

  /**
   * 红黑树插入元素操作
   *
   * <p>有几种情况
   *
   * <p>1. 新节点就是根节点: 直接让新节点变色为黑色(红黑树特点2)
   *
   * <p>2. 新节点的父节点为黑色: 新插入的红色节点并没有打破红黑树的特点5限制，黑高不变，所以不需做任何操作
   *
   * <p>3. 新节点的父节点和以及叔叔节点都为红色: 父节点和叔叔节点变黑，它们的父节点也就是祖父节点变红
   *
   * <p>4. 新节点的父结点为红色，叔叔节点为黑色或没有叔叔节点，且新节点是父节点的右子树，父节点是祖父节点的左子树:
   * 以父节点为旋转节点，左旋。使新节点变为其原来父节点的新父节点，这样就变成马上要说的情况5
   *
   * <p>5. 新节点的父结点为红色，叔叔节点为黑色或没有叔叔节点，且新结点是父节点的左子树，父节点是祖父节点的左子树:
   * 以祖父节点为旋转节点,右旋。使父节点变为其原来父节点（祖父节点）的新父节点，父节点变黑，原祖父节点变红
   *
   * <p>6. 新节点的父结点为红色，叔叔节点为黑色或没有叔叔节点，且新节点是父节点的右子树，父节点是祖父节点的右子树:
   * 以祖父节点为旋转节点,左旋。使父节点变为其原来父节点（祖父节点）的新父节点，父节点变黑，原祖父节点变红
   *
   * <p>7. 新节点的父结点为红色，叔叔节点为黑色或没有叔叔节点，且新结点是父节点的左子树，父节点是祖父节点的右子树:
   * 以父节点为旋转节点，右旋。使新节点变为其原来父节点的新父节点，这样就变成情况6
   *
   * @param node 要插入的元素节点
   */
  public void addNode(RBTreeNode<T> node) {
    node.setLeft(null);
    node.setRight(null);
    // 插入元素节点都为红色
    node.makeRed();
    setParent(node, null);
    if (getRoot() == null) {
      // 情况1
      root.setLeft(node);
      // 红黑树特性，根节点肯定为黑
      node.makeBlack();
    } else {
      // 寻找父节点
      RBTreeNode<T> parentNode = getParentNode(node);
      int cmp = compareTo(parentNode, node);

      if (cmp == 0) {
        throw new IllegalStateException("不能重复添加相同元素");
      }

      // 情况2，不做任何旋转和变色操作
      // 设定父子节点关系
      setParent(node, parentNode);
      if (cmp > 0) {
        parentNode.setLeft(node);
      } else {
        parentNode.setRight(node);
      }

      // 插入元素操作情况3-7
      doInsert(node);
    }

    // 节点个数+1
    size.incrementAndGet();
  }

  /**
   * 插入操作修整，插入元素操作情况3-7
   *
   * <p>3. 新节点的父节点和以及叔叔节点都为红色: 父节点和叔叔节点变黑，它们的父节点也就是祖父节点变红
   *
   * <p>4. 新节点的父结点为红色，叔叔节点为黑色或没有叔叔节点，且新节点是父节点的右子树，父节点是祖父节点的左子树:
   * 以父节点为旋转节点，左旋。使新节点变为其原来父节点的新父节点，这样就变成马上要说的情况5
   *
   * <p>5. 新节点的父结点为红色，叔叔节点为黑色或没有叔叔节点，且新结点是父节点的左子树，父节点是祖父节点的左子树:
   * 以祖父节点为旋转节点,右旋。使父节点变为其原来父节点（祖父节点）的新父节点，父节点变黑，原祖父节点变红
   *
   * <p>6. 新节点的父结点为红色，叔叔节点为黑色或没有叔叔节点，且新节点是父节点的右子树，父节点是祖父节点的右子树:
   * 以祖父节点为旋转节点,左旋。使父节点变为其原来父节点（祖父节点）的新父节点，父节点变黑，原祖父节点变红
   *
   * <p>7. 新节点的父结点为红色，叔叔节点为黑色或没有叔叔节点，且新结点是父节点的左子树，父节点是祖父节点的右子树:
   * 以父节点为旋转节点，右旋。使新节点变为其原来父节点的新父节点，这样就变成情况6
   *
   * @param node 当前节点，即插入的新节点
   */
  private void doInsert(RBTreeNode<T> node) {
    // 父节点
    RBTreeNode<T> parent = node.getParent();

    // 新节点的父结点为红色
    while (parent != null && parent.isRed()) {
      // 叔叔节点
      RBTreeNode<T> uncle = getUncleNode(node);

      // 叔叔节点为黑色或没有叔叔节点
      if (uncle == null) {
        // 祖父节点
        RBTreeNode<T> grandFather = parent.getParent();
        // 祖父节点不为空，是因为插入操作之前，红黑树是平衡的
        // 父节点是祖父节点的左子树
        if (parent == grandFather.getLeft()) {
          boolean isRight = node == parent.getRight();
          // 新节点是父节点的右子树
          if (isRight) {
            // 情况4，以父节点为旋转节点，左旋。使新节点变为其原来父节点的新父节点，这样就变成情况5
            leftRotate(parent);
          }

          // 以祖父节点为旋转节点,右旋。使父节点变为其原来父节点（祖父节点）的新父节点
          rightRotate(grandFather);

          if (isRight) {
            // 新节点变黑，跳出循环
            node.makeBlack();
            parent = null;
          } else {
            // 情况5，父节点变黑
            parent.makeBlack();
          }
          // 原祖父节点变红
          grandFather.makeRed();
        } else {
          boolean isLeft = node == parent.getLeft();
          // 新结点是父节点的左子树
          if (isLeft) {
            // 情况7 以父节点为旋转节点，右旋。使新节点变为其原来父节点的新父节点，这样就变成情况6
            rightRotate(parent);
          }
          // 情况6 以祖父节点为旋转节点,左旋。使父节点变为其原来父节点（祖父节点）的新父节点
          leftRotate(grandFather);

          if (isLeft) {
            // 新节点变黑，跳出循环
            node.makeBlack();
            parent = null;
          } else {
            // 父节点变黑
            parent.makeBlack();
          }
          // 原祖父节点变红
          grandFather.makeRed();
        }
      } else {
        // 情况3 新节点的父节点和以及叔叔节点都为红色
        // 父节点和叔叔节点变黑，它们的父节点也就是祖父节点变红
        parent.makeBlack();
        uncle.makeBlack();
        parent.getParent().makeRed();
        node = parent.getParent();
        parent = node.getParent();
      }
    }
    // 设置根节点
    getRoot().makeBlack();
    getRoot().setParent(null);
  }

  /**
   * 删除节点，如果树中不存在该值，则返回null
   *
   * @param node 待删除节点
   * @return 有该待删除的给定值的节点
   */
  public T remove(RBTreeNode<T> node) {
    RBTreeNode<T> removeNode = getRoot();
    RBTreeNode<T> parent = root;

    while (removeNode != null) {
      int cmp = compareTo(removeNode, node);
      if (cmp < 0) {
        parent = removeNode;
        removeNode = removeNode.getRight();
      } else if (cmp > 0) {
        parent = removeNode;
        removeNode = removeNode.getLeft();
      } else {
        if (removeNode.getRight() != null) {
          // 获取后续节点，准备和待删除节点替换
          RBTreeNode<T> successorNode = getSuccessorNode(removeNode.getRight());
          boolean isParent = successorNode.getRight() == null;

          successorNode.setLeft(removeNode.getLeft());
          setParent(removeNode.getLeft(), successorNode);
          if (parent.getLeft() == removeNode) {
            parent.setLeft(successorNode);
          } else {
            parent.setRight(successorNode);
          }
          setParent(successorNode, parent);

          boolean successorNodeIsBlack = successorNode.isBlack();
          // 后继节点颜色变为待删除节点颜色
          successorNode.setRed(removeNode.isRed());

          if (successorNode != removeNode.getRight()) {
            successorNode.setRight(removeNode.getRight());
            setParent(removeNode.getRight(), successorNode);
          }
          // 去掉一个黑色节点，需要变色
          if (successorNodeIsBlack) {
            if (successorNode != removeNode.getRight()) {
              // 用来变色，维持红黑树平衡
              doRemove(
                  successorNode.getRight() == null
                      ? successorNode.getParent()
                      : successorNode.getRight(),
                  isParent);
            } else if (successorNode.getRight() != null) {
              doRemove(successorNode.getRight(), false);
            } else {
              doRemove(successorNode, true);
            }
          }
        } else {
          setParent(removeNode.getLeft(), parent);
          if (parent.getLeft() == removeNode) {
            parent.setLeft(removeNode.getLeft());
          } else {
            parent.setRight(removeNode.getLeft());
          }
          // 待删除节点颜色为黑且树不为空
          if (removeNode.isBlack() && getRoot() != null) {
            boolean isParent = removeNode.getLeft() == null;
            doRemove(removeNode.getLeft() == null ? parent : removeNode.getLeft(), isParent);
          }
        }

        // 删除待删除节点
        setParent(removeNode, null);
        removeNode.setLeft(null);
        removeNode.setRight(null);

        // 设置根节点
        if (getRoot() != null) {
          getRoot().makeBlack();
          getRoot().setParent(null);
        }

        // 节点个数-1
        size.decrementAndGet();
        return removeNode.getValue();
      }
    }
    return null;
  }

  /**
   * 删除元素操作修整
   *
   * <p>情况1: 替换节点为红色
   *
   * <p>情况2: 替换节点为黑色
   *
   * <p>2.1 替换节点为左子树，替换节点的兄弟节点为红色
   *
   * <p>2.2 替换节点为左子树，替换节点的兄弟节点为黑色，替换节点的兄弟节点的右子节点为红色，左子节点任意颜色(左+右为黑+红、红+红）
   *
   * <p>2.3 替换节点为左子树，替换节点的兄弟节点为黑色，替换节点的兄弟节点的右子节点为黑色，左子节点为红色(左+右为红+黑）
   *
   * <p>2.4 替换节点为左子树，替换节点的兄弟节点为黑色，替换节点的兄弟节点的子节点都为黑色(左+右为黑+黑）
   *
   * <p>2.5 替换节点是右子树，替换节点的兄弟节点为红色
   *
   * <p>2.6 替换节点是右子树，替换节点的兄弟节点为黑色，替换节点的兄弟节点的左子节点为红色，右子节点任意颜色(左+右为红+黑、红+红）
   *
   * <p>2.7 替换节点是右子树，替换节点的兄弟节点为黑色，替换节点的兄弟节点的左子节点为黑色，右子节点为红色(左+右为黑+红）
   *
   * <p>2.8 替换节点是右子树，替换节点的兄弟节点为黑色，替换节点的兄弟节点的子节点都为黑色(左+右为黑+黑）
   *
   * @param node 待删除节点
   * @param isParent 待删除节点是否是父节点，即是否有子节点
   */
  private void doRemove(RBTreeNode<T> node, boolean isParent) {
    RBTreeNode<T> replaceNode = isParent ? null : node;
    boolean isRed = !isParent && node.isRed();
    RBTreeNode<T> parent = isParent ? node : node.getParent();

    while (!isRed && !isRoot(replaceNode)) {
      // 获取兄弟节点
      RBTreeNode<T> sibling = getSiblingNode(replaceNode, parent);
      // 兄弟节点不为空，是因为删除元素之前，红黑树是平衡的，替换节点颜色为黑，黑高永远不变，则必然有兄弟节点

      // 替换节点是否是在左子树
      boolean isLeft = parent.getRight() == sibling;

      if (isLeft && sibling.isRed()) {
        // 2.1 替换节点为左子树，替换节点的兄弟节点为红色
        // 将兄弟节点变黑，父节点变红
        sibling.makeBlack();
        parent.makeRed();
        // 对父节点进行左旋
        leftRotate(parent);
      } else if (isLeft && !isBlack(sibling.getRight())) {
        // 2.2 替换节点是左子树，替换节点的兄弟节点的右子节点为红色，左子节点任意颜色(左+右为黑+红、红+红）
        // 将兄弟节点的颜色变为父节点的颜色，将父节点变黑，将兄弟节点的右子节点变黑
        sibling.setRed(parent.isRed());
        parent.makeBlack();
        sibling.getRight().makeBlack();
        // 对父节点左旋
        leftRotate(parent);
        replaceNode = getRoot();
      } else if (isLeft && !isBlack(sibling.getLeft()) && isBlack(sibling.getRight())) {
        // 2.3 替换节点是左子树，替换节点的兄弟节点的右子节点为黑色，左子节点为红色(左+右为红+黑）
        // 将兄弟节点变红，将兄弟节点的左子节点变黑
        sibling.makeRed();
        sibling.getLeft().makeBlack();
        // 对兄弟节点进行右旋
        rightRotate(sibling);
      } else if (isBlack(sibling.getLeft()) && isBlack(sibling.getRight())) {
        // 2.4&2.8 不管替换节点是左还是右子树，替换节点的兄弟节点的子节点都为黑色(左+右为黑+黑）
        // 兄弟节点变为红色
        sibling.makeRed();
        // 再让父节点成为新的替换节点
        replaceNode = parent;
        isRed = replaceNode.isRed();
        parent = parent.getParent();
      } else if (!isLeft && sibling.isRed()) {
        // 2.5 替换节点是右子树，替换节点的兄弟节点为红色
        // 将兄弟节点变黑，将父节点变红
        sibling.makeBlack();
        parent.makeRed();
        // 对父节点进行右旋
        rightRotate(parent);
      } else if (!isLeft && !isBlack(sibling.getLeft())) {
        // 2.6 替换节点是右子树，替换节点的兄弟节点的左子节点为红色，右子节点任意颜色(左+右为红+黑、红+红）
        // 将兄弟节点的颜色变为父节点的颜色，将父节点变黑，将兄弟节点的左子节点变黑
        sibling.setRed(parent.isRed());
        parent.makeBlack();
        sibling.getLeft().makeBlack();
        // 对父节点右旋
        rightRotate(parent);
        replaceNode = getRoot();
      } else if (!isLeft && isBlack(sibling.getLeft()) && !isBlack(sibling.getRight())) {
        // 2.7 替换节点是右子树，替换节点的兄弟节点的左子节点为黑色，右子节点为红色(左+右为黑+红）
        // 将兄弟节点变红，将兄弟节点的右子节点变黑，
        sibling.makeRed();
        sibling.getRight().makeBlack();
        // 对兄弟节点进行左旋
        leftRotate(sibling);
      }
    }
    // 情况1: 替换节点为红色
    if (isRed) {
      // 替换节点颜色变为删除节点颜色
      replaceNode.makeBlack();
    }
    // 设置根节点
    if (getRoot() != null) {
      getRoot().makeBlack();
      getRoot().setParent(null);
    }
  }
}
