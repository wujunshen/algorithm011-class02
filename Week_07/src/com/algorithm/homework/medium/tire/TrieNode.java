package com.algorithm.homework.medium.tire;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/4 10:28<br>
 */
public class TrieNode {
  /** 记录孩子节点 */
  private TrieNode[] child;
  /** 记录当前节点是不是一个单词的结束字母 */
  private boolean isEnd;

  public TrieNode() {
    // 子节点数组长度26，0：‘a’，1：‘b’.....
    this.child = new TrieNode[26];
    this.isEnd = false;
  }

  public TrieNode[] getChild() {
    return child;
  }

  public void setChild(TrieNode[] child) {
    this.child = child;
  }

  public boolean isEnd() {
    return isEnd;
  }

  public void setEnd(boolean end) {
    isEnd = end;
  }
}
