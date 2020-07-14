package com.algorithm.class9;

import com.algorithm.common.BinaryTreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 *
 * <p>您需要在二叉树的每一行中找到最大的值。
 *
 * <p>示例：
 *
 * <p>输入:
 *
 * <p>1 / \ 3 2 / \ \ 5 3 9
 *
 * <p>输出: [1, 3, 9]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 09:44<br>
 */
public class FindLargestValueInEachTreeRow {
  public List<Integer> largestValues(BinaryTreeNode root) {
    List<Integer> result = new ArrayList<>();
    levelOrder(root, result, 0);
    return result;
  }

  /**
   * 当前root是第level层
   *
   * @param root
   * @param result
   * @param level
   */
  public void levelOrder(BinaryTreeNode root, List<Integer> result, int level) {
    if (root == null) {
      return;
    }

    if (level >= result.size()) {
      result.add(root.val);
    } else {
      result.set(level, Math.max(result.get(level), root.val));
    }
    levelOrder(root.left, result, level + 1);
    levelOrder(root.right, result, level + 1);
  }
}
