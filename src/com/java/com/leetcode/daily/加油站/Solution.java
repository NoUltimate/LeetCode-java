package com.java.com.leetcode.daily.加油站;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int l = gas.length;
        int[] arr = new int[l];
        for(int i = 0; i < l; ++i) {
            arr[i] = gas[i] - cost[i];
        }

        int count = 0;
        int run = 0;
        int pos = 0;
        for(int i = 0; i < l; ++i) {
            // 和为负数就重新开始计算
            if( run < 0 ) {
                run = 0;
                pos = i;
            }
            count += arr[i];
            run += arr[i];
        }
        return count >= 0 ? pos : -1;
    }

}
