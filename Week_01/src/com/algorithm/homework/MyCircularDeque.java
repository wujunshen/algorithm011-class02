package com.algorithm.homework;

import java.util.Arrays;

/**
 * 641. 设计循环双端队列
 *
 * <p>设计实现双端队列。 你的实现需要支持以下操作：
 *
 * <p>MyCircularDeque(k)：构造函数,双端队列的大小为k。 insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。 deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。 getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。 isEmpty()：检查双端队列是否为空。 isFull()：检查双端队列是否满了。 示例：
 *
 * <p>MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1); // 返回 true circularDeque.insertLast(2); // 返回 true
 * circularDeque.insertFront(3); // 返回 true circularDeque.insertFront(4); // 已经满了，返回 false
 * circularDeque.getRear(); // 返回 2 circularDeque.isFull(); // 返回 true circularDeque.deleteLast();
 * // 返回 true circularDeque.insertFront(4); // 返回 true circularDeque.getFront(); // 返回 4
 *
 * <p>提示：
 *
 * <p>所有值的范围为 [1, 1000] 操作次数的范围为 [1, 1000] 请不要使用内置的双端队列库。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/26 21:12<br>
 */
public class MyCircularDeque {
  private int[] data;
  private int head;
  private int tail;
  private int capacity;

  /** Initialize your data structure here. Set the size of the deque to be k. */
  public MyCircularDeque(int k) {
    data = new int[k + 1];
    capacity = k + 1;
  }

  public static void main(String[] args) {
    boolean result;
    int k = 3;
    MyCircularDeque myCircularDeque = new MyCircularDeque(k);
    System.out.print("data:" + Arrays.toString(myCircularDeque.data));
    System.out.print(" head:" + myCircularDeque.head);
    System.out.print(" tail:" + myCircularDeque.tail);
    System.out.println(" capacity:" + myCircularDeque.capacity);

    result = myCircularDeque.insertFront(6);
    System.out.print("data:" + Arrays.toString(myCircularDeque.data));
    System.out.print(" head:" + myCircularDeque.head);
    System.out.print(" tail:" + myCircularDeque.tail);
    System.out.println(" capacity:" + myCircularDeque.capacity);
    System.out.println(result);

    result = myCircularDeque.insertLast(7);
    System.out.print("data:" + Arrays.toString(myCircularDeque.data));
    System.out.print(" head:" + myCircularDeque.head);
    System.out.print(" tail:" + myCircularDeque.tail);
    System.out.println(" capacity:" + myCircularDeque.capacity);
    System.out.println(result);

    result = myCircularDeque.deleteFront();
    System.out.print("data:" + Arrays.toString(myCircularDeque.data));
    System.out.print(" head:" + myCircularDeque.head);
    System.out.print(" tail:" + myCircularDeque.tail);
    System.out.println(" capacity:" + myCircularDeque.capacity);
    System.out.println(result);

    result = myCircularDeque.deleteLast();
    System.out.print("data:" + Arrays.toString(myCircularDeque.data));
    System.out.print(" head:" + myCircularDeque.head);
    System.out.print(" tail:" + myCircularDeque.tail);
    System.out.println(" capacity:" + myCircularDeque.capacity);
    System.out.println(result);

    int front = myCircularDeque.getFront();
    System.out.println(front);

    int rear = myCircularDeque.getRear();
    System.out.println(rear);

    result = myCircularDeque.isEmpty();
    System.out.print("data:" + Arrays.toString(myCircularDeque.data));
    System.out.print(" head:" + myCircularDeque.head);
    System.out.print(" tail:" + myCircularDeque.tail);
    System.out.println(" capacity:" + myCircularDeque.capacity);
    System.out.println(result);

    result = myCircularDeque.isFull();
    System.out.print("data:" + Arrays.toString(myCircularDeque.data));
    System.out.print(" head:" + myCircularDeque.head);
    System.out.print(" tail:" + myCircularDeque.tail);
    System.out.println(" capacity:" + myCircularDeque.capacity);
    System.out.println(result);
  }

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  public boolean insertFront(int value) {
    if (isFull()) {
      return false;
    }

    data[(head - 1 + capacity) % capacity] = value;
    return true;
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  public boolean insertLast(int value) {
    if (isFull()) {
      return false;
    }

    data[tail] = value;
    tail = (tail + 1) % capacity;

    return true;
  }

  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  public boolean deleteFront() {
    if (isEmpty()) {
      return false;
    }

    head = (head + 1) % capacity;
    return true;
  }

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  public boolean deleteLast() {
    if (isEmpty()) {
      return false;
    }

    tail = (tail - 1 + capacity) % capacity;
    return true;
  }

  /** Get the front item from the deque. */
  public int getFront() {
    return isEmpty() ? -1 : data[head];
  }

  /** Get the last item from the deque. */
  public int getRear() {
    return isEmpty() ? -1 : data[(tail - 1 + capacity) % capacity];
  }

  /** Checks whether the circular deque is empty or not. */
  public boolean isEmpty() {
    return head == tail;
  }

  /** Checks whether the circular deque is full or not. */
  public boolean isFull() {
    return (tail + 1) % capacity == head;
  }
}
