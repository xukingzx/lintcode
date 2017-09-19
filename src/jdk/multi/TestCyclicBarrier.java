package jdk.multi;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by ouakira on 2017/9/15.
 */
public class TestCyclicBarrier {
    private static final int THREAD_NUM = 5;

    public static class WorkeThread implements Runnable {
        CyclicBarrier barrier;

        public WorkeThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("Workers waiting");
                barrier.await();
                System.out.println("ID:"+Thread.currentThread().getId()+" Working");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(THREAD_NUM, new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Barrier");
                System.out.println(Thread.activeCount());
            }
        });

        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(new WorkeThread(cb)).start();
        }

        System.out.println(Thread.activeCount());
    }
}
