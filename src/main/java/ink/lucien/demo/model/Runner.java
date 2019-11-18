package ink.lucien.demo.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucien on 2019/10/24 16:17
 */
@Service
public class Runner {

    public void run() {
        System.out.println("Hello World!");
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            System.out.println(s);
        }
    }

}
