package leetcode.classify.array.构建乘积数组;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月30日 13:50
 */

public class Solution {
    public int[] constructArr(int[] a) {
        int sum = 1;
        int[] b = new int[a.length];
        for(int i = 0; i < a.length; ++i) {
            b[i] = sum;
            sum *= a[i];
        }
        sum = 1;
        for(int i = a.length - 1; i >= 0; --i) {
            b[i] *= sum;
            sum *= a[i];
        }
        return b;
    }
}
