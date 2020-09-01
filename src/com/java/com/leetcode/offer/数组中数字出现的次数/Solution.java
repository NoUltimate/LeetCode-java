package com.java.com.leetcode.offer.数组中数字出现的次数;

class Solution {
    public int[] singleNumbers(int[] nums) {
        int ret = 0, index = 0;
        // 所有数字的异或等于两个没有相同数字的异或
        for(int num : nums) {
            ret ^= num;
        }

        // 找到为最低位置且值为1的位置
        while ((ret&1) == 0) {
            index++;
            ret >>= 1;
        }

        int num1 = 0, num2 = 0;
        for(int num : nums) {
            // num >> index 都右移index位通过该位是不是1来分组
            if( ((num >> index) & 1) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }
}
