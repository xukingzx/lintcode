package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ouakira on 2017/4/12.
 */
public class Sort {
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 's', 'D', 'f', 'E'};
        int[] nums = new int[] {100,61,56,44,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
        fastSort(nums, 0 , nums.length - 1);
        System.out.println(Arrays.toString(nums));
        sortLetters(chars);
    }

    /**
     * 49-字符大小写排序
     * @param chars
     */
    public static void sortLetters(char[] chars) {
        if (chars.length == 0) {
            return;
        }
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (chars[i] >= 'a' && chars[i] <= 'z' && i < j) {
                i++;
            }
            while (chars[j] >= 'A' && chars[j] <= 'Z' && i < j) {
                j--;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }

    public static int count(int a, int b) {
        return a > b ? a - b : b - a;
    }

    public static void fastSort(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        int temp = nums[left];
        while (l < r) {
            while (l < r && nums[r] >= temp)
                r--;
            if (l < r) {
                nums[l] = nums[r];
                l++;
            }

            System.out.println(Arrays.toString(nums));
            while (l < r && nums[l] <= temp)
                l++;
            if (l < r) {
                nums[r] = nums[l];
                r--;
            }
        }
        nums[l] = temp;
        System.out.println(Arrays.toString(nums));
        System.out.println("l = " + l + " r = " + r + " temp = " + temp);
        if (l > left) {
            System.out.println("进入左, left = " + left + ", right = " + (l - 1));
            fastSort(nums, left, l - 1);
        }
        if (r < right) {
            System.out.println("进入右, left = " + (l + 1) + ", right = " + right);
            fastSort(nums, l + 1, right);
        }

    }

    public static void sort(int[] arr, int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= povit)
                h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }

            while (l < h && arr[l] <= povit)
                l++;

            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.print("l=" + (l + 1) + "h=" + (h + 1) + "povit=" + povit + "\n");
        if (l > low) sort(arr, low, l - 1);
        if (h < high) sort(arr, l + 1, high);
    }

    public static void quickSort(int[] nums, int left, int right) {
        int i = left, j = right;
        int key = nums[i];
    }
}
