package jdk.multi;

/**
 * Created by ouakira on 2017/8/18.
 */
public class Singleton {
    private static Singleton instance = null;
    private static int i = 0;

    private Singleton() {
        i++;
    }

    public static Singleton getInstance() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (instance == null) {
            System.out.println("创建新的对象" + i);
            instance = new Singleton();
        }
        System.out.println("返回原有对象" + (i - 1));
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getInstance();
                }
            }).start();
        }

    }
}
