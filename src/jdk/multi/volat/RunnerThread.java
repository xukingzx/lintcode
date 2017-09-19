package jdk.multi.volat;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ouakira on 2017/9/18.
 */
public class RunnerThread extends Thread {
    //boolean bExit = false;
    Num num;
    int i;

    public RunnerThread(Num num, int i) {
        this.num = num;
        this.i = i;
    }

    public void exit(Num num) {
        this.num = num;
    }
    @Override
    public void run() {
//        while (!num.b) {
//            System.out.println(i + "线程执行中～");
//            if (i == 0) {
//                num.b = true;
//            }
//        }
        if (i == 0) {
            System.out.println(i);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(i + "线程运行结束");
    }
}
