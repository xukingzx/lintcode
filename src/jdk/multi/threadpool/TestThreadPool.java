package jdk.multi.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ouakira on 2017/9/16.
 */
public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService cacheExecutor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
