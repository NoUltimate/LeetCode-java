package leetcode.classify.linked.LRU缓存;
/*
 *
 * 单链表
 * @author sunbowen
 * @date 2021年08月02日 14:20
 */

import java.util.HashMap;
import java.util.Map;

public class LRUCache3 {

    Map<Integer, Node> m;
    int capacity;
    Node head;
    Node tail;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        m = new HashMap<>();
        head = new Node(-1, -1);
        tail = head;
    }

    public int get(int key) {
        if (!m.containsKey(key)) return -1;
        // map中保存的是当前节点的前驱，因为单链表没有pre
        Node pre = m.get(key);
        Node cur = pre.next;
        if (cur != tail) {
            pre.next = cur.next;
            // 更新前驱节点
            m.put(cur.next.key, pre);
            moveToTail(cur);
        }
        return cur.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            // 判断已经包含了节点的移动到尾部
            m.get(key).next.val = value;
            return;
        }
        // 不存在那么就要新建节点
        Node node = new Node(key, value);
        moveToTail(node);

        if (m.size() > capacity) {
            m.remove(head.next.key);
            m.put(head.next.next.key, head);
            head.next = head.next.next;
        }
    }

    public void moveToTail(Node node) {
        m.put(node.key, tail);
        tail.next = node;
        tail = node;
    }

    public class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
            this.next = null;
        }
    }
}

