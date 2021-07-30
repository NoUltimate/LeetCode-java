package leetcode.classify.tree.二叉搜索树与双向链表;
/*
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * @author sunbowen
 * @date 2021年07月22日 09:01
 */

import util.Node;
import util.TreeNode;

import java.util.*;

public class Solution {

    Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    // 中序遍历
    public void dfs(Node cur) {

        if (cur == null) {
            return ;
        }
        //从左节点开始
        dfs(cur.left);
        if (pre == null) {
            // 第一次进入if的时候是整个树最左节点, 二叉搜索树最小的节点，也就是head
            head = cur;
        } else {
            // pre不为null说明已经开始遍历中间的根节点了,根节点和左节点形成双向链表,pre是左节点， cur是根节点
            pre.right = cur;
        }
        cur.left = cur;
        pre = cur;
        dfs(cur.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        mid(root, result);
        return result;
    }

    public void mid(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        mid(node.left, list);
        list.add(node.val);
        mid(node.right, list);
    }

}
