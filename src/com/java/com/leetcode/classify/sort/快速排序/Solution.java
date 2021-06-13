package com.java.com.leetcode.classify.sort.快速排序;
/*
 * 快速排序每一次都排定一个元素（这个元素呆在了它最终应该呆的位置），然后递归地去排它左边的部分和右边的部分，依次进行下去，直到数组有序；
 *
 * @author sunbowen
 * @date 2021年05月19日 15:45
 */

import com.alibaba.fastjson.JSONObject;

public class Solution {
    public int[] sortArray(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    public void qsort(int[] nums, int left, int right) {
        if (left < right) {
            int r = right;
            int l = left;
            int key = nums[l];
            while (l < r) {
                while (l < r && nums[r] >= key) {
                    r--;
                }
                if (l < r) {
                    nums[l++] = nums[r];
                }
                while (l < r && nums[l] < key) {
                    l++;
                }
                if (l < r) {
                    nums[r--] = nums[l];
                }
            }
            nums[l] = key;

            qsort(nums, left, l - 1);
            qsort(nums, l + 1, right);
        }
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new Solution().sortArray(new int[] {5, 1, 1, 2, 0, 0})));
    }
}
