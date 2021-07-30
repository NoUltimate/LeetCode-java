package leetcode.classify.search.array.二分查找;
/*
 *
 *
 * @author sunbowen
 * @date 2021年05月28日 14:46
 */

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int pos = left + (right - left)/2;
            if (nums[pos] == target) {
                return pos;
            }
            if (nums[pos] > target) {
                left = pos;
            }
            if (nums[pos] < target) {
                right = pos;
            }
        }
        return -1;
    }
}
