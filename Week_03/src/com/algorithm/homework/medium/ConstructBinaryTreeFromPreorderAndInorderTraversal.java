package com.algorithm.homework.medium;

import com.algorithm.common.BinaryTree;
import java.util.Stack;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * <p>根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * <p>注意: 你可以假设树中没有重复的元素。
 *
 * <p>例如，给出
 *
 * <p>前序遍历 preorder = [3,9,20,15,7] 中序遍历 inorder = [9,3,15,20,7] 返回如下的二叉树：
 *
 * <p>3 / \ 9 20 / \ 15 7
 *
 * <p>来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/7 17:10<br>
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
  public BinaryTree buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || preorder.length == 0) {
      return null;
    }
    // 首先构建整棵树的根节点，也就是前序遍历表的第一个节点。
    BinaryTree root = new BinaryTree(preorder[0]);
    // 创建栈辅助构建树，初始化根节点入栈。
    Stack<BinaryTree> stack = new Stack<>();
    stack.push(root);
    // 定义 p、q 指针分别遍历前序遍历表和中序遍历表。
    int p = 1, q = 0;
    while (p < preorder.length) {
      // 从前序遍历表第二个节点开始遍历，记录当前遍历到的节点值。
      int preVal = preorder[p];
      // 得到栈顶节点。
      BinaryTree node = stack.peek();
      // 栈顶节点值等于中序遍历表遍历到的值，表示前序遍历表遍历的值为栈内某个节点的右节点。
      if (node.val == inorder[q]) {
        while (!stack.isEmpty() && stack.peek().val == inorder[q]) {
          // 栈顶节点出栈， q 指针移动继续遍历。
          node = stack.pop();
          q++;
        }
        // 前序遍历表遍历到的节点为最后一个出栈节点的右节点。
        node.right = new BinaryTree(preVal);
        // 将新节点入栈。
        stack.push(node.right);
      } else {
        // 栈顶节点值不等于中序遍历表遍历到的值，表示前序遍历表遍历到的值为栈顶节点的左节点。
        node.left = new BinaryTree(preVal);
        // 将新节点入栈。
        stack.push(node.left);
      }
      p++;
    }
    return root;
  }
}
