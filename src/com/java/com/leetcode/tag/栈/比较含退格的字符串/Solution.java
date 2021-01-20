package com.java.com.leetcode.tag.栈.比较含退格的字符串;

import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<Character>();
        Stack<Character> t = new Stack<Character>();
        for(int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '#') {
                if (!s.empty()) {
                    s.pop();
                }
            } else {
                s.push(S.charAt(i));
            }
        }

        for(int i = 0; i < T.length(); ++i) {
            if (T.charAt(i) == '#') {
                if (!t.empty()) {
                    t.pop();
                }
            } else {
                t.push(T.charAt(i));
            }
        }

        if (s.size() == t.size()) {
            while (!s.empty()) {
                if (s.pop() != t.pop()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
