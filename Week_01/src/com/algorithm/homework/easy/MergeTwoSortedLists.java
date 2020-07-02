package com.algorithm.homework.easy;

import com.algorithm.common.ListNode;

/**
 * 21. 合并两个有序链表
 *
 * <p>将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * <p>示例：
 *
 * <p>输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author frank woo(吴峻申) <br>
 *     email:<a href="mailto:frank_wjs@hotmail.com">frank_wjs@hotmail.com</a> <br>
 * @date 2020/6/25 23:21<br>
 */
public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode linked1, ListNode linked2) {
    // 下面4行是空判断
    if (linked1 == null) {
      return linked2;
    }
    if (linked2 == null) {
      return linked1;
    }
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (linked1 != null && linked2 != null) {
      // 比较一下，哪个小就把哪个放到新的链表中
      if (linked1.val <= linked2.val) {
        curr.next = linked1;
        linked1 = linked1.next;
      } else {
        curr.next = linked2;
        linked2 = linked2.next;
      }
      curr = curr.next;
    }
    // 然后把那个不为空的链表挂到新的链表中
    curr.next = linked1 == null ? linked2 : linked1;
    return dummy.next;
  }
}
