package leetcode.classify.linked.排序链表;
/*
 *
 *
 * @author sunbowen
 * @date 2021年08月05日 14:34
 */

import util.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        return mergeSort(head);
    }


    public ListNode mergeSort(ListNode head) {
        if (head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(slow);
        return merge(l, r);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while (left != null && right != null) {
            if (left.val > right.val) {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            } else {
                cur.next = left;
                cur = cur.next;
                left = left.next;
            }
        }

        if (left != null) cur.next = left;

        if (right != null) cur.next = right;
        return head.next;
    }
}
