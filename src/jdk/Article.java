package jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ouakira on 2017/4/11.
 */
public class Article {
    private String title = "java新特性";

    private String author = "王旭";

    private List<String> tags = new ArrayList<>(Arrays.asList("java", "中台", "服务器"));

    public Article(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", tags=" + tags +
                '}';
    }
}
