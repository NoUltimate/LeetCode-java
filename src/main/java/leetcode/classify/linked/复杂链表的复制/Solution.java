package leetcode.classify.linked.复杂链表的复制;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月31日 14:39
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> m = new HashMap<>();
        for(Node cur = head; cur != null; cur = cur.next) {
            m.put(cur, new Node(cur.val));
        }

        for(Node cur = head; cur != null; cur = cur.next) {
            m.get(cur).next = m.get(cur.next);
            m.get(cur).random = m.get(cur.random);
        }
        return m.get(head);
    }
}
