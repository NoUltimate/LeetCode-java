package com.java.com.leetcode.动态规划.爬楼梯;

class Solution {
    public int climbStairs(int n) {
        int[] method = new int[n+1];
        method[0] = 1;
        method[1] = 1;
        for(int i = 2; i <= n; ++i) {
            method[i] = method[i-1] + method[i-2];
        }
        return method[n];
    }
}
