package com.java.com.leetcode.classify.sort.归并排序;
/*
 * 借助额外空间，合并两个有序数组，得到更长的有序数组
 *
 * @author sunbowen
 * @date 2021年05月19日 13:44
 */

class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    public void sort(int[] nums, int start, int end, int[] temp) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            sort(nums, start, mid, temp);
            sort(nums, mid + 1, end, temp);
            merge(nums, start, mid, end, temp);
        }
    }

    public void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int i = start;
        int j = mid + 1;
        int k  = start;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for(int m = start; m <= end; ++m) {
            nums[m] = temp[m];
        }
    }
}
