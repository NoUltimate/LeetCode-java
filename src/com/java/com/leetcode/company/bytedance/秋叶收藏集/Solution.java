package com.java.com.leetcode.company.bytedance.秋叶收藏集;

public class Solution {
    public int minimumOperations(String leaves) {
        int n = leaves.length();
        if (n <= 2) {
            return 0;
        }
        // dp[0][i] 全红 dp[1][i] 红黄  dp[2][i] 红黄红
        int dp[][] = new int[3][n];
        for(int i = 0; i < n; ++i) {
            if (i < 1) {
                dp[0][i] = leaves.charAt(i)=='y'?1:0;
            } else {
                dp[0][i] = dp[0][i-1] + (leaves.charAt(i)=='y'?1:0);
            }

            if (i < 1) {
                dp[1][i] = dp[0][i];
            } else {
                dp[1][i] = Math.min(dp[1][i-1], dp[0][i-1]) + (leaves.charAt(i)=='r'?1:0);
            }

            if (i < 2) {
                dp[2][i] = dp[1][i];
            } else {
                dp[2][i] = Math.min(dp[2][i-1], dp[1][i-1]) + (leaves.charAt(i)=='y'?1:0);
            }

            // System.out.println("i == " + i + "  dp[0][i]=" + dp[0][i] + "  dp[1][i]=" + dp[1][i] + "  dp[2][i]=" + dp[2][i] + " " + (leaves.charAt(i)=='y'?1:0) + "  " + (leaves.charAt(i)=='r'?1:0));
        }
        return dp[2][n-1];
    }


    public static void main(String[] args) {
        System.out.println('r'=='r'?2:1);
        System.out.println(1 + (1 + 'r'=='r'?2:1));
        System.out.println("result=" + "r"=="r"?"2":"1");
        System.out.println("result=" + ("r"=="r"?"2":"1"));
    }

}

