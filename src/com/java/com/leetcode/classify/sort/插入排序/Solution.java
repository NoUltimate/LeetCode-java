package com.java.com.leetcode.classify.sort.插入排序;
/*
 * 每次将一个数字插入一个有序的数组里，成为一个长度更长的有序数组，有限次操作以后，数组整体有序。
 *
 * @author sunbowen
 * @date 2021年05月19日 10:51
 */

public class Solution {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for(int i = 1; i < nums.length; ++i) {
            int j = i;
            int temp = nums[i];
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
