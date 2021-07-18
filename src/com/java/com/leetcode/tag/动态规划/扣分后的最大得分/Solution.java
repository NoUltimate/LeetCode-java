package com.java.com.leetcode.tag.动态规划.扣分后的最大得分;

/*
 * https://leetcode-cn.com/problems/maximum-number-of-points-with-cost/
 *
 * @author sunbowen
 * @date 2021年06月25日 15:16
 */

import util.ListNode;

import java.math.BigDecimal;
import java.util.*;

public class Solution {
    private int max = 0;

//    f[i][j]=
//    {
//        points[i][j] + maxf[i−1][k]−(j−k),
//        points[i][j] + maxf[i−1][k]−(k−j),
//    }


    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        for(int i = 0; i < n; ++i) {
            dp[0][i] = points[0][i];
        }
        // dp[i][j]的含义是取该点的时候获得的最大分数，那么此最大分数和上一层分数以及两者的距离有关
        // 而这个最大分数的计算方式和上一层节点和其位置有关，左边和右边取其最大值
        for(int i = 1; i < m; ++i) {
            long max = dp[i - 1][0];
            for(int j = 0; j < n; ++j) {
                max = Math.max(max, dp[i - 1][j] + j);
                dp[i][j] = max + points[i][j] - j;
            }

            max = dp[i-1][n - 1] - (n - 1);
            for(int j = n - 2; j >= 0; --j) {
                max = Math.max(max, dp[i - 1][j] - j);
                dp[i][j] = Math.max(dp[i][j], max + points[i][j] + j);
            }
        }

        long max = dp[m - 1][0];
        for(int i = 0; i < n; ++i) {
            max = Math.max(max, dp[m - 1][i]);
        }
        return max;
    }

}
