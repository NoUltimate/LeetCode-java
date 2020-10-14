package com.java.com.leetcode.tag.动态规划.柱状图中最大的矩形;

/**
 * @author sunbowen
 */

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        // 从1到i，将i依次作为最矮高度的柱子去计算最大的矩阵面积
        int n = heights.length;
        // 找到左边第一个比柱子i高度小的位置left_i和右边。。。right_i并保存到数组对应位置
        int[] left_i = new int[n];
        int[] right_i = new int[n];
        // 可以假设heights左右两边都加了一个高度为-1的柱子
        // -1 和 n是为了帮助whiile循环停下来
        left_i[0] = -1;
        right_i[n-1] = n;


        for(int i = 1; i < n; ++i) {
           int tmp = i - 1;
           // 位置i的left_i和左边大于他的柱子left_i是一样的
           while (tmp >= 0 &&heights[tmp] >= heights[i]) {
               tmp = left_i[tmp];
           }
           left_i[i] = tmp;
        }

        for(int i = n - 2; i >= 0; --i) {
            int tmp = i + 1;
            while (tmp < n &&heights[tmp] >= heights[i]) {
                tmp = right_i[tmp];
            }
            right_i[i] = tmp;
        }
        int max = 0;
        for(int i = 0; i < n; ++i) {
            max = Math.max(max, (right_i[i] - left_i[i] - 1) * heights[i]);
        }
        return max;
    }

}