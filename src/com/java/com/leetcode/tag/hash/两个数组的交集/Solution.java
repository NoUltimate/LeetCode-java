package com.java.com.leetcode.tag.hash.两个数组的交集;

import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> dup = new HashMap<Integer, Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums1) {
            dup.put(num, 1);
        }

        for(int num : nums2) {
            if (dup.containsKey(num)) {
                set.add(num);
            }
        }

        int[] result = new int[set.size()];
        int index = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            result[index] = iterator.next();
            index++;
        }

        return result;
    }
}
