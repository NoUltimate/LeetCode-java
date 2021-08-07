package leetcode.classify.linked.反转链表2;
/*
 *
 *
 * @author sunbowen
 * @date 2021年08月06日 11:11
 */

import util.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode g = pre;
        for(int i = 0; i < left - 1; ++i) {
            head = head.next;
            g = g.next;
        }
        for(int i = left; i < right; ++i) {
            ListNode n = head.next;
            head.next = n.next;
            n.next = head;
            g.next = n;
        }
        return pre.next;
    }
}
