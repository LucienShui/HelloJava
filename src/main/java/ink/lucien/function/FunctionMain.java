package ink.lucien.function;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucien Shui on 2019/9/2.
 */
public class FunctionMain {
    public static class Node {
        private Integer value;

        public Node(Integer value) {
            this.value = value;
        }

        void setValue(Integer value) {
            this.value = value;
        }

        Integer getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Node(i));
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setValue(3);
        }

        for (Node each : list) {
            System.out.println(each.value);
        }
    }
}
