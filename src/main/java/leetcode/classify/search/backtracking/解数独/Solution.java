package leetcode.classify.search.backtracking.解数独;

/**
 * Title: 解数独
 * Desc: 
 * https://leetcode-cn.com/problems/sudoku-solver/submissions/
 * Created by sunbowen on 2021/1/25
 */
class Solution {
    // 利用二维和三维数组来判断要加入的数字是否已经用过
    public void solveSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] rowUsed = new boolean[m][10];
        boolean[][] colUsed = new  boolean[m][10];
        boolean[][][] boxUsed = new boolean[m][n][10];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rowUsed[i][num] = true;
                    colUsed[j][num] = true;
                    boxUsed[i/3][j/3][num] = true;
                }
            }
        }

        dfs(board, 0, 0, rowUsed, colUsed, boxUsed);
    }

    // 通过返回的boolean来进行停止
    public boolean dfs(char[][] board, int row, int col, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed) {
        if (col == board[0].length) {
            row++;
            col = 0;
            if (row == board.length) {
                return true;
            }
        }
        if (board[row][col] == '.') {
            for(int i = 1; i <= 9; ++i) {
                if (rowUsed[row][i] || colUsed[col][i] || boxUsed[row/3][col/3][i]) {
                    continue;
                }
                rowUsed[row][i] = true;
                colUsed[col][i] = true;
                boxUsed[row/3][col/3][i] = true;
                board[row][col] = (char)('0' + i);
                if (dfs(board, row, col + 1, rowUsed, colUsed, boxUsed)) {
                    return true;
                }
                board[row][col] = '.';
                rowUsed[row][i] = false;
                colUsed[col][i] = false;
                boxUsed[row/3][col/3][i] = false;
            }
        } else {
            return dfs(board, row, col + 1, rowUsed, colUsed, boxUsed);
        }
        return false;
    }
}