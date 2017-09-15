package jdk.paradigm;

/**
 * Created by ouakira on 2017/9/13.
 */
public class Text {
    private final String text;

    public Text() {
        text = "";
    }

    public Text(String str) {
        text = str;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Text{" +
                "text='" + text + '\'' +
                '}';
    }
}
