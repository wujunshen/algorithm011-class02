package com.algorithm.class3.linkedlist;

import com.algorithm.common.ListNode;

/**
 * 24. 两两交换链表中的节点
 *
 * <p>给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * <p>你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * <p>
 *
 * <p>示例:
 *
 * <p>给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/26 23:26<br>
 */
public class SwapNodesInPairs {
  /**
   * 递归
   *
   * @param head
   * @return
   */
  public ListNode swapPairs(ListNode head) {
    if ((head == null) || (head.next == null)) {
      return head;
    }
    ListNode n = head.next;
    head.next = swapPairs(head.next.next);
    n.next = head;
    return n;
  }

  /**
   * 非递归
   *
   * @param head
   * @return
   */
  public ListNode swapPairs1(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    ListNode newHead = head.next;
    while (cur != null && cur.next != null) {
      ListNode tmp = cur;
      cur = cur.next;
      tmp.next = cur.next;
      cur.next = tmp;
      cur = tmp.next;
      if (cur != null && cur.next != null) {
        tmp.next = cur.next;
      }
    }
    return newHead;
  }
}
