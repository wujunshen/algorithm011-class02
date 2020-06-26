package com.algorithm.class3.linkedlist;

import com.algorithm.common.ListNode;

/**
 * 141. 环形链表
 *
 * <p>给定一个链表，判断链表中是否有环。
 *
 * <p>为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：head = [3,2,0,-4], pos = 1 输出：true 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * <p>示例 2：
 *
 * <p>输入：head = [1,2], pos = 0 输出：true 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * <p>示例 3：
 *
 * <p>输入：head = [1], pos = -1 输出：false 解释：链表中没有环。
 *
 * <p>
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/27 00:07<br>
 */
public class LinkedListCycle {
  /**
   * 快慢指针
   *
   * @param head
   * @return
   */
  public boolean slowAndFastSolution(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      if (slow.equals(fast)) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }

    return false;
  }
}
