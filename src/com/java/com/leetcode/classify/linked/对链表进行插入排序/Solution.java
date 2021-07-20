package com.java.com.leetcode.classify.linked.对链表进行插入排序;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 待插入节点
        ListNode curr = head.next;
        // 已排序部分的最后一个节点
        ListNode lastModify = head;
        while (curr != null) {
            // 待插入节点大于已排序节点时候只要直接加入节点即可
            if (lastModify.val <= curr.val) {
                lastModify = lastModify.next;
            } else {
                ListNode prev = dummy;
                // 找到已排序中比要插入值小的节点
                while (prev.next.val < curr.val) {
                    prev = prev.next;
                }
                // 未排序部分删除要插入的节点curr
                lastModify.next = curr.next;
                // 待插入节点接入已排序部分
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastModify.next;
        }
        return dummy.next;
    }
}