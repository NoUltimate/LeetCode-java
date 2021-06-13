package com.java.com.leetcode.classify.linked.两数相加2;
/*
 *
 *
 * @author sunbowen
 * @date 2021年05月12日 13:49
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 */


import util.ListNode;
import util.ListNodeUtil;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode r1 = new ListNode(l1.val);
         l1 = l1.next;
         while (l1 != null) {
             ListNode temp = new ListNode(l1.val);
             temp.next = r1;
             r1 = temp;
             l1 = l1.next;
         }

         ListNode r2 = new ListNode(l2.val);
         l2 = l2.next;
         while (l2 != null) {
             ListNode temp = new ListNode(l2.val);
             temp.next = r2;
             r2 = temp;
             l2 = l2.next;
         }

         int up = 0;
         ListNode head = new ListNode();
         ListNode result = new ListNode();
         head = result;
         while (r1 != null || r2 != null) {
             int x, y;
             if (r1 == null) {
                 x = 0;
             } else {
                 x = r1.val;
             }
             if (r2 == null) {
                 y = 0;
             } else {
                 y = r2.val;
             }
             int sum = (x + y + up) % 10;
             up = (x + y) / 10;
             ListNode temp  = new ListNode(sum);
             temp.next = result.next;
             result.next = temp;
             if (r1 != null) {
                 r1 = r1.next;
             }
             if (r2 != null) {
                 r2 = r2.next;
             }
         }
         if (up != 0) {
             ListNode temp = new ListNode(up);
             temp.next = result.next;
             result.next = temp;
         }
         //System.out.println(head.next.toString());
         return head.next;
    }

    public static void main(String[] args) {
        new Solution().addTwoNumbers(ListNodeUtil.parseArray(new int[]{7, 2, 4, 3}), ListNodeUtil.parseArray(new int[]{5, 6, 4}));
    }
}
