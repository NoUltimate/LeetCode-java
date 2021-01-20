package com.java.com.leetcode.company.bytedance.黑白方格画;

public class Solution {
    public int paintingPlan(int n, int k) {
        // 处理特殊情况
        if (k == 0 || n*n == k) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int count = 0;
        int nFactorial = factorial(n);

        for(int i = 1; i < n; ++i) {
            // i为取几行， 取完后剩下（k-n*i）个格子， （n-i）是每涂一列可以涂上的格子数量
            if ((k-n*i) < 0) {
                break;
            }
            // 只涂行或列
            if ((k-n*i) == 0) {
                int col = k/n;
                count += (nFactorial/(factorial(col)*factorial(n-col)))*2;
                continue;
            }
            // 行和列都涂
            if ((k-n*i)%(n-i) == 0) {
                int row = i;
                int col = (k-n*i)/(n-i);
                // 计算组合数量
                int rowCount = nFactorial/(factorial(col)*factorial(n-col));
                int colCount = nFactorial/(factorial(row)*factorial(n-row));
                count += rowCount*colCount;
            }
        }
        return count;
    }

    // 计算阶乘
    public int factorial(int number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().paintingPlan(5, 20));
    }
}
