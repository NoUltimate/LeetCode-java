package leetcode.classify.bit.数组中数字出现的次数;
/*
 * 剑指 Offer 59 - II. 队列的最大值
 * https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * @author sunbowen
 * @date 2021年08月02日 09:54
 */

public class Solution {
    public int singleNumber(int[] nums) {
        int[] array = new int[32];
        for(int num : nums) {
            for(int i = 0; i < 32; ++i) {
                // num >> i代表右移了i位，此时的二进制数字的最后一位就是我们需要的数字
                // 接着我们将这个数字和i进行与操作，这样就得到了最后一位，其他位和1进行与操作都会变成0
                array[i] += num >> i & 1;
            }
        }

        // 如果次数为1的数字转化为二进制的时候该位置是1那么这个位置对应的array[i]肯定不能整除3
        int result = 0;
        for(int i = 31; i >=0; --i) {
            result <<= 1;
            if (array[i] % 3 == 1) {
                result |= 1;
            }
        }
        return result;
    }
}
