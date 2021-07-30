package leetcode.classify.search.stack.每日温度;
/*
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * @author sunbowen
 * @date 2021年07月02日 10:06
 */

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 0) {
            return new int[]{};
        }
        int[] result = new int[temperatures.length];
        result[temperatures.length - 1] = 0;
        for(int i = temperatures.length - 2; i >= 0; --i) {
            for(int j = i + 1; j < temperatures.length; j += result[j]) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) {
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }
}
