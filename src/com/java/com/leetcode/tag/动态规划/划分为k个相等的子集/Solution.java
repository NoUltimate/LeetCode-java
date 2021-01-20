package com.java.com.leetcode.tag.动态规划.划分为k个相等的子集;


import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

class Solution {

    public boolean dfs(int[] group, int[] nums, int pos, int target) {
        if (pos < 0) {
            return true;
        }
        int v = nums[pos];
        for(int i = 0; i < group.length; ++i) {
            if (group[i] + v <= target) {
                group[i] += v;
                if (dfs(group, nums, pos - 1, target)) {
                    return true;
                }
                group[i] -= v;
            }

            // group[i]=0说明i位置放了第一个数字后搜索无法通过，那边必然失败
            if (group[i] == 0) {
                break;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) {
            return false;
        }
        int target = sum / k;
        int row = nums.length - 1;
        // 默认升序
        Arrays.sort(nums);
        if (nums[row] > target) {
            return false;
        }
        // 和目标相等的直接取出单独作为一组
        while(row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return dfs(new int[k], nums, row, target);
    }

}
