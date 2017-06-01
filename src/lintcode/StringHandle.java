package lintcode;

import java.util.Arrays;

/**
 * Created by ouakira on 2017/4/5.
 */
public class StringHandle {
    public static void main(String[] args) {
        System.out.println(reverseWords("hello     world        nihao"));
    }

    /**
     * 53-翻转字符串
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return s;
        }
        s = s.trim();
        int i = 1;
        int j = 1;
        int begin = 0;
        int end;
        char[] chars = s.toCharArray();
        while(i < chars.length) {
            if (!(chars[i - 1] == ' ' && chars[i] == ' ')) {
                chars[j] = chars[i];
                j++;
            }
            i++;
        }
        chars = Arrays.copyOfRange(chars, 0, j);
        for (i = 0; i < chars.length; i++) {
            if (i == chars.length - 1 || chars[i + 1] == ' ') {
                end = i;
                reveseWord(chars, begin, end);
                begin = i + 2;
            }
        }
        for (i = 0, j = chars.length - 1;i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    private static void reveseWord(char[] chars, int a, int b) {
        for (int i = a, j = b; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
    /**
     * 491-回文数
     * @param num
     * @return
     */
    public static boolean palindromeNumber(int num) {
        String s = String.valueOf(num);
        int i = 0;
        int j = s.length() - 1;
        while (s.charAt(i) == s.charAt(j) && i < j) {
            i++;
            j--;
        }
        if (i < j) {
            return false;
        }
        return true;
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

    public static String addStrings(String num1, String num2) {
        // Write your code here
        final StringBuffer buffer = new StringBuffer();
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        String s = num1.length() > num2.length() ? num1 : num2;
        int flag = 0;
        while (len1 >= 0 && len2 >= 0) {
            int num = num1.charAt(len1) + num2.charAt(len2) + flag - 96;
            if (num < 10) {
                flag = 0;
                buffer.insert(0, num);
            } else {
                flag = 1;
                buffer.insert(0, num % 10);
            }
            len1--;
            len2--;
        }
        while (len1 >= 0) {
            int num = num1.charAt(len1) + flag - 48;
            if (num < 10) {
                flag = 0;
                buffer.insert(0, num);
            } else {
                flag = 1;
                buffer.insert(0, num % 10);
            }
            len1--;
        }
        while (len2 >= 0) {
            int num = num2.charAt(len2) + flag - 48;
            if (num < 10) {
                flag = 0;
                buffer.insert(0, num);
            } else {
                flag = 1;
                buffer.insert(0, num % 10);
            }
            len2--;
        }
        return buffer.toString();
    }

}
