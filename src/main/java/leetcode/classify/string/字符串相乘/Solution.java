package leetcode.classify.string.字符串相乘;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月14日 11:04
 */

public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int[] mul = new int[n1 + n2 + 2];
        for(int i = n1; i >= 0; --i) {
            for(int j = n2; j >= 0; --j) {
                int bitmul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                bitmul += mul[i+j+1];
                mul[i + j] += bitmul / 10;
                mul[i + j + 1] = bitmul % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 去掉前导0
        while(i < mul.length-1 && mul[i] == 0)
            i++;
        for(; i < mul.length; ++i)
            sb.append(mul[i]);
        return sb.toString();
    }
}
