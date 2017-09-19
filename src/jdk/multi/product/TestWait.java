package jdk.multi.product;

/**
 * Created by ouakira on 2017/9/16.
 */
public class TestWait {
    public static final Object obj = new Object();

    public static void main(String[] args) {
        new Thread( new Produce()).start();
        new Thread( new Consumer()).start();

    }
}
