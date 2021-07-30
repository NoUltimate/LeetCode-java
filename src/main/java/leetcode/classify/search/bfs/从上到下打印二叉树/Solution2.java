package leetcode.classify.search.bfs.从上到下打印二叉树;
/*
 * solution版本的优化 奇偶判断和改为双端队列
 *
 * @author sunbowen
 * @date 2021年07月23日 10:18
 */

import util.TreeNode;

import java.util.*;

public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> row = new LinkedList<>();
            for(int i = queue.size(); i > 0; --i) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                if (result.size() % 2 == 0) {
                    row.addLast(node.val);
                } else {
                    // 先插入的会到后面
                    row.addFirst(node.val);
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            if (!row.isEmpty()) {
                result.add(row);
            }
        }
        return result;
    }
}
