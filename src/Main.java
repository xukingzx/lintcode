import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        String str = "a";
        map.put(str, "a");
        String str1 = new String("b");
        str1 = "a";
        char c = 97;
        System.out.println(c);
        System.out.println(str.hashCode());
        System.out.println(str1.hashCode());
        System.out.println(str == str1);
        System.out.println(map.get(str1));
    }

    public static void swap(People a, People b){
        People c = new People();
        c = a;
        a = b;
        b = c;
    }

    public static void swapValue(People a, People b){
        String value;
        value = a.getName();
        a.setName(b.getName());
        b.setName(value);
    }

    public static void swapInt(int a, int b){
        int c = a;
        a = b;
        b = c;
    }

    public static void partitionArray(int[] nums){
        int left,right = 0,j,temp = 0;
        for (int i = 0; i < nums.length; i++){
            if ((nums[i] & 1) == 0){
                left = i;
                for (j = i + 1; j < nums.length; j++){
                    if ((nums[j] & 1) == 1){
                        right = j;
                        temp = nums[j];
                        break;
                    }
                }
                if (j == nums.length){
                    break;
                }
                for (int k = right; k > left; k--){
                    nums[k] = nums[k - 1];
                }
                nums[left] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    public static boolean anagram(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        int j;
        for (int i = 0; i < sa.length; i++){
            for (j = 0; j < ta.length; j++){
                if (ta[j] == sa[i]){
                    ta[j] = ' ';
                    break;
                }
            }
            if (j == ta.length){
                return false;
            }
        }
        return true;
    }

    public static List<String> anagrams(String[] strs){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++){
            for (int j = 0; j < strs.length; j++){
                if (i != j && anagram(strs[i], strs[j])){
                    list.add(strs[i]);
                    break;
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    public static int longestCommonSubstring(String A, String B){
        int max = 0;
        for (int i = 0; i < A.length(); i++){
            for (int j = 0; j < B.length(); j++){
                if (A.charAt(i) == B.charAt(j)){
                    int index = 0;
                    while ((i + index < A.length()) && (j + index < B.length())){
                        if (A.charAt(i + index) != B.charAt(j + index)){
                            break;
                        }
                        index++;
                    }
                    max = max < index ? index : max;
                }
            }
        }
        return max;
    }

    public static String longestCommonPrefix(String[] strs){
        String str = "";
        int min = strs[0].length();
        for (int i = 0; i < strs.length; i++){
            min = strs[i].length() > min ? min : strs[i].length();
        }
        for (int i = 0; i < min; i++){
            char temp = strs[0].charAt(i);
            int j;
            for (j = 1; j < strs.length; j++){
                if (strs[j].charAt(i) != temp){
                    return str;
                }
            }
            if (j == strs.length){
                str += temp;
            }
        }
        return str;
    }

    public static int atoi(String str){
        str = str.trim();
        if (str.length() == 0){
            return 0;
        }
        String numStr = "";
        String MIN = "2147483648";
        String MAX = "2147483647";
        boolean flag = true;
        if (str.charAt(0) == '-'){
            flag = false;
            str = str.substring(1);
        }
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) < '0' || str.charAt(i) > '9'){
                break;
            }
            numStr += str.charAt(i);
            if (numStr.length() == 10){
                if (flag && numStr.compareTo(MAX) > 0){
                    numStr = MAX;
                    break;
                }
                if (!flag && numStr.compareTo(MIN) > 0){
                    numStr = MIN;
                    break;
                }
            } else if (numStr.length() > 10){
                if (flag){
                    numStr = MAX;
                    break;
                } else {
                    numStr = MIN;
                    break;
                }
            }
        }
        if (numStr.length() == 0){
            return 0;
        }
        numStr = flag ? numStr : "-" + numStr;
        Integer num = Integer.parseInt(numStr);
        return num;
    }
}
