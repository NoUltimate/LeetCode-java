package leetcode.classify.array.最长连续序列;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int max = 0;
        for(int i = 0; i < nums.length; ++i) {
            if (!set.contains(nums[i] - 1)) {
                int count = 1;
                int num = nums[i] + 1;
                while (set.contains(num)) {
                    num++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
