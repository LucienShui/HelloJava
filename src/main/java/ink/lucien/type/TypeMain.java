package ink.lucien.type;

import java.util.ArrayList;
import java.util.List;

public class TypeMain {
    private static void add(List<String> list) {
        list.add("Hello World!");
    }

    public static void main(String[] args) {
        System.out.println(Long.parseLong("123456"));
        try {
            System.out.println(Long.parseLong("1234a6"));
        } catch (Exception e) {
            System.out.println("Number format error");
        }

        List<String> list = new ArrayList<>();
        System.out.println("Before add, list.size() = " + list.size());
        add(list);
        System.out.println("After add, list.size() = " + list.size());


    }
}
