package leetcode.classify.dp.面试题括号;
/*
 *
 *
 * @author sunbowen
 * @date 2021年08月03日 11:26
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n)  {
        List<List<String>> l = new ArrayList<>();
        l.add(new ArrayList<String>(){{
            add("");
        }});
        l.add(new ArrayList<String>(){{
            add("()");
        }});
        // 加入第i对括号
        for(int i = 2; i <= n; ++i) {
            List<String> newList = new ArrayList<>();
            for(int j = 0; j < i; ++j) {
                List<String> l1 = l.get(j);
                List<String> l2 = l.get(i - j - 1);
                for(String str1 : l1) {
                    for(String str2 : l2) {
                        newList.add("(" + str1 + ")" + str2);
                    }
                }
            }
            l.add(newList);
        }
        return l.get(n);
    }
}
