package leetcode.classify.linked.LRU缓存;
/*
 *
 * 双向链表
 * @author sunbowen
 * @date 2021年08月02日 13:45
 */

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    Map<Integer, Node> m;
    int capacity;
    Node head;
    Node tail;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        m = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!m.containsKey(key)) return -1;
        Node node = m.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;

        // move to tail
        moveToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            m.get(key).val = value;
            return;
        }
        Node node = new Node(key, value);
        m.put(key, node);
        moveToTail(node);
        // move to tail;

        if (m.size() > capacity) {
            m.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
    }

    public void moveToTail(Node node) {
        node.pre = tail.pre;
        tail.pre = node;
        node.pre.next = node;
        node.next = tail;
    }

    public class Node {
        int key;
        int val;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.val = value;
            this.pre = null;
            this.next = null;
        }
    }
}
