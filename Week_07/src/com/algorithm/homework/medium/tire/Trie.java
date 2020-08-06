package com.algorithm.homework.medium.tire;

/**
 * 208. 实现 Trie (前缀树)
 *
 * <p>实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * <p>示例:
 *
 * <p>Trie trie = new Trie();
 *
 * <p>trie.insert("apple"); trie.search("apple"); // 返回 true trie.search("app"); // 返回 false
 * trie.startsWith("app"); // 返回 true trie.insert("app"); trie.search("app"); // 返回 true 说明:
 *
 * <p>你可以假设所有的输入都是由小写字母 a-z 构成的。 保证所有输入均为非空字符串。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/4 10:33<br>
 */
public class Trie {
  /** 记录前缀树的根 */
  private final TrieNode root;
  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  public static void main(String[] args) {
    Trie obj = new Trie();
    obj.insert("word");
    boolean isSearch = obj.search("word");
    boolean isStartWith = obj.startsWith("w");

    System.out.println("isSearch:" + isSearch + " isStartWith:" + isStartWith);

    isStartWith = obj.startsWith("wo");
    System.out.println("isStartWith:" + isStartWith);

    isStartWith = obj.startsWith("ow");
    System.out.println("isStartWith:" + isStartWith);
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    if (word == null || "".equals(word)) {
      return;
    }
    // 从根出发
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      // 对于每个字符
      char c = word.charAt(i);
      TrieNode[] nodes = node.getChild();
      // 如果c - 'a'为空，说明还没有存入
      TrieNode element = nodes[c - 'a'];
      if (element == null) {
        // 存入节点
        element = new TrieNode();
        nodes[c - 'a'] = element;
        node.setChild(nodes);
      }

      // 指向当前节点
      node = element;
    }
    // 最后的节点为单词的最后一个单词，isEnd设置为true
    node.setEnd(true);
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    if (word == null || "".equals(word)) {
      return false;
    }
    // 从根出发
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      // 对于每个字符
      char c = word.charAt(i);
      TrieNode[] nodes = node.getChild();
      // 如果c - 'a'为空，说明还没有存入
      TrieNode element = nodes[c - 'a'];
      // 如果不存在于前缀树中，返回false
      if (element == null) {
        return false;
      }
      node = element;
    }
    // 如果所有字符都在前缀树中，那么判断最后一个字母结束标志是否为true，
    // 为true，返回true，说明单词找到，否则，false，没找到
    return node.isEnd();
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    if (prefix == null || "".equals(prefix)) {
      return false;
    }
    // 从根出发
    TrieNode node = root;
    for (int i = 0; i < prefix.length(); i++) {
      // 对于每个字符
      char c = prefix.charAt(i);
      TrieNode[] nodes = node.getChild();
      // 如果c - 'a'为空，说明还没有存入
      TrieNode element = nodes[c - 'a'];
      // 如果不存在于前缀树中，返回false
      if (element == null) {
        return false;
      }
      node = element;
    }
    return true;
  }
}
