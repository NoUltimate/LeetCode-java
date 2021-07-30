package leetcode.classify.tree.二叉树中和为某一值的路径;
/*
 * https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * 二叉树中和为某一值的路径
 * @author sunbowen
 * @date 2021年07月21日 10:45
 */

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static class Point {
        int sum;
        TreeNode node;
        List<Integer> list;
        public Point(int sum, TreeNode node, List<Integer> list) {
            this.sum = sum;
            this.node = node;
            this.list = list;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, root, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            point.sum += point.node.val;
            List<Integer> list = new ArrayList<>(point.list);
            list.add(point.node.val);
            if (point.node.right == null && point.node.left == null) {
                if (target == point.sum && !list.isEmpty()) {
                    result.add(list);
                }
                continue;
            }
            if (point.node.left != null) {
                queue.add(new Point(point.sum, point.node.left, list));
            }
            if (point.node.right != null) {
                queue.add(new Point(point.sum, point.node.right, list));
            }
        }
        return result;
    }
}
