package com.java.com.leetcode.offer.顺时针打印矩阵;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        // 外面包了一圈所以从（1，1）开始走
        int start=1, end=1, count=0;
        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int col = matrix[0].length;
        int[] result = new int[col*row];
        // 给原本矩阵外面包一圈
        int[][] visit = new int[row+2][col+2];
        // 把外围一圈设置为已经访问过的状态1
        for(int i = 0; i < col+2; ++i) {
            visit[0][i] = 1;
            visit[row+1][i] = 1;
        }
        for(int j = 0; j < row+2; ++j) {
            visit[j][0] = 1;
            visit[j][col+1] = 1;
        }
        while(count != row*col) {
            // System.out.println("count:" + count + "        " + "(" + start + "," + end + ")");
            result[count] = matrix[start - 1][end - 1];
            visit[start][end] = 1;
            count++;
            // 上面有障碍，右边空就往右边走
            if(visit[start-1][end] == 1 && visit[start][end+1]==0) {
                end++;
                continue;
            }
            // 右边有障碍，下面空就往下面走
            if(visit[start][end+1] == 1 && visit[start+1][end] == 0) {
                start++;
                continue;
            }
            // 下面有障碍，左边空就往左走
            if(visit[start+1][end] == 1 && visit[start][end-1] == 0) {
                end--;
                continue;
            }
            // 左边有障碍上面空就往上走
            if(visit[start][end-1] == 1 && visit[start-1][end] == 0) {
                start--;
                continue;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][3];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9, 10, 11, 12};
        matrix[3] = new int[]{13, 14, 15, 16};
        int[] result = new Solution().spiralOrder(matrix);
        for(int i = 0; i < result.length; ++i) {
            System.out.print(result[i] + "  ");
        }
    }
}
