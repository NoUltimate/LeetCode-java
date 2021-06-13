package util;
/*
 *
 *
 * @author sunbowen
 * @date 2021年05月12日 14:36
 */

public class ListNodeUtil {
    public static ListNode parseArray(int[] array) {
        ListNode head = new ListNode();
        ListNode node = new ListNode();
        head = node;
        for(int a : array) {
            ListNode temp = new ListNode(a);
            node.next = temp;
            node = temp;
        }
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNodeUtil.parseArray(new int[]{1, 2}).toString());
    }
}
