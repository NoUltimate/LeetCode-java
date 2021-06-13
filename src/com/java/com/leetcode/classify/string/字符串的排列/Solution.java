package com.java.com.leetcode.classify.string.字符串的排列;
/*
 *
 * https://leetcode-cn.com/problems/permutation-in-string/
 * @author sunbowen
 * @date 2021年05月21日 09:24
 */

import java.util.Arrays;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0; i < s1.length(); ++i) {
           count1[s1.charAt(i) - 'a'] ++;
        }

        // left，right是滑动窗口的左右边界
        int left = 0;
        int right = s1.length() - 1;
        // 先初始化到right-1， 循环的时候就可以从right位置开始
        for(int i = left; i < right; ++i) {
            count2[s2.charAt(i) - 'a']++;
        }
        while (right < s2.length()) {
            count2[s2.charAt(right) - 'a']++;
            if (Arrays.equals(count1, count2)) {
                return true;
            }
            right++;
            count2[s2.charAt(left) - 'a']--;
            left++;
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().checkInclusion("ab", "eidbaooo");
    }
}
