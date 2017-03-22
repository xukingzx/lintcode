package lintcode;

/**
 * Created by ouakira on 2017/3/14.
 */
public class Binary {
    public static void main(String[] args) {
        System.out.println(binaryRepresentation("4096.6435546875"));
    }

    public static String binaryRepresentation(String n) {
        String[] num = n.split("\\.");
        int left = Integer.parseInt(num[0]);
        Double right = null;
        if (num.length > 1) {
            right = Double.parseDouble("0." + num[1]);
        }
        String str = "";
        while (left != 0) {
            if ((left & 1) == 1) {
                str = "1" + str;
            } else {
                str = "0" + str;
            }
            left = left >>> 1;
        }
        if (right == null || right == 0) {
            return str;
        }
        str += "".equals(str) ? "0." : ".";
        int i;
        for (i = 0; i < 32; i++) {
            right *= 2;
            if (right >= 1) {
                str += "1";
                if (right == 1) {
                    break;
                }
                right -= 1;
            } else {
                str += "0";
            }
        }
        if (i == 32) {
            return "ERROR";
        }
        return str;
    }

    public static int numTrees(int n) {
        // write your code here
        if(n <= 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        for (int i = 1; i <= n; i++) {
            b = a * (4 * i - 2) / (i + 1);
            a = b;
        }
        return b;
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
