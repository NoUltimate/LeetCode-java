package com.java.com.leetcode.tag.动态规划.最大矩形;

/**
 * @author sunbowen
 * @version 1.0.0
 * @time m²n
 * @space mn
 */


class Solution {
    public int maximalRectangle(char[][] matrix) {
        // 处理特殊情况
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        // 记录每个位置的最长连续1的长度
        int[][] record = new int[row][col];

        int maxSize = 0;

        // 计算连续1的长度, i,j确定一个点，将点作为矩阵的右下角顶点计算最大高度
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        record[i][j] = 1;
                    } else {
                        record[i][j] = record[i][j-1] + 1;
                    }
                } else {
                    record[i][j] = 0;
                }

                // 记录最小连续1的长度
                int minWeight = record[i][j];
                // 处理计算过的行的最大面积, 每次高度增加一行
                for(int k = i; k >= 0; k--) {
                    int height = (i - k) + 1;
                    minWeight = Math.min(minWeight, record[k][j]);
                    maxSize = Math.max(maxSize, height * minWeight);
                }
            }

        }
        return maxSize;
    }
}