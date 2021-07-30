package leetcode.classify.tree.前序遍历;
/*
 *
 *
 * @author sunbowen
 * @date 2021年05月12日 15:04
 */


import util.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val);
            if (root.left != null) {
                result.addAll(preorderTraversal(root.left));
            }
            if (root.right != null) {
                result.addAll(preorderTraversal(root.right));
            }
        }
        return result;
    }
}
