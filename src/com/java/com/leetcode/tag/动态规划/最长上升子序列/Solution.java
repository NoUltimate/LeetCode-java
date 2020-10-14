package com.java.com.leetcode.tag.动态规划.最长上升子序列;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        // dp[i] 以位置i为结尾的最长上升子序列长度
        int dp[] = new int[len];
        Arrays.fill(dp, 1);

        for(int i = 0; i < len; ++i) {
            int max = 0;
            for(int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    if (max < dp[j]) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = Math.max(max + 1, dp[i]);
        }

        int max = 0;
        for(int i = 0; i < len; ++i) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }
}
