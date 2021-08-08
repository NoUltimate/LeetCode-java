package leetcode.classify.linked.删除排序链表中的重复元素2;

import util.ListNode;

public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } else {
            while (head.next != null && head.val == head.next.val) head = head.next;
            return deleteDuplicates(head.next);
        }
    }
}
