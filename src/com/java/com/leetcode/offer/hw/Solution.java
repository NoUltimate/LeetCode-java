package com.java.com.leetcode.offer.hw;
/*
 *
 *
 * @author sunbowen
 * @date 2021年06月25日 15:16
 */

import util.ListNode;

import java.math.BigDecimal;
import java.util.*;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 从i到j之间的最大值
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; ++i) {
            for(int j = i; j < nums.length; ++j) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], nums[j]);
                }
            }
        }
    }
}
