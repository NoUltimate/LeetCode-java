# bfs(广度搜索

回溯就是有规律的遍历，改变状态，然后再该回来状态(回溯)

**模版** 参数：队列，将初始状态塞入队列

```java
public class Solution {

    public int maxDistance(int[][] grid) {
        // 格子问题往往有四个方向
        int[][] direcs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // int[0] 坐标x  int[1]  坐标y
        int len = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visit = new int[len][len];
        for(int i = 0; i < len; ++i) {
            for(int j = 0; j < len; ++j) {
                // 将所有初始节点放入队列，从陆地节点开始往外一层层扩散
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
            // 循环是因为需要统计结果depth，不需要的话可以不循环，一次次取
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
```