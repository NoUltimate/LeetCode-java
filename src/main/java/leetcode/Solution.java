package leetcode;
/*
 * @url
 * @name
 * @author sunbowen
 * @date 2021年07月20日 16:32
 */

import java.util.*;

class Solution {

    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 1, sum = 1;
        List<int[]> list = new ArrayList<>();
        while (true) {
            if (j - i + 1 == 2 && i + j > target) break;
            if (sum < target) {
                j++;
                sum += j;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] temp = new int[j - i + 1];
                int index = 0;
                for(int k = i; k <= j; ++k) temp[index++] = k;
                list.add(temp);
            }
        }
        int[][] result = new int[list.size()][];
        for(int k = 0; k < list.size(); ++k) result[k] = list.get(k);
        return result;
    }

}
