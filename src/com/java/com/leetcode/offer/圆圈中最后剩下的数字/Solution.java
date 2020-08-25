package com.java.com.leetcode.offer.圆圈中最后剩下的数字;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zjmiit
 */

public class Solution {
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    // 获取长度为n的序列，不停删除第m个数后剩下的那个数字在当前序列的位置序号
    public int f(int n, int m) {
        // 最后只有一个包含一个数字的序列，所在位置肯定为0
        if (n == 1) {
            return 0;
        }
        int x = f(n-1, m);
        return (m%n+x)%n;
    }

}
