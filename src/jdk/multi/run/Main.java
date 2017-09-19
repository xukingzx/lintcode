package jdk.multi.run;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ouakira on 2017/9/15.
 */
public class Main {
    private static final int PLAYER_NUM = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(PLAYER_NUM);
        for (int i = 0; i < PLAYER_NUM; i++) {
            executor.execute(new Player(i, countDownLatch));
        }
        executor.shutdown();
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("比赛结束");
    }
}
