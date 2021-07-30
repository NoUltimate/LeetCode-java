package leetcode.classify.dp.礼物的最大价值;
/*
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 礼物的最大价值
 * @author sunbowen
 * @date 2021年07月23日 15:34
 */

import java.util.*;

public class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        StringBuilder sb = new StringBuilder();
        sb.delete(0, sb.length());
        int tar = times[targetFriend][0];
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int[] seats = new int[times.length];
        Set<Integer> set = new HashSet();
        Iterator<Integer> iterator = set.iterator();
        for(int[] time : times) {
            int pos = set.size();
            while (iterator.hasNext()) {
                int i = iterator.next();
                if (time[0] >= seats[i]) {
                    iterator.remove();
                    seats[i] = 0;
                    pos = Math.min(pos, i);
                } else if (seats[i + 1] == 0){
                    pos = Math.min(pos, i + 1);
                }
            }
            if (tar == time[0]) {
                return pos;
            }
            set.add(pos);
            seats[pos] = time[1];
        }
        return 0;
    }
}
