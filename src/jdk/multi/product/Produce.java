package jdk.multi.product;

/**
 * Created by ouakira on 2017/9/16.
 */
public class Produce implements Runnable {
    @Override
    public synchronized void run() {
        int count = 10;
        while (count > 0) {
            synchronized (TestWait.obj) {

                System.out.print("A");
                count--;
                TestWait.obj.notify(); // 主动释放对象锁

                try {
                    TestWait.obj.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("finish");
    }
}
