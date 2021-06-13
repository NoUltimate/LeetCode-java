package com.java.com.leetcode.classify.search.bfs.地图分析;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 * @author noultimate
 * @date 2021年02月03日 08:59
 */

public class Solution {

    public int maxDistance(int[][] grid) {
        int[][] direcs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int[0] 坐标x  int[1]  坐标y
        int len = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visit = new int[len][len];
        for(int i = 0; i < len; ++i) {
            for(int j = 0; j < len; ++j) {
                // 将所有陆地节点放入队列，从陆地节点开始往外一层层扩散
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        if (queue.size() == 0 || queue.size() == len * len) {
            return -1;
        }

        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            // 每次将每层的所有节点遍历并扩散
            int n = queue.size();
            for(int i = 0; i < n; ++i) {
                int[] point = queue.poll();
                for(int[] direc : direcs) {
                    int x = point[0] + direc[0];
                    int y = point[1] + direc[1];
                    if (x < 0 || x >= len || y < 0 || y >= len || visit[x][y] == 1 || grid[x][y] == 1) {
                        continue;
                    }
                    // 加入队列就说明已经扩散到了，已经访问，固visit[x][y]=1
                    visit[x][y] = 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        // 最后一层结束后还会再进入一次循环， depth还会加1，所以要减掉
        return depth - 1;
    }
}



