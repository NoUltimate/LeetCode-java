package leetcode.classify.array.描述绘画结果;
/*
 * 1943. 描述绘画结果
 * https://leetcode-cn.com/problems/describe-the-painting/
 * 差分数组
 * @author sunbowen
 * @date 2021年07月29日 14:53
 */

import java.util.*;

public class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        Set<List<Long>> result = new HashSet<>();
        long[][] diff = new long[100001][2];
        for(int[] segment : segments) {
            diff[segment[0]][0] += segment[2];
            diff[segment[1]][1] -= segment[2];
        }
        long[] sum = new long[100001];
        long start = 0;
        for(int i = 1; i < sum.length; ++i) {
            sum[i] = sum[i - 1];
            if (diff[i][0] != 0 || diff[i][1] != 0) {
                if (sum[i] != 0 && start != 0) {
                    result.add(Arrays.asList(start, (long)i, sum[i]));
                }
                start = i;
                sum[i] += diff[i][0] + diff[i][1];
            }
        }
        return new ArrayList<>(result);
    }
}
