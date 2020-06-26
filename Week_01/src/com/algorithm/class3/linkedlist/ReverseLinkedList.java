package com.algorithm.class3.linkedlist;

import com.algorithm.common.ListNode;

/**
 * 206. 反转链表
 *
 * <p>反转一个单链表。
 *
 * <p>示例:
 *
 * <p>输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL 进阶: 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/26 23:13<br>
 */
public class ReverseLinkedList {
  /**
   * 非递归
   *
   * @param head
   * @return
   */
  public ListNode reverseList1(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

  /**
   * 递归
   *
   * @param head
   * @return
   */
  public ListNode reverseList2(ListNode head) {
    // 如果当前要反转的节点为 null 或者反转链表为 null
    // head.next 为 null，即反转链表的尾结点不存在，即反转链表不存在
    if (head == null || head.next == null) {
      return head;
    }
    // 节点 p 其实就是反转链表的头节点
    ListNode p = reverseList2(head.next);
    // 我们将反转链表的尾结点（head.next）的 next 指向当前即将反转的节点
    head.next.next = head;
    // 然后让当前节点变成反转链表的尾结点
    head.next = null;
    // 返回反转链表的头结点
    return p;
  }
}
