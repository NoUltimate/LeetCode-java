package leetcode.classify.tree.二叉搜索树的后序遍历序列;
/*
 *
 *
 * @author sunbowen
 * @date 2021年05月13日 09:51
 */

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        // m的位置是第一个比根节点大的位置，说明左边全部都是比根节点小的，但是右边不一定，而p == j说明右边都比根节点大
        return p == j &&  recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
