package com.java.com.leetcode.tag.二分查找.输入有序数组;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1, index2;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; ++i) {
            m.put(numbers[i], i+1);
        }
        for(int i = 0; i < numbers.length; ++i) {
            if (numbers[i] <= target) {
                int value = target - numbers[i];
                if (m.containsKey(value)) {
                    index1 = Math.min(i+1, m.get(value));
                    index2 = Math.max(i+1, m.get(value));
                    return new int[]{index1, index2};
                }
            }
        }
        return null;
    }
}