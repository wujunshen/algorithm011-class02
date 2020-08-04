package com.algorithm.template;

/**
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/4 11:41<br>
 */
public class Trie {
  private String word;
  private Trie[] next;
  private boolean isEnd;
  /** Initialize your data structure here. */
  public Trie() {
    isEnd = false;
    next = new Trie[26];
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

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public Trie[] getNext() {
    return next;
  }

  public void setNext(Trie[] next) {
    this.next = next;
  }

  public boolean isEnd() {
    return isEnd;
  }

  public void setEnd(boolean end) {
    isEnd = end;
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    if (word == null || word.length() == 0) {
      return;
    }
    Trie curr = this;
    char[] words = word.toCharArray();
    for (char c : words) {
      int n = c - 'a';
      if (curr.next[n] == null) {
        curr.next[n] = new Trie();
      }
      curr = curr.next[n];
    }
    curr.isEnd = true;
    curr.word = word;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    Trie node = searchPrefix(word);
    return node != null && node.isEnd;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    Trie node = searchPrefix(prefix);
    return node != null;
  }

  private Trie searchPrefix(String word) {
    Trie node = this;
    char[] words = word.toCharArray();
    for (char c : words) {
      node = node.next[c - 'a'];
      if (node == null) {
        return null;
      }
    }
    return node;
  }
}
