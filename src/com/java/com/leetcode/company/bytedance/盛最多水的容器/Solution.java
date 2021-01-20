package com.java.com.leetcode.company.bytedance.盛最多水的容器;

public class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {

            if (height[i] < height[j]) {
                max = Math.max(max, (j-i) * height[i]);
                i++;
            } else {
                max = Math.max(max, (j-i) * height[j]);
                j--;
            }
        }
        return max;
    }
}
