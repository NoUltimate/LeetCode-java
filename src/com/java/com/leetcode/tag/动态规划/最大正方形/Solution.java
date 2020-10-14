package com.java.com.leetcode.tag.动态规划.最大正方形;

/**
 * @author sunbowen
 * @date 2020/9/23 10:50
 * @time O(mn)
 * @space O(mn)
 */

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        // dp[i][j] 以（i，j）为正方形右下角点时，正方形的最大边长
        int[][] dp = new int[row+1][col+1];

        for(int i = 1; i <= row; ++i) {
            for(int j = 1; j <= col; ++j) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}
