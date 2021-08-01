package leetcode.classify.linked.复杂链表的复制;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月31日 14:57
 */

public class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        // 将所有节点复制一遍并且添加到原有节点的后面 1-2-3   1-1'-2-2'-3-3'
        for(Node cur = head; cur != null; cur = cur.next.next) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
        }

        // 先进行random的赋值，要在结构改变前做
        for(Node cur = head; cur != null; cur = cur.next.next) {
            if (cur.random != null) cur.next.random = cur.random.next;
        }

        Node newHead = head.next;
        // 将两个链表分离
        for(Node cur = head; cur != null; cur = cur.next) {
            Node tmp = cur.next;
            cur.next = tmp.next;
            if (tmp.next != null) tmp.next = tmp.next.next;
        }

        return newHead;
    }
}
