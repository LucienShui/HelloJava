package ink.lucien.trick;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucien on 2019/8/16.
 */
public class TrickMain {
    private static class Test {
        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }

        private String string;
    }

    public static void trick_0() {
        List<Pair<String, Boolean>> list = new ArrayList<>();
        list.add(new Pair<>("Hello", true));
        list.add(new Pair<>("World!", false));
        StringBuffer str = new StringBuffer();
        list.forEach(pair -> {
            str.append(pair.getKey()).append("_").append(pair.getValue() ? "1" : "0").append("|");
        });
        str.deleteCharAt(str.length() - 1);
        System.out.println(str.toString());
    }

    private static void trick_1() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World!");
        System.out.println(String.join(" AND ", list));
    }

    private static void trick_2() {
        Test test = new Test();
        test.setString("Hello World!");
        String str = test.getString();
        str = "Hello Java!";
        System.out.println(test.getString() + " " + str);
    }

    public static void main(String[] args) {
        trick_0();
        trick_1();
        trick_2();
    }
}
