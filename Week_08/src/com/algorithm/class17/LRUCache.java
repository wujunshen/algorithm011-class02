package com.algorithm.class17;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 *
 * <p>运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * <p>获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 写入数据 put(key, value) -
 * 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * <p>进阶:
 *
 * <p>你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * <p>
 *
 * <p>示例:
 *
 * <p>缓存容量 LRUCache cache = new LRUCache( 2 ); cache.put(1, 1); cache.put(2, 2); cache.get(1); // 返回
 * 1 cache.put(3, 3); // 该操作会使得关键字 2 作废 cache.get(2); // 返回 -1 (未找到) cache.put(4, 4); // 该操作会使得关键字 1
 * 作废 cache.get(1); // 返回 -1 (未找到) cache.get(3); // 返回 3 cache.get(4); // 返回 4
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/8/12 00:21<br>
 */
public class LRUCache {
  private final Map<Integer, Node> cache = new HashMap<>();
  private final int capacity;
  private final Node head;
  private final Node tail;
  private int size;

  /**
   * https://leetcode-cn.com/problems/lru-cache/solution/lruhuan-cun-ji-zhi-by-leetcode-solution/
   *
   * @param capacity
   */
  public LRUCache(int capacity) {
    this.size = 0;
    this.capacity = capacity;
    // 使用伪头部和伪尾部节点
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    Node node = cache.get(key);
    if (node == null) {
      return -1;
    }
    // 如果 key 存在，先通过哈希表定位，再移到头部
    moveToHead(node);
    return node.value;
  }

  public void put(int key, int value) {
    Node node = cache.get(key);
    if (node == null) {
      // 如果 key 不存在，创建一个新的节点
      Node newNode = new Node(key, value);
      // 添加进哈希表
      cache.put(key, newNode);
      // 添加至双向链表的头部
      addToHead(newNode);
      ++size;
      if (size > capacity) {
        // 如果超出容量，删除双向链表的尾部节点
        Node tail = removeTail();
        // 删除哈希表中对应的项
        cache.remove(tail.key);
        --size;
      }
    } else {
      // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
      node.value = value;
      moveToHead(node);
    }
  }

  private void addToHead(Node node) {
    node.prev = head;
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
  }

  private void removeNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private void moveToHead(Node node) {
    removeNode(node);
    addToHead(node);
  }

  private Node removeTail() {
    Node result = tail.prev;
    removeNode(result);
    return result;
  }

  static class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node() {}

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}
