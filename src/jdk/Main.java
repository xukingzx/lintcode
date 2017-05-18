package jdk;

import java.util.*;

/**
 * Created by ouakira on 2017/4/11.
 */
public class Main {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if ("2".equals(next)) {
                it.remove();
            }
        }
//        for (String temp : a) {
//            if ("2".equals(temp)) {
//                a.remove(temp);
//            }
//        }
        System.out.println(a.toString());
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