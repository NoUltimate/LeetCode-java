package leetcode.classify.search.dfs.岛屿数量;
/*
 * https://leetcode-cn.com/problems/number-of-islands/
 *
 * @author sunbowen
 * @date 2021年07月02日 09:34
 */

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    dfs(visit, grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(boolean[][] visit, char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visit[x][y] || grid[x][y] == '0') {
            return ;
        }
        visit[x][y] = true;
        dfs(visit, grid, x + 1, y);
        dfs(visit, grid, x - 1, y);
        dfs(visit, grid, x, y + 1);
        dfs(visit, grid, x , y - 1);
    }
}
