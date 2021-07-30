package leetcode.classify.search.bfs.从上到下打印二叉树;
/*
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * @author sunbowen
 * @date 2021年07月23日 10:17
 */

import util.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int h = 1;
        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                row.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (h % 2 == 0) {
                Collections.reverse(row);
            }
            h++;
            if (!row.isEmpty()) {
                result.add(row);
            }
        }
        return result;
    }
}
