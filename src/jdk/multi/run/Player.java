package jdk.multi.run;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by ouakira on 2017/9/15.
 */
public class Player implements Runnable {
    private int num;
    private CountDownLatch countDownLatch;

    public Player(int num, CountDownLatch countDownLatch) {
        this.num = num;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("选手" + num + "准备就绪");
        countDownLatch.countDown();
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("选手" + num + "到达终点");
    }
}
