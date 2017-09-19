package jdk.multi;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ouakira on 2017/9/15.
 */
public class Teacher implements Runnable {
    private CountDownLatch countDownLatch;

    public Teacher(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Teacher is waiting...");
            countDownLatch.await();
            System.out.println("Teacher is collecting...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
