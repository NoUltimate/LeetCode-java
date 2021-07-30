package leetcode.classify.search.bfs.从上到下打印二叉树;
/*
 * solution版本的优化 奇偶层逻辑分离
 *
 * @author sunbowen
 * @date 2021年07月23日 10:18
 */

import util.TreeNode;
import java.util.*;

public class Solution3 {
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
                row.addLast(node.val);
                if (node.left != null)  queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(row);
            if (queue.isEmpty()) break;

            row = new LinkedList<>();
            for(int i = queue.size(); i > 0; --i) {
                TreeNode node = queue.poll();
                row.addFirst(node.val);
                if (node.left != null)  queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(row);
        }
        return result;
    }
}
