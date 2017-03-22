package lintcode;

/**
 * Created by ouakira on 2017/3/14.
 */
public class Binary {
    public static void main(String[] args) {
        System.out.println(updateBit(35,41,3,9));
    }

    public static int fastPower(int a, int b, int n) {
        long x = 1;
        long la = a;
        while (n != 0) {
            if ((n & 1) == 1) {
                x *= la % b;
                x = x % b;
            }
            la = ((la % b) * la) % b;
            n = n >> 1;
        }
        return (int) x;
    }

    public static int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 0) {
            return 0;
        }
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                r[j] += r[j - 1];
            }
        }
        return r[n - 1];
    }

    public static int updateBit(int n, int m, int i, int j) {
        int f = 0xFFFFFFFF;
        int temp = 0x00000001;
        for (int k = 0; k <= j; k++) {
            if (k >= i) {
                System.out.println("第" + k + "位置0:" + n);
                System.out.println(temp);
                n = (f ^ temp) & n;
            }

            temp = temp << 1;
        }
        m = m << i;
        System.out.println(n);
        System.out.println(m);
        return n | m;
    }
}
