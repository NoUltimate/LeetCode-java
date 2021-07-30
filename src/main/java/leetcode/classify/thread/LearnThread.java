package leetcode.classify.thread;
/*
 *
 *
 * @author sunbowen
 * @date 2021年06月30日 16:11
 */

import java.util.LinkedList;
import java.util.Queue;

public class LearnThread {


    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread);
//        thread.start();
//        TimeUnit.SECONDS.sleep(5);
//        myThread.stopThread();


        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 6;

        Producer producer = new Producer(queue, maxSize);
        Consumer consumer = new Consumer(queue);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
        new Thread(consumerThread).start();

    }
}
