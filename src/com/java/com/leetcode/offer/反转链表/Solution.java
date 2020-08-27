package com.java.com.leetcode.offer.反转链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(head.val);
        while(head.next != null) {
            ListNode node = new ListNode(head.next.val);
            node.next = newHead;
            newHead = node;
            head = head.next;
        }
        return newHead;
    }
}