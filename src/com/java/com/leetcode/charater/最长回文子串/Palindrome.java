package com.java.com.leetcode.charater.最长回文子串;


/**
 * @author bowensun
 *
 */
public class Palindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int begin = 0;
        int max = 1;
        boolean[][] b = new boolean[len][len];

        //一个字符都是回文
        for(int i = 0; i < len; ++i) {
            b[i][i] = true;
        }

        for(int j = 1; j < len; ++j) {
            for(int i = 0; i < j; ++i) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j-i < 3){
                        b[i][j] = true;
                    } else {
                        b[i][j] = b[i+1][j-1];
                    }
                } else {
                    b[i][j] = false;
                }

                if (b[i][j]) {
                    if (j-i+1 > max) {
                        max = j-i+1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + max);
    }

    public static void main(String[] args) {
        System.out.println(new Palindrome().longestPalindrome("abcba"));
    }
}
