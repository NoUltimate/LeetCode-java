package com.java.com.leetcode.thread;
/*
 *
 *
 * @author sunbowen
 * @date 2021年06月30日 16:31
 */

import org.apache.commons.lang3.RandomUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Producer implements Runnable {
    private Queue<Integer> queue;
    private int maxSize;

    public Producer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                try {
                    if (queue.size() == maxSize) {
                        System.out.println("生产队列已满");
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
                int random = RandomUtils.nextInt();
                queue.add(random);
                queue.notify();
                System.out.println("生产队列加入:" + random);
            }
        }
    }
}
