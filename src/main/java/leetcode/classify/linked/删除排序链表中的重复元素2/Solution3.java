package leetcode.classify.linked.删除排序链表中的重复元素2;

import util.ListNode;

public class Solution3 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next != cur) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
