package com.java.com.leetcode.offer.数组中的逆序对;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int num = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return num;
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public void merge(int[] arr, int start, int mid, int end) {
        // 合并两个已经从小到大排好序的数组，每次将最小的先放进来
        int len = 0;
        int[] result = new int[end - start + 1];
        int i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                num += mid - i + 1;
                result[len++] = arr[j++];
            } else {
                result[len++] = arr[i++];
            }
        }

        // 一边取完的时候另一边可能还没取完
        while (i <= mid) {
            result[len++] = arr[i++];
        }

        while (j <= end) {
            result[len++] = arr[j++];
        }

        for (int k = 0; k < result.length; ++k) {
            arr[start + k] = result[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 3, 1};
        Solution solution = new Solution();
       solution.mergeSort(arr, 0, 4);
        System.out.println(solution.num);
    }
}