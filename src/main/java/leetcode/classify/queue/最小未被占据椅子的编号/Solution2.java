package leetcode.classify.queue.最小未被占据椅子的编号;
/*
 *
 *
 * @author sunbowen
 * @date 2021年07月29日 09:48
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public int smallestChair(int[][] times, int targetFriend) {
        int[] target = times[targetFriend];
        int[] seats = new int[times.length];
        // 保存可以坐的座位编号，最小的在最前面
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        // 保存已经被坐掉的座位，seats数组保存了座位上的人离开的时间
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.comparingInt(o -> seats[o]));
        // 一开始所有座位都可以坐
        for(int i = 0; i < times.length; ++i) pq1.add(i);
        Arrays.sort(times, Comparator.comparingInt(o -> o[0]));
        for(int[] time : times) {
            int cur = time[0], leave = time[1];
            // 当前时间大于离开时间，说明人要离开了，座位就空出来了
            while (!pq2.isEmpty() && seats[pq2.peek()] <= cur) {
                pq1.add(pq2.poll());
            }
            // 当前这个人要入座的是最小的座位，就是p1取出来的第一个
            int pos = pq1.poll();
            seats[pos] = leave;
            pq2.add(pos);
            if (cur == target[0]) return pos;
        }
        return 0;
    }
}
