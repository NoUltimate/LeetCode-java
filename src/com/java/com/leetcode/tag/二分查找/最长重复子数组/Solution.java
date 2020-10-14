package com.java.com.leetcode.tag.二分查找.最长重复子数组;

/**
 * 动态规划
 *
 * @author sunbowen
 * @date 2020/10/9 10:30
 * @time O(mn)
 * @space O(mn)
 */


public class Solution {
    public int findLength(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        int max = 0;
        // dp[i][j] A数组从i位置开头，B数组从j开头的最长重复数组
        int dp[][] = new int[len1+1][len2+1];
        for(int i = len1-1; i >= 0; --i) {
            for(int j = len2-1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
