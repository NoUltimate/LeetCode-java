package leetcode.classify.search.backtracking.N皇后;

import java.util.*;

/**
 * Title: N 皇后
 * Desc: 
 * https://leetcode-cn.com/problems/n-queens/submissions/
 * Created by sunbowen on 2021/1/26
 */
class Solution {
    Set<List<String>> set = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; ++i) {
            Arrays.fill(board[i], '.');
        }
        dfs(board, 0, n);
        return new ArrayList<>(set);
    }

    public void dfs(char[][] board, int row, int n) {

        if (n == row) {
            List<String> answer = new ArrayList<>();
            for(char[] arr : board) {
                StringBuilder s = new StringBuilder();
                for(char c : arr) {
                    s.append(c);
                }
                answer.add(s.toString());
            }
            set.add(answer);
            return ;
        }


        for(int i = 0; i < n; ++i) {
            if (valid(board, row, i)) {
                board[row][i] = 'Q';
                dfs(board, row + 1, n);
                board[row][i] = '.';
            }
        }
    }

    public boolean valid(char[][] board, int row, int col) {
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'Q') {
                    if (row == i || col == j || Math.abs(row-i) == Math.abs(col -j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(5).size());
    }
}
