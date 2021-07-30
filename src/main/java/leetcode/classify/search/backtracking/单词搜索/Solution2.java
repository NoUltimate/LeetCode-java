package leetcode.classify.search.backtracking.单词搜索;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 单词搜索 II
 * https://leetcode-cn.com/problems/word-search-ii/
 * Created by sunbowen on 2021/1/28
 */
public class Solution2 {
    class Node {
        String word;
        Node[] children = new Node[26];
    }

    // 构造前缀树
    public Node buildTree(String[] words) {
        Node root = new Node();
        for(String word : words) {
            Node p = root;
            for(char c : word.toCharArray()) {
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new Node();
                }
                p = p.children[c - 'a'];
            }
            p.word = word;
        }
        return root;
    }

    public void backTracking(char[][] board, int row, int col, Node node, List<String> ans) {
        if( row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return ;
        }
        char c = board[row][col];
        if (c == '#' || node.children[c - 'a'] == null) return ;
        node = node.children[c - 'a'];
        if (node.word != null) {
            ans.add(node.word);
            // 防止重复
            node.word = null;
        }
        board[row][col] = '#';
        backTracking(board, row + 1, col, node, ans);
        backTracking(board, row - 1, col, node, ans);
        backTracking(board, row , col + 1, node, ans);
        backTracking(board, row, col - 1, node, ans);
        board[row][col] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        Node node = buildTree(words);
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                backTracking(board, i, j, node, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain","oathi","oathk","oathf","oate","oathii","oathfi","oathfii"};
        System.out.println(JSONObject.toJSONString(new Solution2().findWords(board, words)));
    }
}
