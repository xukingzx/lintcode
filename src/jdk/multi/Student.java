package jdk.multi;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by ouakira on 2017/9/15.
 */
public class Student implements Runnable {
    private int num;

    private CountDownLatch countDownLatch;

    public Student(int num, CountDownLatch countDownLatch) {
        this.num = num;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        doExam();
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Student " + num + " finished!");
        countDownLatch.countDown();
    }

    private void doExam() {
        System.out.println("Student \"+num+\" is doing the exam!");
    }
}
