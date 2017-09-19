package jdk.multi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ouakira on 2017/9/15.
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(3);

        Student s1 = new Student(101, countDownLatch);
        Student s2 = new Student(102, countDownLatch);
        Student s3 = new Student(103, countDownLatch);
        Teacher t = new Teacher(countDownLatch);

        executor.execute(t);
        executor.execute(s1);
        executor.execute(s2);
        executor.execute(s3);

        executor.shutdown();
    }
}
