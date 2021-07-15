package com.java.com.leetcode.tag.动态规划.股票的最大利润;
/*
 *
 *
 * @author sunbowen
 * @date 2021年06月24日 14:59
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; ++i) {
            if (prices[i] > min) {
                max = Math.max(max, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return max;
    }
}
