package jdk.multi;

/**
 * Created by ouakira on 2017/9/16.
 */
public class TestThread {
    public static void main(String[] args)  {
        MyThread thread = new MyThread();
        thread.start();
        MyThread thread1 = new MyThread();
        thread1.start();
    }
}
class MyThread extends Thread{
    private static int num = 0;
    public MyThread(){
        num++;
    }
    @Override
    public void run() {
        System.out.println("主动创建的第"+num+"个线程");
    }
}