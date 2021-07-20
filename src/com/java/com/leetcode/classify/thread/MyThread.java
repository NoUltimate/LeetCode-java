package com.java.com.leetcode.classify.thread;
/*
 *
 *
 * @author sunbowen
 * @date 2021年06月30日 16:15
 */

import java.util.concurrent.TimeUnit;

public class MyThread implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        while (true) {
            if (flag) {
                System.out.println("runing");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
    }

    public void stopThread() {
        flag = false;
    }
}
