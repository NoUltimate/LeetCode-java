package leetcode.classify.search.bfs.被围绕的区域;
/*
 *
 *
 * @author sunbowen
 * @date 2021年03月24日 09:56
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] visit = new int[m][n];
        int[][] direction = new int[][] {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if (i == 0 || i == m-1 || j == 0 || j == n-1) {
                    if (board[i][j] == 'O') {
                        queue.add(new int[]{i, j});
                        visit[i][j] = 1;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for(int i = 0; i < direction.length; ++i) {
                int x1 = x + direction[i][0];
                int y1 = y + direction[i][1];
                if (x1 >= 0 && x1 < m && y1 >=0 && y1 < n && visit[x1][y1] == 0 && board[x1][y1] == 'O') {
                    queue.add(new int[]{x1, y1});
                    visit[x1][y1] = 1;
                }
            }
        }

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if (visit[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for(int i = 0; i < m; ++i) {
            String s = "";
            for(int j = 0; j < n; ++j) {
                s += board[i][j] + " ";
            }
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        new Solution().solve(board);
    }
}
