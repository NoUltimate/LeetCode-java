package com.java.com.leetcode.tag.动态规划.计算各个位数不同的数字个数;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        // dp[i] 位数为i的时候，所有位数字都不同的个数
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 10;
        for(int i = 2; i <= n; ++i) {
            // i位不重复数字由（i-1）位的不重复数字和另一个不重复的数字组成
            // i-1位的不重复数字 = dp[i-1] - dp[i-2]
            // 另一个不重复的数字 10-(i-1) 种可能   一共有10个数字，不能和已经确定的i-1位数字中任意一个相同 其中已经包含了0的可能性，所以dp[0]=1就可以将0排除掉
            dp[i] = dp[i-1] + (dp[i-1] - dp[i-2])*(10-(i-1));
        }
        return dp[n];
    }
}
