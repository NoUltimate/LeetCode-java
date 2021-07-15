package com.java.com.leetcode.classify.string.单词的压缩编码;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月12日 13:55
 */

import java.util.Arrays;

public class Solution {

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }
        public boolean insert(String s) {
            TrieNode cur = root;
            boolean isNew = false;
            for(int i = s.length() - 1; i >= 0; --i) {
                int pos = s.charAt(i) - 'a';
                TrieNode node = cur.children[pos];
                if (node == null) {
                    isNew = true;
                    node = new TrieNode(s.charAt(i));
                }
                cur = cur.children[pos];
            }
            return isNew;
        }
    }

    public static class TrieNode {
        char val;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {}

        public TrieNode(char val) {
            this.val = val;
        }
    }


    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        Trie trie = new Trie();
        int count = 0;
        for(String str : words) {
            boolean isNew = trie.insert(str);
            if (isNew) {
                count += str.length() + 1;
            }
        }
        return count;
    }
}


