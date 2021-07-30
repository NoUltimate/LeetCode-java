package leetcode.classify.tree.从上到下打印二叉树;
/*
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 * @author sunbowen
 * @date 2021年07月20日 16:01
 */

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, List<Integer>> ans = new HashMap<>();

    public int[] levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int h = 0;
        while (ans.containsKey(h)) {
            result.addAll(ans.get(h));
            h++;
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void dfs(TreeNode root, int h) {
        if (root == null) {
            return;
        }
        List<Integer> list = ans.getOrDefault(h, new ArrayList<>());
        list.add(root.val);
        dfs(root.left, h + 1);
        dfs(root.right, h + 1);
    }
}
