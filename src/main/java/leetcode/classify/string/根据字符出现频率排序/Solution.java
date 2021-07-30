package leetcode.classify.string.根据字符出现频率排序;
/*
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/submissions/
 *
 * @author sunbowen
 * @date 2021年05月21日 14:14
 */

import java.util.*;

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            int count = m.getOrDefault(s.charAt(i), 0);
            m.put(s.charAt(i), count + 1);
        }

//        int compare(T o1, T o2);
//　　     这里o1表示位于前面的对象，o2表示后面的对象
//        返回-1（或负数），表示不需要交换01和02的位置，o1排在o2前面，asc
//        返回1（或正数），表示需要交换01和02的位置，o1排在o2后面，desc

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return m.get(o2) - m.get(o1);
            }
        });
        queue.addAll(m.keySet());
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            for(int i = 0; i < m.get(c); ++i) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
