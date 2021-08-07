package leetcode.classify.search.array.搜索旋转排序数组;
/*
 *
 *
 * @author sunbowen
 * @date 2021年08月04日 13:46
 */

import util.ListNode;

import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) /2;
            if (nums[mid] == target) return mid;
            if (nums[mid] >= nums[i]) {
                // 说明在左边递增的部分
                if (nums[mid] > target && target >= nums[i]) {
                    j = mid - 1;
                } else i = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[j]) {
                    i = mid + 1;
                } else j = mid - 1;
            }
        }
        return -1;
    }
}
