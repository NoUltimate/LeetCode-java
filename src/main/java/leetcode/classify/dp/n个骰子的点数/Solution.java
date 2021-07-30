package leetcode.classify.dp.n个骰子的点数;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月30日 09:55
 */

public class Solution {
    public double[] dicesProbability(int n) {
        double all = Math.pow(6, n);
        int[][] dp = new int[n + 1][6 * n + 1];
        double[] answer = new double[5 * n + 1];
        for(int i = 1; i <= 6; ++i) dp[1][i] = 1;
        for(int i = 1; i <= n; ++i) {
            for(int j = i; j <= 6 * n; ++j) {
                for(int k = 1; k <= 6; ++k) {
                    dp[i][j] += j >= k ? dp[i-1][j-k] : 0;
                }
                if (i == n) {
                    // 可以理解为n个骰子，至少有n个1，那么在这个基础上，我可以+0，+1，+2...+5n(共5*n+1)等等，比如j-i=1，说明我除了n个1以外还有值为1的点数可以分配，他可以分配到n个骰子中的任意一个上，但是分配在哪总和的值都是一样的
                    answer[j - i] = dp[i][j]/all;
                }
            }
        }
        return answer;
    }
}
