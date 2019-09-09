package ink.lucien.java.util.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.stream().filter(each -> each > 0).parallel().forEach(num -> {
            if (num % 2 == 0) {
                return ;
            }
            System.out.println(num);
        });
    }
}
