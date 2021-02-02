package com.java.com.leetcode.classify.search.backtracking.实现前缀树;

import java.util.Arrays;

class Trie {
    private Trie[] children = new Trie[26];
    private Boolean exist = false;

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for(char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Trie();
            }
            node = node.children[c - 'a'];
        }
        node.exist = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for(char c : word.toCharArray()) {
            if (node.children[c - 'a'] != null) {
                node = node.children[c - 'a'];
            } else {
                return false;
            }
        }
        return node.exist;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for(char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] != null) {
                node = node.children[c - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie node = new Trie();
        node.insert("aaaa");
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */