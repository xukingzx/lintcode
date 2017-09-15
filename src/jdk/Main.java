package jdk;

import jdk.paradigm.Pair;
import jdk.paradigm.Text;

import java.io.Serializable;
import java.util.*;

/**
 * Created by ouakira on 2017/4/11.
 */
public class Main {
    public static void main(String[] args) {
//        Text first = new Text("first");
//        first.setText("first");
//        Text second = new Text("seconde");
//        second.setText("second");
        String first = "first";
        String second = "second";
        Pair<String> textPair = new Pair<>(first, second);
        first = "third";
        System.out.println(textPair);
        String a = "1234";
        String b = "1234";
        String c = new String("1234");
        String d = "abcd";
        String e = "1234abcd";
        String f = "1234" + "abcd";
        String g = "1234" + d;
        String h = a + d;
        String i = h.intern();
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(e == f);
        System.out.println(e == g);
        System.out.println(e == h);
        System.out.println(e == i);
    }

    public static Optional<Article> getFirstJavaArticle() {
        List<Article> articles = new ArrayList<>();
        articles.add(new Article("jdk1.8新特性", "王旭", new ArrayList<String>(Arrays.asList("c++", "服务器"))));
        articles.add(new Article("jdk1.8新特性", "王旭", new ArrayList<String>(Arrays.asList("java", "服务器"))));
        return articles.stream().filter(article -> article.getTags().contains("java")).findFirst();
    }

}
class Box<T> {
    private T data;

    public Box (T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}