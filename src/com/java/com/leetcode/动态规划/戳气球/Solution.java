package com.java.com.leetcode.动态规划.戳气球;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 描述
 *
 *
 * @author sunbowen
 * @date 2020/9/14 9:41
 */

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] values = new int[n+2];
        values[0] = values[n+1] = 1;
        for(int i = 0; i < n; ++ i) {
            values[i+1] = nums[i];
        }

        // store[i][j] 从i到j的开区间内戳破所有气球后的最大金币值
        int[][] store = new int[n+2][n+2];
        for(int len = 3; len <= n+2; len++) {
            for(int i = 0; i <= n+2-len; i++) {
                for(int k = i+1; k < i+len-1; k++) {
                    int value = store[i][k] + store[k][i+len-1] + values[k]*values[i]*values[i+len-1];
                    System.out.println("i:" + value);
                    store[i][i+len-1] = Math.max(store[i][i+len-1], store[i][k] + store[k][i+len-1] + values[k]*values[i]*values[i+len-1]);
                }
            }
        }
        return store[0][n+1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{3, 1, 5, 8}));
    }
}
