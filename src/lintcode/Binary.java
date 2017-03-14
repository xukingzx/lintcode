package lintcode;

/**
 * Created by ouakira on 2017/3/14.
 */
public class Binary {
    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }

    public static int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 0 ) {
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
}
