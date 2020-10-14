package com.java.com.leetcode.tag.二分查找.最长重复子数组;

/**
 * @author sunbowen
 * @date 2020/10/9 11:27
 * @time O((m+n)*min(m,n))
 * @space O(1)
 */

public class Solution2 {
    public int findLength(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int max = 0;
        for(int i = 0; i < len1; ++i) {
            int len = Math.min(len2, len1-i);
            max = Math.max(max, countMaxDup(A, B, i, 0, len));
        }

        for(int i = 0; i < len2; ++i) {
            int len = Math.min(len1, len2-i);
            max = Math.max(max, countMaxDup(A, B, 0, i, len));
        }
        return max;
    }

    public int countMaxDup(int[] A, int[] B, int addA, int addB, int len) {
        int k = 0;
        int max = 0;
        for(int i = 0; i < len; ++i) {
            System.out.println("i:" + i + " a:" + A[addA + i] + " b:" + B[addB+i]);
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            max = Math.max(max, k);
        }
        return max;
    }

    public static void main(String[] args) {
        int A[] = new int[]{1, 1, 0, 0, 1};
        int B[] = new int[]{1, 1, 0, 0, 0};
        new Solution2().findLength(A, B);
    }
}
