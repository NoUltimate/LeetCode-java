package com.java.com.leetcode.tag.动态规划.分割回文串;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        Deque<String> path = new ArrayDeque<String>();
        List<List<String>> result = new ArrayList<List<String>>();
        if (s.length() == 0) {
            return result;
        }
//        search(s, 0, s.length(), path, result);
        advanceSearch(s, 0, s.length(), cal(s), path, result);
        return result;
    }

    // 从位置0开始，每次截取后，开头位置后移
    public void search(String s, int start, int len, Deque<String> path, List<List<String>> result) {
        if (start == len) {
            result.add(new ArrayList<String>(path));
            return ;
        }
        for(int i = 0; i < len; ++i) {
            if (!check(s, start, i)) {
                continue;
            }
            path.add(s.substring(start, i+1));
            search(s, i+1, len, path, result);
            path.removeLast();
        }
    }

    // 时间复杂度O(n)， 可以先用动态规划计算好
    public boolean check(String s, int start, int end) {
        int left = start;
        int right = end;
        while(left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public void advanceSearch(String s, int start, int len, Boolean[][] dp, Deque<String> path, List<List<String>> result) {
        if (start == len) {
            result.add(new ArrayList<String>(path));
            return ;
        }
        for(int i = start; i < len; ++i) {
            if (!dp[start][i]) {
                continue;
            }
            path.add(s.substring(start, i+1));
            advanceSearch(s, i+1, len, dp, path, result);
            path.removeLast();
        }
    }

    public Boolean[][] cal(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); ++i) {
            for(int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) && ((i - j) <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                } else {
                    dp[j][i] = false;
                }
            }
        }
        return dp;
    }
}
