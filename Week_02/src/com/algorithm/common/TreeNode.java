package com.algorithm.common;

import java.util.List;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/7/1 22:13<br>
 */
public class TreeNode {
  public int val;
  public List<TreeNode> children;

  public TreeNode() {}

  public TreeNode(int val, List<TreeNode> children) {
    this.val = val;
    this.children = children;
  }
}
