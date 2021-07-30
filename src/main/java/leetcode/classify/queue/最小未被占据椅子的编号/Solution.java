package leetcode.classify.queue.最小未被占据椅子的编号;
/*
 * https://leetcode-cn.com/problems/the-number-of-the-smallest-unoccupied-chair/
 * 1942. 最小未被占据椅子的编号
 * @author sunbowen
 * @date 2021年07月29日 09:45
 */

import java.util.*;

public class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int tar = times[targetFriend][0];
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] == o1[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int[] seats = new int[times.length];
        Set<Integer> set = new HashSet();
        for(int[] time : times) {
            int pos = set.size();
            Iterator<Integer> iterator = set.iterator();
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
