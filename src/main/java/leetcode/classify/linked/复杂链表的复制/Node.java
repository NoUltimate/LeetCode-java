package leetcode.classify.linked.复杂链表的复制;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月31日 14:39
 */

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
