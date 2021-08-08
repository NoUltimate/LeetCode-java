package leetcode.classify.array.最长连续序列;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int max = 0;
        for(int num : nums) {
            if (!m.containsKey(num)) {
                int left = m.getOrDefault(num - 1, 0);
                int right = m.getOrDefault(num + 1, 0);
                int sum = left + 1 + right;
                max = Math.max(max, sum);
                m.put(num, 1);
                m.put(num - left, sum);
                m.put(num + right, sum);
            }
        }
        return max;
    }
}
