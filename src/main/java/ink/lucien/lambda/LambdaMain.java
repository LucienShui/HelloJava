package ink.lucien.lambda;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import static java.util.Comparator.comparing;

/**
 * Created by qingyuan.sqy on 2019/8/19.
 */
public class LambdaMain {
    @Data
    public static class Node {
        Node(Integer value) {
            this.value = value;
        }
        Integer value;
    }

    private static void sample_0() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) list.add(i);
        list.forEach(System.out::println);
    }

    private static void custom_sort(List<Node> list) {
        list.sort((x, y) -> y.value.compareTo(x.value));
    }

    private static void sample_1() {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) list.add(new Node(i));
        custom_sort(list);
        for (Node each : list) {
            System.out.println(each.value);
        }
    }

    private static void sample_2() {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) list.add(new Node(i));
        list.sort(Comparator.comparing(x -> x.value));
    }

    // Unique custom class
    private static void sample_3() {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) list.add(new Node(i));
        for (int i = 0; i < 5; i++) list.add(new Node(i));
        list = list.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparing(Node::getValue))), ArrayList::new)
        );
        for (Node each : list) {
            System.out.print(each.getValue() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        sample_3();
    }
}
