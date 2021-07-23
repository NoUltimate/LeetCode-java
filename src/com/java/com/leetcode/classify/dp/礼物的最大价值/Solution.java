package com.java.com.leetcode.classify.dp.礼物的最大价值;
/*
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 礼物的最大价值
 * @author sunbowen
 * @date 2021年07月23日 15:34
 */

public class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n + 1];
        for(int i = 1; i <= m; ++i) {
            for(int j = 1; j <= n; ++j) {
                dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i - 1][j - 1];
            }
        }
        return dp[n];
    }
}
