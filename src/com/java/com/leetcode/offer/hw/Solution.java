package com.java.com.leetcode.offer.hw;
/*
 *
 *
 * @author sunbowen
 * @date 2021年06月25日 15:16
 */

import util.ListNode;

import java.math.BigDecimal;
import java.util.*;

public class Solution {

    public boolean canJump(int[] nums) {
        // 从位置i开始能到达的最远位置
        if (nums.length == 0) {
            return false;
        }
        int energy = nums[0];
        int i = 1;
        while (energy != 0 && i < nums.length) {
            energy--;
            if (energy < nums[i]) {
                energy = nums[i];
            }
            ++i;
        }
        return i == nums.length;
    }
}
