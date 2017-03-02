package lintcode;

import java.util.*;

/**
 * Created by ouakira on 2017/2/10.
 */
public class IntegerArray {
    public static void main(String[] args) {
        int[] nums = {101,33,44,55,67,78,-101,33,-44,55,-67,78,-100,200,-1000,22,100,200,1000,22};
        int[] nums2 = {2, 3};
        System.out.println(Arrays.toString(subarraySumClosest(nums)));
    }

    public static int[] subarraySumClosest(int[] nums){
        Map<Integer, int[]> map = new HashMap<>();
        int min = f(nums[0]);
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for (int j = i; j < nums.length; j++){
                sum += nums[j];
                if (sum == 0){
                    return new int[]{i, j};
                }
                map.put(f(sum), new int[]{i, j});
                if (f(sum) < min){
                    min = f(sum);
                }
            }
        }
        return map.get(min);
    }

    public static int removeElement(int[] A, int elem) {
        int count = A.length;
        for (int i = 0, j = A.length - 1; i < A.length && i < j; i++) {
            if (A[i] == elem) {
                A[i] = A[j];
                A[j] = elem;
                j--;
                i--;
                count--;
            }
        }
        return count - 1;
    }

    public static ArrayList<Integer> subarraySum(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                list.add(map.get(sum) + 1);
                list.add(i);
                return list;
            }
            map.put(sum, i);
        }
        return list;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int len = m + n - 1;
        m--;
        n--;
        while (n >= 0 && m >= 0) {
            if (A[m] > B[n]) {
                A[len--] = A[m--];
            } else {
                A[len--] = B[n--];
            }
        }
        while (n >= 0) {
            A[len--] = B[n--];
        }
        System.out.println(Arrays.toString(A));
    }

    public static ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            Long total = 1L;
            for (int j = 0; j < A.size(); j++) {
                if (j != i) {
                    total *= A.get(j);
                }
            }
            list.add(total);
        }
        return list;
    }

    public static ArrayList<Long> productExcludeItselfCopy(ArrayList<Integer> A) {
        // write your code

        ArrayList<Long> B = new ArrayList<Long>();
        if (A == null || A.size() == 1) {
            long bi = 1;
            B.add(bi);
            return B;
        }
        long[] left = new long[A.size()];
        long[] right = new long[A.size()];
        left[0] = 1;
        for (int i = 1; i < A.size(); i++) {
            left[i] = left[i - 1] * A.get(i - 1);
        }
        right[A.size() - 1] = 1;
        for (int i = A.size() - 2; i >= 0; i--) {
            right[i] = right[i + 1] * A.get(i + 1);
        }
        for (int i = 0; i < A.size(); i++) {
            long res = right[i] * left[i];
            B.add(res);
        }
        return B;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] back = new int[2];
        int length = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(numbers[i])) {
                back[0] = map.get(numbers[i]) + 1;
                back[1] = i + 1;
                return back;
            }
            map.put(target - numbers[i], i);
        }
        return back;
    }

    public static int firstMissingPositive(int[] A) {
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                if (num == 0) {
                    num = A[i];
                } else {
                    if (A[i] - num == 1) {
                        num = A[i];
                    } else {
                        break;
                    }
                }
            }
        }
        return num + 1;
    }

    public static int threeSumClosest(int[] numbers, int target) {
        if (numbers.length < 3) {
            return 0;
        }
        int num = 0;
        Integer min = null;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                for (int k = 0; k < numbers.length; k++) {
                    if (min == null) {
                        min = numbers[i] + numbers[j] + numbers[k] - target;
                        if (min < 0)
                            min = -min;
                        else if (min == 0)
                            return target;
                    } else {
                        if (f(min) > f(numbers[i] + numbers[j] + numbers[k] - target)) {
                            min = numbers[i] + numbers[j] + numbers[k] - target;
                        }
                    }
                }
            }
        }
        num = min + target;
        return num;
    }

    private static int f(int n) {
        return n >= 0 ? n : -n;
    }

    public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (numbers.length < 3) {
            return lists;
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    if (numbers[i] + numbers[j] + numbers[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        Collections.sort(list);
                        int index;
                        for (index = 0; index < lists.size(); index++) {
                            if (f(lists.get(index), list)) {
                                break;
                            }
                        }
                        if (index == lists.size()) {
                            lists.add(list);
                        }
                    }
                }
            }
        }
        return lists;
    }

    private static boolean f(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if (!b.contains(a.get(i))) {
                return false;
            }
            if (!a.contains(b.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static int partitionArray(int[] nums, int k) {
        int num = 0;
        if (nums.length == 0)
            return num;
        int i, j;
        for (i = 0, j = nums.length - 1; i < nums.length && i < j; i++) {
            while (nums[j] >= k && i < j) {
                j--;
            }
            if (nums[i] >= k) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (k <= nums[i]) {
                break;
            }
        }
        return i;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        boolean v = true;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j] && v) {
                nums[++i] = nums[j];
                v = false;
            }
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
                v = true;
            }
        }
        return i + 1;
    }

    public static int[] mergeSortedArray(int[] A, int[] B) {
        int alen = A.length - 1;
        int blen = B.length - 1;
        int len = alen + blen + 1;
        int[] nums = new int[len + 1];
        while (alen >= 0 && blen >= 0) {
            nums[len--] = A[alen] >= B[blen] ? A[alen--] : B[blen--];
        }
        while (blen >= 0) {
            nums[len--] = B[blen--];
        }
        while (alen >= 0){
            nums[len--] = A[alen--];
        }
        return nums;
    }
}
