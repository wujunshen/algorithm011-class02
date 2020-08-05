package com.algorithm.template;

import com.algorithm.common.BinaryTreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/13 08:47<br>
 */
public class DFS {
  public List<List<Integer>> levelOrder(BinaryTreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
      return allResults;
    }
    travel(root, 0, allResults);
    return allResults;
  }

  private void travel(BinaryTreeNode root, int level, List<List<Integer>> results) {
    if (results.size() == level) {
      results.add(new ArrayList<>());
    }
    results.get(level).add(root.val);
    if (root.left != null) {
      travel(root.left, level + 1, results);
    }
    if (root.right != null) {
      travel(root.right, level + 1, results);
    }
  }
}
