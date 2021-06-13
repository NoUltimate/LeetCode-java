package com.java.com.leetcode.classify.tree.从前序与中序遍历序列构造二叉树;
/*
 *
 *
 * @author sunbowen
 * @date 2021年05月14日 09:40
 */

import com.alibaba.fastjson.JSONObject;
import util.TreeNode;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return cur(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode cur(int[] preorder, int x, int y, int[] inorder, int i, int j) {
        if (x > y || i > j) {
            return  null;
        }
        int rootVal = preorder[x];
        int pos = i;
        for(int k = i; k <= j; ++k) {
            if (rootVal == inorder[k]) {
                pos = k;
            }
        }
        TreeNode treeNode =  new TreeNode(rootVal);
        treeNode.left = cur(preorder, x + 1, x + pos - i, inorder, i, pos - 1);
        treeNode.right = cur(preorder, x + pos - i + 1, y, inorder, pos + 1, j);
        return treeNode;
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7})));
    }
}