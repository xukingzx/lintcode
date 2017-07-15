/**
 * Created by ouakira on 2017/6/2.
 */
public class Test
{
    public static Test t1 = new Test();

    static
    {
        System.out.println("blockB");
    }

    {
        System.out.println("blockA");
    }

    public static void main(String[] args)
    {
        Test t2 = new Test();
        System.out.println(" 我喜欢学习 Java!".length());
    }
}