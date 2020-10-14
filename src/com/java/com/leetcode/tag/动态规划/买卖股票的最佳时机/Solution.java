package com.java.com.leetcode.tag.动态规划.买卖股票的最佳时机;

/**
 * @author sunbowen
 * @date 2020/9/17 9:25
 * @time O(n)
 * @space O(n)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        // 0是未持股 1是持股
        int[] profit = new int[n];
        int min = prices[0];
        int max = 0;
        for(int i = 0; i < n; ++i) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
