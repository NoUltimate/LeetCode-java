package com.java.com.leetcode.classify.thread;
/*
 *
 *
 * @author sunbowen
 * @date 2021年06月30日 16:31
 */

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

    private Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                try {
                    if (queue.isEmpty()) {
                        System.out.println("生产物品为空，等待生产");
                        queue.wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    TimeUnit.MICROSECONDS.sleep(new Random().nextInt(500));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int value = queue.poll();
                queue.notify();
                System.out.println("消费完成：" + value);
            }
        }
    }
}
