package leetcode.classify.linked.链表求和;
/*
 *
 *
 * @author sunbowen
 * @date 2021年03月29日 09:25
 */



public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int num = num1 + num2 + carry;
            // 进位
            carry = num/10;
            cur.next = new ListNode(num % 10);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return result.next;
    }
}
