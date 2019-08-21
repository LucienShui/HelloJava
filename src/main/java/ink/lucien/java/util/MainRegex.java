package ink.lucien.java.util;

import java.util.regex.Pattern;

/**
 * Created by qingyuan.sqy on 2019/8/21.
 */
public class MainRegex {
    public static void main(String[] args) {
        String content = "01234567asd";
        String pattern = "[0-9]+";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("is match: " + isMatch);
    }
}
