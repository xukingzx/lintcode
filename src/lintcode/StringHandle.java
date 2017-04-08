package lintcode;

/**
 * Created by ouakira on 2017/4/5.
 */
public class StringHandle {
    public static void main(String[] args) {

    }

    public static String countAndSay(int n) {
        String str = "1";
        if (n <= 1) {
            return str;
        }
        for (int i = 0; i < n - 1; i++) {
            str = countAndSay(str);
        }
        return str;
    }

    private static String countAndSay(String str) {
        StringBuffer buffer = new StringBuffer();
        char c = str.charAt(0);
        int num = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != c) {
                buffer.append(num).append(str.charAt(i - 1));
                c = str.charAt(i);
                num = 0;
            }
            num++;
        }
        buffer.append(num).append(str.charAt(str.length() - 1));
        return buffer.toString();
    }
}
