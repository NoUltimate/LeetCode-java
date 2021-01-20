package com.java.com.leetcode.company.bytedance.早餐组合;

import java.util.*;

public class Solution {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int ans = 0;
        int j = staple.length-1;
        int i = 0;
        while (j >= 0 && i < drinks.length) {
            if (drinks[i] + staple[j] > x) {
                j--;
            } else {
                ans += j + 1;
                ans %= 1000000007;
                i++;
            }
        }
        return ans;
    }
}


