package leetcode.classify.sort.选择排序;
/*
 *每一轮选取未排定的部分中最小的部分交换到未排定部分的最开头，经过若干个步骤，就能排定整个数组。即：先选出最小的，再选出第 2 小的，以此类推。
 *
 * @author sunbowen
 * @date 2021年05月19日 10:37
 */

public class Solution {
    public int[] sortArray(int[] nums) {
        for(int i = 0; i < nums.length - 1; ++i) {
            int pos = i;
            for(int j = i + 1; j < nums.length; ++j) {
                if (nums[j] < nums[pos]) {
                    pos = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[pos];
            nums[pos] = temp;
        }
        return nums;
    }
}
