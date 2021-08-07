package leetcode;
/*
 * @url
 * @name
 * @author sunbowen
 * @date 2021年07月20日 16:32
 */

import util.ListNode;

import java.util.Random;

public class Solution {
    int result = 0;
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k);
        return result;
    }

    public void quickSort(int[] nums, int start, int end, int k) {
        // 随机化取标准值，防止极端变量
        if (end > start) {
            int randomIndex = start + new Random().nextInt(end - start) + 1;
            int temp = nums[start];
            nums[start] = nums[randomIndex];
            nums[randomIndex] = temp;
        }
        int value = nums[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && nums[j] >= value) j--;
            nums[i] = nums[j];
            while (i < j && nums[i] <= value) i++;
            nums[j] = nums[i];
        }
        nums[i] = value;
        if (nums.length - i == k) {
            result = nums[i];
            return;
        }
        if (nums.length - i > k) quickSort(nums, i + 1, end, k);
        else quickSort(nums, start, i - 1, k);
    }
}

