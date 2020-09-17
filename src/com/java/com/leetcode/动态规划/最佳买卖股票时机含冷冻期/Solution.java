package com.java.com.leetcode.动态规划.最佳买卖股票时机含冷冻期;

/**
 * @author sunbowen
 * @date 2020/9/10 16:18
 * @time O(n)
 * @space O(n)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int len =  prices.length;
        if (len < 2) {
            return 0;
        }
        // int[m][n] m是第几天 n是状态 0-持股 1- 冻结 2-未持股
        int[][] dayProfit = new int[len][3];
        dayProfit[0][0] = -prices[0];
        dayProfit[0][1] = 0;
        dayProfit[0][2] = 0;
        for(int i = 1; i < len; ++i) {
            dayProfit[i][0] = Math.max(dayProfit[i-1][0], dayProfit[i-1][2] - prices[i]);
            dayProfit[i][1] = dayProfit[i-1][0] + prices[i];
            dayProfit[i][2] = Math.max(dayProfit[i-1][2], dayProfit[i-1][1]);
        }
        return Math.max(dayProfit[len-1][1], dayProfit[len-1][2]);
    }

//    public void dfs(int[] prices, int day, int lastBuy, int total) {
//        if (total > max) {
//            max = total;
//        }
//        // 买
//        if (day > prices.length - 1) {
//            return ;
//        }
//        // System.out.println("buy" + "买第" + day + "天");
//        dfs(prices, day + 1, day, total);
//
//        // 卖
//        if (lastBuy != -1 && prices[day] > prices[lastBuy]) {
//            dfs(prices, day + 2, -1, total + prices[day] - prices[lastBuy]);
//        }
//
//        // 什么都不干
//        dfs(prices, day+1, lastBuy, total);
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}