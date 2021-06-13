package com.java.com.leetcode.classify.tree.二叉树的序列化与反序列化;
/*
 *
 *
 * @author sunbowen
 * @date 2021年05月18日 15:08
 */

import com.alibaba.fastjson.JSONObject;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("X");
            } else {
                result.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return String.join(",", result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splits = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        if (splits[0].equals("0")) {
            return new TreeNode();
        }
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (count + 1 < splits.length) {
                String val = splits[++count];
                TreeNode left;
                if (val.equals("X")) {
                    left = null;
                } else {
                    left = new TreeNode(Integer.parseInt(val));
                    node.left = left;
                    queue.add(left);
                }
            }
            if (count + 1 < splits.length) {
                String val = splits[++count];
                TreeNode right;
                if (val.equals("X")) {
                    right = null;
                } else {
                    right = new TreeNode(Integer.parseInt(val));
                    node.right = right;
                    queue.add(right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new Codec().serialize(new TreeNode()));
        System.out.println(JSONObject.toJSONString(new Codec().deserialize("0,X,X")));
    }
}
