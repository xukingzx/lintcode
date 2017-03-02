package util;

/**
 * Created by ouakira on 2017/2/10.
 */
public class ValueUtil {
    public static String getString(Object obj){
        return getString(obj, "");
    }

    public static String getString(Object obj, String defaultValue){
        return obj == null ? defaultValue : String.valueOf(obj);
    }

    public static void main(String[] args){
        char value = '2';
        System.out.println(getString(value));
    }
}
