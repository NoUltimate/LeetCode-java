package leetcode.classify.tree.有序链表转换二叉搜索树;
/*
 *
 *
 * @author sunbowen
 * @date 2021年05月14日 13:37
 */

import com.alibaba.fastjson.JSONObject;
import util.ListNode;
import util.ListNodeUtil;
import util.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = new ListNode();
        while (fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        TreeNode treeNode = new TreeNode(slow.val);
        treeNode.left = sortedListToBST(head);
        treeNode.right = sortedListToBST(slow.next);
        return treeNode;
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new Solution().sortedListToBST(ListNodeUtil.parseArray(new int[] {-10, -3, 0, 5,  9}))));
    }
}
