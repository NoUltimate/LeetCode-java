package com.java.com.leetcode.classify.tree.树的子结构;
/*
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 *
 * @author sunbowen
 * @date 2021年07月19日 17:02
 */

import util.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }


    public boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if ( A == null) return false;
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
