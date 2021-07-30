package leetcode.classify.search.backtracking.单词搜索;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<String, Boolean> map = new HashMap<>();
    private List<String> wordList = new ArrayList<>();;
    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0) {
            return wordList;
        }
        Map<Character, Boolean> startMap = new HashMap<>();
        for(String word : words) {
            map.put(word, true);
            startMap.put(word.charAt(0), true);
        }
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(startMap.containsKey(board[i][j])) {
                    backTracking(board, new int[board.length][board[0].length], "", i, j);
                }
            }
        }
        return wordList;
    }

    public void backTracking(char[][] board, int[][] visit, String word, int row, int col) {
        if (map.containsKey(word)) {
            wordList.add(word);
            map.remove(word);
        }
        if( row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return ;
        }
        if (visit[row][col] == 1) return ;
        visit[row][col] = 1;
        backTracking(board, visit, word + board[row][col], row + 1, col);
        backTracking(board, visit, word + board[row][col], row - 1, col);
        backTracking(board, visit, word + board[row][col], row , col + 1);
        backTracking(board, visit, word + board[row][col], row, col - 1);
        visit[row][col] = 0;
    }
}
