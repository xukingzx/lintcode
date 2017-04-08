package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ouakira on 2017/3/22.
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        int[] gas = {4,6,4};
        int[] cost = {3,5,7};
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("10");
        Collections.sort(list);
        System.out.println(list);
        //System.out.println(largestNumber(cost));
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
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            list.add(String.valueOf(num[i]));
        }
        Collections.sort(list);
        if (list.get(list.size() - 1).equals("0")) {
            return "0";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = list.size() - 1; i >= 0; i--) {
            stringBuffer.append(list.get(i));
        }
        return stringBuffer.toString();
    }
}
