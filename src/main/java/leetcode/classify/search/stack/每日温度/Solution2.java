package leetcode.classify.search.stack.每日温度;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月02日 10:44
 */

import java.util.Stack;

public class Solution2 {
    /**
     * 相当于每次放入栈之前，将该要放入数字之前的所有小于其值的数字进行距离计算，计算完成后抛出，将新的值放入
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        if (temperatures.length == 0) {
            return new int[]{};
        }
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; ++i) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
