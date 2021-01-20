package com.java.com.leetcode.tag.树.求根到叶子节点数字之和;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> numberList = new ArrayList<String>();
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        dfs(root, "");
        for(String numberStr : numberList) {
            int number = Integer.parseInt(numberStr);
            result += number;
        }
        return result;
    }

    public void dfs(TreeNode node, String number) {
        number = number + node.val;
        if (node.left != null) {
            dfs(node.left, number);
        }
        if (node.right != null) {
            dfs(node.right, number);
        }

        if (node.right == null && node.left == null) {
            numberList.add(number);
            return ;
        }
    }
}
