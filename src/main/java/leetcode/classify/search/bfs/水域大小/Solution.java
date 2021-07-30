package leetcode.classify.search.bfs.水域大小;
/*
 *
 *
 * @author sunbowen
 * @date 2021年03月26日 09:08
 */

import java.util.*;

public class Solution {
    public int[] pondSizes(int[][] land) {
        List<Integer> size = new ArrayList<>();
        for(int i = 0; i < land.length; ++i) {
            for(int j = 0; j < land[0].length; ++j) {
                if (land[i][j] == 0) {
                    size.add(bfs(land, i, j ));
                }
            }
        }
        Collections.sort(size);
        return size.stream().mapToInt(Integer::intValue).toArray();
    }

    public int bfs(int[][] land, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        land[x][y] = -1;
        int count = 1;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for(int i = 0; i < direction.length; ++i) {
                int newx = point[0] + direction[i][0];
                int newy = point[1] + direction[i][1];
                if (newx >= 0 && newx < land.length && newy >= 0 && newy < land[0].length && land[newx][newy] == 0) {
                    queue.add(new int[]{newx, newy});
                    land[newx][newy] = -1;
                    count++;
                }
            }
        }
        return count;
    }
}
