package com.java.com.leetcode.tag.二分查找.寻找重复数;

public class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high-low)/2;
            int count = 0;
            for(int i = 0; i < nums.length; ++i) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            if(count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
