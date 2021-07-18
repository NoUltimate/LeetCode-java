package com.java.com.leetcode.classify.queue.滑动窗口的最大值;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * @author sunbowen
 * @date 2021年06月25日 15:16
 */

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        // 从i到j之间的最大值
        Deque<Integer> queue = new ArrayDeque<>();

        for(int right = 0; right < nums.length; ++right) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(right);
            int left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }

            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

}
