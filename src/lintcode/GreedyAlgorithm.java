package lintcode;

import java.util.Arrays;

/**
 * Created by ouakira on 2017/3/22.
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length) {
            return -1;
        }
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length + i; j++) {
                sum += gas[j % length] - cost[j % length];
                if (sum < 0) {
                    break;
                }
            }
            if (sum >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static String largestNumber(int[] num) {
        String[] str = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            str[i] = String.valueOf(num[i]);
        }
        sortArray(str, 0, str.length - 1);
        System.out.println(Arrays.toString(str));
        if (str[0].charAt(0) == '0') {
            return "0";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            stringBuffer.append(str[i]);
        }
        return stringBuffer.toString();
    }

    private static void sortArray(String[] str, int left, int right) {
        int l = left;
        int r = right;
        String temp = str[l];
        while (l < r) {
            while (l < r && sortRule(temp, str[r]))
                r--;
            if (l < r) {
                String s = str[l];
                str[l] = str[r];
                str[r] = s;
                l++;
            }

            while (l < r && !sortRule(temp, str[l]))
                l++;
            if (l < r) {
                String s = str[l];
                str[l] = str[r];
                str[r] = s;
                r--;
            }
        }
        if (l > left) sortArray(str, left, l - 1);
        if (r < right) sortArray(str, l + 1, right);
    }

    /**
     * a >= b 返回true
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean sortRule(String a, String b) {
        return (a + b).compareTo(b + a) >= 0 ? true : false;
    }

    public static String DeleteDigits(String A, int k) {
        String str = A;
        while (k-- > 0) {
            int i;
            for (i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) > str.charAt(i + 1)) {
                    break;
                }
            }
            str = str.substring(0, i) + str.substring(i + 1);
        }
        while (str.charAt(0) == '0') {
            str = str.substring(1);
        }
        return str;
    }

    public static int[] nextPermutation(int[] nums) {
        int length = nums.length;
        for (int i = length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    int a = nums[i];
                    nums[i] = nums[j];
                    nums[j] = a;
                    sort(nums, i, length - 1);
                    return nums;
                }
            }
        }
        sort(nums, 0, length - 1);
        return nums;
    }

    private static void sort(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        int temp = nums[l];
        while (l < r) {
            while (l < r && nums[r] > temp)
                r--;
            if (l < r) {
                int a = nums[l];
                nums[l] = nums[r];
                nums[r] = a;
                l++;
            }
            while (l < r && nums[r] <= temp)
                l++;
            if (l < r) {
                int a = nums[l];
                nums[l] = nums[r];
                nums[r] = a;
                r--;
            }
        }
        if (l > left) sort(nums, left, l - 1);
        if (r < right) sort(nums, l + 1, right);
    }
}
