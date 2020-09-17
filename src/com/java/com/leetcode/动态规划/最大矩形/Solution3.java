package com.java.com.leetcode.动态规划.最大矩形;

import com.java.com.leetcode.动态规划.柱状图中最大的矩形.Solution;

import java.util.Arrays;

/**
 * @author sunbowen
 * @time mn
 * @space n
 */
public class Solution3 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[] left_i = new int[col];
        int[] right_i = new int[col];
        Arrays.fill(left_i, -1);
        Arrays.fill(right_i, col);
        int[] heights = new int[col];
        int maxSize = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            // 记录上一个0的位置
            int pos = -1;
            // 已j为中心往左找最近的低于j的柱子
            for(int j = 0; j < col; ++j) {
                if (matrix[i][j] == '1') {
                    left_i[j] = Math.max(left_i[j], pos);
                } else {
                    // 等于0说明柱子高度降为0了
                    left_i[j] = -1;
                    pos = j;
                }
            }

            pos = col;
            for(int j = col - 1; j >= 0; --j) {
                if (matrix[i][j] == '1') {
                    right_i[j] = Math.min(right_i[j], pos);
                } else {
                    right_i[j] = col;
                    pos = j;
                }
            }

            for(int j = 0; j < col; ++j) {
                int width = right_i[j] - left_i[j] - 1;
                maxSize = Math.max(maxSize, width * heights[j]);
            }

        }
        return maxSize;
    }
}
