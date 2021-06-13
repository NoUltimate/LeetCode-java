package com.java.com.leetcode.classify.search.bfs.岛屿的最大面积;
/*
 *
 *
 * @author sunbowen
 * @date 2021年03月24日 14:22
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int classify = 0;
        int[] result = new int[m * n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    bfs(i, j, classify, result, grid);
                    classify++;
                }
            }
        }
        int max = 0;
        for(int i = 0; i < result.length; ++i) {
            max = Math.max(max, result[i]);
        }
        return max;
    }

    public void bfs(int x, int y, int classify, int[] result, int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        queue.add(new int[]{x, y});
        grid[x][y] = 2;
        result[classify]++;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for(int i = 0; i < direction.length; ++i) {
                int newx = point[0] + direction[i][0];
                int newy = point[1] + direction[i][1];
                if (newx >= 0 && newx < grid.length && newy >= 0 && newy < grid[0].length &&  grid[newx][newy] == 1) {
                    queue.add(new int[]{newx, newy});
                    grid[newx][newy] = 2;
                    result[classify]++;
                }
            }
        }
    }
}
