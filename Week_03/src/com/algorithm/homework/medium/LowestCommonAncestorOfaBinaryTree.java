package com.algorithm.homework.medium;

import com.algorithm.common.BinaryTree;

/**
 * 236. 二叉树的最近公共祖先
 *
 * <p>给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * <p>百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * <p>例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 输出: 3 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * <p>输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 输出: 5 解释: 节点 5 和节点 4 的最近公共祖先是节点
 * 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * <p>说明:
 *
 * <p>所有节点的值都是唯一的。 p、q 为不同节点且均存在于给定的二叉树中。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/7 17:09<br>
 */
public class LowestCommonAncestorOfaBinaryTree {

  public BinaryTree lowestCommonAncestor(BinaryTree root, BinaryTree p, BinaryTree q) {
    if (root == null || root == p || root == q) {
      return root;
    }
    BinaryTree leftCommonAncestor = lowestCommonAncestor(root.left, p, q);
    BinaryTree rightCommonAncestor = lowestCommonAncestor(root.right, p, q);
    // 在左子树中没有找到，那一定在右子树中
    if (leftCommonAncestor == null) {
      return rightCommonAncestor;
    }
    // 在右子树中没有找到，那一定在左子树中
    if (rightCommonAncestor == null) {
      return leftCommonAncestor;
    }
    // 不在左子树，也不在右子树，那说明是根节点
    return root;
  }
}
