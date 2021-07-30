package leetcode.classify.search.backtracking.复原IP地址;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 复原IP地址
 * Desc:
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * Created by sunbowen on 2021/2/1
 */
public class Solution {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        List<String> concat = new ArrayList<>();
        dfs(s, 0, concat);
        return result;
    }

    public void dfs(String s, int start, List<String> concat) {
        if (concat.size() > 4) {
            return ;
        }
        if (concat.size() == 4 && start == s.length()) {
            result.add(String.join(".", concat));
        }
        if (s.length() - start < 4 - concat.size() || s.length() - start > 3*(4- concat.size())) {
            return ;
        }
        // StringBuilder比string快很多
        StringBuilder ip = new StringBuilder();
        for(int i = start; i < s.length(); ++i) {
            ip.append(s.charAt(i));
            if (!valid(ip.toString())) {
                continue;
            }
            concat.add(ip.toString());
            dfs(s, i + 1, concat);
            concat.remove(concat.size() - 1);
        }
    }

    public boolean valid(String ip) {
        if (ip.length() > 1 && ip.charAt(0) == '0') {
            return false;
        }
        if (ip.length() > 3) {
            return false;
        }
        if (Integer.parseInt(ip) > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(new Solution().restoreIpAddresses("010010")));
    }
}
