package leetcode.classify.thread.哲学家进餐;
/*
 *
 *
 * @author sunbowen
 * @date 2021年06月03日 13:55
 */

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    public DiningPhilosophers() {

    }

    private final ReentrantLock[] lockList = {
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock(),
            new ReentrantLock()
    };

    Semaphore semaphore = new Semaphore(4);

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = (philosopher + 1) % 5;
        int right = philosopher;
        semaphore.acquire();
        lockList[left].lock();
        lockList[right].lock();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        lockList[left].unlock();
        lockList[right].unlock();
        semaphore.release();
    }
}
