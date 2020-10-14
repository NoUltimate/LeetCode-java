package com.java.com.leetcode.tag.动态规划.三角形最小路径和;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) {
            return 0;
        }

        // dp[i][j] 到（i，j）点的最小路径和
        int dp[][] = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); ++i) {
            for(int j = 0; j < i+1; ++j) {
                int value = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + value;
                }else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + value;
                }else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                }
            }
        }

        int min = dp[triangle.size()-1][0];
        for(int i = 1; i < triangle.get(triangle.size()-1).size(); ++i) {
            if (dp[triangle.size()-1][i] < min) {
                min = dp[triangle.size()-1][i];
            }
        }
        return min;
    }
}
