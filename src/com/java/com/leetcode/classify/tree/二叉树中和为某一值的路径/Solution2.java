package com.java.com.leetcode.classify.tree.二叉树中和为某一值的路径;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月21日 11:24
 */

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return result;
        }
        recur(root, target, new ArrayList<>());
        return result;
    }

    public void recur(TreeNode node, int target, List<Integer> list) {
        if (node == null) return;
        target -= node.val;
        list = new ArrayList<>(list);
        list.add(node.val);
        if (target == 0 && node.left == null && node.right == null) {
            result.add(list);
        }
        recur(node.left, target, list);
        recur(node.right, target, list);
    }
}
