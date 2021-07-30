package leetcode;
/*
 * @url
 * @name
 * @author sunbowen
 * @date 2021年07月20日 16:32
 */

public class Solution {
    public int[] constructArr(int[] a) {
        int n = a.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; ++i) {
            for(int j = i; j < n; ++j) {
                if (i == j) {
                    dp[i][j] = a[i];
                } else {
                    dp[i][j] = dp[i][j - 1] * a[j];
                }
            }
        }

        int[] answer = new int[n];
        for(int i = 0; i < n; ++i) {
            if (i == 0) {
                answer[i] = dp[1][n - 1];
            } else if (i == n - 1) {
                answer[i] = dp[0][n - 2];
            } else {
                answer[i] = dp[0][i - 1] * dp[i + 1][n - 1];
            }
        }

        return answer;
    }
}
