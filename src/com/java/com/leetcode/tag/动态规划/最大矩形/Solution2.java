package com.java.com.leetcode.tag.动态规划.最大矩形;

import com.java.com.leetcode.tag.动态规划.柱状图中最大的矩形.Solution;

/**
 * @author sunbowen
 * @time mn
 * @space n
 */
public class Solution2 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int maxSize = 0;
        for (char[] chars : matrix) {
            for (int j = 0; j < col; ++j) {
                if (chars[j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxSize = Math.max(maxSize, new Solution().largestRectangleArea(heights));
        }
        return maxSize;
    }

}
