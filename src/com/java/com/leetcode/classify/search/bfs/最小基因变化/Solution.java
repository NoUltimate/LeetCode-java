package com.java.com.leetcode.classify.search.bfs.最小基因变化;

import java.util.*;

/**
 * @author sunbowen
 * @date 2021年02月05日 09:18
 */

public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        char[] cover = new char[] {'A', 'C', 'G', 'T'};
        queue.add(start);
        Map<String, Boolean> dup = new HashMap<>();
        for(String b : bank) {
            dup.put(b, true);
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int n = queue.size();
            for(int i = 0; i < n; ++i) {
                String gen = queue.poll();
                for(int j = 0; j < gen.length(); ++j) {
                    char[] temp = gen.toCharArray();
                    for(int k = 0; k < cover.length; ++k) {
                        if (temp[j] != cover[k]) {
                            temp[j] = cover[k];
                            String str = String.valueOf(temp);
                            if (dup.containsKey(str)) {
                                if (str.equals(end)) {
                                    return depth;
                                }
                                queue.add(str);
                                dup.remove(str);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
    }
}