package lintcode;

/**
 * Created by ouakira on 2017/2/27.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {4,2147483645,2147483646,2147483647};
        System.out.println(search(nums, 4));

    }

    public static int search(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == A[mid]) {
                return mid;
            }
            if ((target > A[mid] && target < A[A.length - 1]) || (target < A[mid] && target <= A[A.length - 1])) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int woodCut(int[] L, int k) {
        long sum = 0;
        int max = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i];
            max = max > L[i] ? max : L[i];
        }
        int left = 0;
        int right = max;
        if (right <= 1) {
            return right;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < L.length; i++) {
                sum1 += L[i] / mid;
                sum2 += L[i] / (mid + 1);
            }
            if (sum1 == k && sum2 < k) {
                return mid;
            }
            if (sum2 >= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public static int binarySearch(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0]) {
            return -1;
        }
        if (target > nums[nums.length - 1]) {
            return -1;
        }
        if (target == nums[0]) {
            return 0;
        }
        int left = 1;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid] && target > nums[mid - 1]) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int left = 0;
        int right = matrix.length - 1;
        int temp = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= matrix[mid][0]) {
                if (mid < matrix.length - 1 && target < matrix[mid + 1][0]) {
                    if (target > matrix[mid][0]) {
                        temp = mid;
                        break;
                    }
                    return true;
                } else if (mid == matrix.length - 1) {
                    if (target > matrix[mid][0]) {
                        temp = mid;
                        break;
                    }
                    return true;
                }
            }
            if (target >= matrix[mid][0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(temp);
        left = 0;
        right = matrix[temp].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[temp][mid]) {
                return true;
            } else if (target > matrix[temp][mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static int searchInsert(int[] A, int target) {
        if (A.length == 0) {
            return 0;
        }
        if (target <= A[0]) {
            return 0;
        }
        int length = A.length;
        if (target > A[length - 1]) {
            return length;
        }
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= A[mid] && target > A[mid - 1]) {
                return mid;
            }
            if (target <= A[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    private static int sqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long num = (long) mid * (long) mid;
            long num1 = (long) (mid - 1) * (long) (mid - 1);
            long num2 = (long) (mid + 1) * (long) (mid + 1);
            if (num == x) {
                return mid;
            }
            if (num > x && num1 < x) {
                return mid - 1;
            }
            if (num < x && num1 > x) {
                return mid;
            }
            if (num < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

//    private static int binarySearch(int[] nums, int num) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == num) {
//                return mid + 1;
//            } else if (nums[mid] > num) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return -1;
//    }
}
