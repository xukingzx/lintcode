package jdk;

/**
 * Created by ouakira on 2017/4/27.
 */
public class TestStatic {
    private static int staticCount = 0;

    private int count = 0;

    public TestStatic() {
        staticCount++;
        count++;
        System.out.println(staticCount);
        System.out.println(count);
    }
}
