package com.java.com.leetcode.company.bytedance.早餐组合;

public class Solution2 {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        // count[i]记录价格小于i的主食的数量
        int[] count = new int[x+1];
        int ans = 0;
        for(int val : staple) {
            if (val < x) {
                count[val] += 1;
            }
        }

        // 统计小于i的总数
        for(int i = 2; i < x; ++i) {
            count[i] += count[i-1];
        }

        for(int val : drinks) {
            int remain = x - val;
            if (remain <= 0) {
                continue;
            }
            ans += count[remain];
            ans %= 1000000007;
        }
        return ans;
    }
}


