package leetcode.classify.string.把数字翻译成字符串;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月21日 13:51
 */

public class Solution {
    int count = 0;

    public int translateNum(int num) {
        dfs(String.valueOf(num), 0, 0);
        return count;
    }

    public void dfs(String num, int len, int pos) {
        if (pos > num.length() - 1) {
            count++;
            return;
        }
        int num1 = num.charAt(pos) - '0';
        if (num1 <= 2 && num1 > 0) {
            if (pos + 1 < num.length()) {
                int num2 = num.charAt(pos + 1) - '0';
                if (num2 + num1 * 10 <= 25) {
                    dfs(num, len + 2, pos + 2);
                }
            }
        }
        dfs(num, len + 1, pos + 1);
    }
}
