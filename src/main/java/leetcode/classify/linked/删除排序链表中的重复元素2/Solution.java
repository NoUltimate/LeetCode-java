package leetcode.classify.linked.删除排序链表中的重复元素2;

import util.ListNode;

import java.util.HashMap;
import java.util.Map;

/*
 * 删除排序链表中的重复元素 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @author sunbowen
 * @date 2021年07月20日 16:32
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 存储每个数值对应的前驱节点
        Map<Integer, ListNode> m = new HashMap<>();
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode result = pre;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            while (cur.val == cur.next.val) cur = cur.next;
            if (m.containsKey(cur.val)) {
                ListNode duplicatePre = m.get(cur.val);
                duplicatePre.next = cur.next;
                // 该节点对应的值都重复了都需要删掉，所以要返回到被删除的所有节点中的第一个节点的前一个位置
                pre = duplicatePre;
            } else {
                m.put(cur.val, pre);
                pre = pre.next;
            }
        }
        return result.next;
    }
}
