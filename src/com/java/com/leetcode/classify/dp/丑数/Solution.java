package com.java.com.leetcode.classify.dp.丑数;
/*
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 * 剑指 Offer 49. 丑数
 * @author sunbowen
 * @date 2021年07月22日 14:19
 */

public class Solution {
    public int nthUglyNumber(int n) {
        // dp[i]代表了第i个丑数
        int[] dp = new int[n];
        int a = 0, b = 0, c = 0;
        dp[0] = 1;
        for(int i = 1; i < n; ++i) {
            int nexta = dp[a] * 2, nextb = dp[b] * 3, nextc = dp[c] * 5;
            dp[i] = Math.min(nexta, Math.min(nextb, nextc));
            if (dp[i] == nexta) {
                a++;
            }
            if (dp[i] == nextb) {
                b++;
            }
            if (dp[i] == nextc) {
                c++;
            }
        }
        return dp[n - 1];
    }
}
