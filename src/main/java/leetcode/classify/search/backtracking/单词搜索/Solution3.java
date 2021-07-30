package leetcode.classify.search.backtracking.单词搜索;

/**
 * Title: 单词搜索
 * Desc:
 *
 * Created by sunbowen on 2021/1/28
 */
public class Solution3 {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, 0, word, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int pos, String word, int row , int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '.' || pos > word.length() - 1) {
            return false;
        }
        if (board[row][col] == word.charAt(pos)) {
            if (pos == word.length() - 1) {
                return true;
            }
            board[row][col] = '.';
            boolean result = dfs(board, pos + 1, word, row + 1, col) || dfs(board, pos + 1, word, row - 1, col) ||
                    dfs(board, pos + 1, word, row, col + 1) || dfs(board, pos + 1, word, row, col - 1);
            board[row][col] = word.charAt(pos);
            return result;
        } else {
            return false;
        }
    }
}
