package com.java.com.leetcode.offer.hw;
/*
 *
 * @author sunbowen
 * @date 2021年06月25日 15:16
 */

import util.ListNode;
import util.TreeNode;

import java.math.BigDecimal;
import java.util.*;

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
