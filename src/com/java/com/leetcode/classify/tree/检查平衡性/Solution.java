package com.java.com.leetcode.classify.tree.检查平衡性;
/*
 *
 *
 * @author sunbowen
 * @date 2021年05月19日 09:34
 * https://leetcode-cn.com/problems/check-balance-lcci/
 */

import util.TreeNode;

public class Solution {
    boolean b = true;

    public boolean isBalanced(TreeNode root) {
        calHigh(root);
        return b;
    }

    public int calHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = calHigh(root.left);
        int right = calHigh(root.right);
        if (Math.abs(left - right) > 1) {
            b = false;
        }
        return 1 + Math.max(left, right);
    }

}
