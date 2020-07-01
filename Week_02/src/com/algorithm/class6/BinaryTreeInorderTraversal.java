package com.algorithm.class6;

import com.algorithm.common.BinaryTree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * <p>给定一个二叉树，返回它的中序 遍历。
 *
 * <p>示例:
 *
 * <p>输入: [1,null,2,3] 1 \ 2 / 3
 *
 * <p>输出: [1,3,2] 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/1 21:29<br>
 */
public class BinaryTreeInorderTraversal {
  /**
   * 迭代解法
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal(BinaryTree root) {
    List<Integer> res = new ArrayList<>();
    Deque<BinaryTree> deque = new ArrayDeque<>();
    while (deque.size() > 0 || root != null) {
      // 不断往左子树方向走，每走一次就将当前节点保存到栈中
      // 这是模拟递归的调用
      if (root != null) {
        deque.add(root);
        root = root.left;
        // 当前节点为空，说明左边走到头了，从栈中弹出节点并保存
        // 然后转向右边节点，继续上面整个过程
      } else {
        BinaryTree tmp = deque.pop();
        res.add(tmp.val);
        root = tmp.right;
      }
    }
    return res;
  }
}
