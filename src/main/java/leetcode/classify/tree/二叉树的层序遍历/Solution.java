package leetcode.classify.tree.二叉树的层序遍历;
/*
 *
 *
 * @author sunbowen
 * @date 2021年05月13日 10:44
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 */

import util.TreeNode;

import java.util.*;

public class Solution {

    public static class Node {
        TreeNode treeNode;
        int height;

        public Node(TreeNode treeNode, int height) {
            this.treeNode = treeNode;
            this.height = height;
        }

        public TreeNode getTreeNode() {
            return treeNode;
        }

        public void setTreeNode(TreeNode treeNode) {
            this.treeNode = treeNode;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer,List<Integer>> m = new HashMap<>();
        int h = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, h));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int height = node.getHeight();
            List<Integer> element = new ArrayList<>();
            if (m.containsKey(height)) {
                element = m.get(height);
            }
            element.add(node.getTreeNode().val);
            m.put(height, element);
            if (node.getTreeNode().right != null) {
                queue.add(new Node(node.getTreeNode().right, height + 1));
            }
            if (node.getTreeNode().left != null) {
                queue.add(new Node(node.getTreeNode().left, height + 1));
            }
        }

        for(int i = m.size() - 1; i >= 0; --i) {
            result.add(m.get(i));
        }
        return result;
    }
}
