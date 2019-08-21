package ink.lucien.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qingyuan.sqy on 2019/8/19.
 */
public class LambdaMain {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) list.add(i);
        list.forEach(System.out::println);
    }
}
