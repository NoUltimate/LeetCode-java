package com.java.com.leetcode.classify.string.反转每对括号间的子串;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月01日 10:33
 */

import java.util.Stack;

public class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ')') {
                String word = "";
                while (!stack.isEmpty()) {
                    Character c = stack.pop();
                    if (c == '(') {
                        break;
                    } else {
                        word += c;
                    }
                }
                for(int j = 0; j < word.length(); ++j) {
                    stack.push(word.charAt(j));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
