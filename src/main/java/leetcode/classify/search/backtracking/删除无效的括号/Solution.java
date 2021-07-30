package leetcode.classify.search.backtracking.删除无效的括号;

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Title: 301. 删除无效的括号(困难回溯)
 * Desc: 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。说明: 输入可能包含了除 ( 和 ) 以外的字符。
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/
 * Created by sunbowen on 2021/1/21
 */
class Solution {
    public boolean check(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
    
    public List<String> removeInvalidParentheses(String s) {
        Set<String> level = new HashSet<>();
        level.add(s);
        while (true) {
            List<String> valid = level.stream().filter(this::check).collect(Collectors.toList());
            if (valid.size() > 0)
                return valid;
            Set<String> subLevel = new HashSet<>();
            for(String str : level) {
                for(int i = 0; i < str.length(); ++i) {
                    if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                        subLevel.add(str.substring(0, i) + str.substring(i+1));
                    }
                }
            }
            level = subLevel;
            // 直到删除完所有字符都没有符合条件的时候返回空数组
            if (level.size() == 0) return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("test");
        test.add("haha");
        JSONObject object = new JSONObject();
        for(String t : test) {
            object.put("test", t);
            System.out.println(JSONObject.toJSONString(object));
        }
    }
}
