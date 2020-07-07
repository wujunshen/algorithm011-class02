package com.algorithm.class7;

import com.algorithm.common.BinaryTreeNode;

/**
 * 98. 验证二叉搜索树
 *
 * <p>给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * <p>假设一个二叉搜索树具有如下特征：
 *
 * <p>节点的左子树只包含小于当前节点的数。 节点的右子树只包含大于当前节点的数。 所有左子树和右子树自身必须也是二叉搜索树。 示例 1:
 *
 * <p>输入: 2 / \ 1 3 输出: true 示例 2:
 *
 * <p>输入: 5 / \ 1 4   / \   3 6 输出: false 解释: 输入为: [5,1,4,null,null,3,6]。   根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/7 17:05<br>
 */
public class ValidateBinarySearchTree {
  long pre = Long.MIN_VALUE;

  /**
   * 中序遍历时，判断当前节点是否大于中序遍历的前一个节点，如果大于，说明满足 BST，继续遍历；否则直接返回 false
   *
   * @param root
   * @return
   */
  public boolean isValidBST(BinaryTreeNode root) {
    if (root == null) {
      return true;
    }
    // 访问左子树
    if (!isValidBST(root.left)) {
      return false;
    }
    // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
    if (root.val <= pre) {
      return false;
    }
    pre = root.val;
    // 访问右子树
    return isValidBST(root.right);
  }
}
