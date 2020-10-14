package com.java.com.leetcode.tag.二分查找.输入有序数组;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0;
        int j = n-1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i+1, j+1};
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
