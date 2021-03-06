package com.algorithm.class7;

import com.algorithm.common.BinaryTreeNode;

/**
 * 226. 翻转二叉树
 *
 * <p>翻转一棵二叉树。
 *
 * <p>示例：
 *
 * <p>输入：
 *
 * <p>4 / \ 2 7 / \ / \ 1 3 6 9 输出：
 *
 * <p>4 / \ 7 2 / \ / \ 9 6 3 1 备注: 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * <p>谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/7 16:42<br>
 */
public class InvertBinaryTree {
  public BinaryTreeNode invertTree(BinaryTreeNode root) {
    // 递归函数的终止条件，节点为空时返回
    if (root == null) {
      return null;
    }
    // 下面三句是将当前节点的左右子树交换
    BinaryTreeNode tmp = root.right;
    root.right = root.left;
    root.left = tmp;
    // 递归交换当前节点的 左子树
    invertTree(root.left);
    // 递归交换当前节点的 右子树
    invertTree(root.right);
    // 函数返回时就表示当前这个节点，以及它的左右子树
    // 都已经交换完了
    return root;
  }
}
