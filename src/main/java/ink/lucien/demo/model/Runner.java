package ink.lucien.demo.model;

import org.springframework.stereotype.Service;

/**
 * Created by Lucien on 2019/10/24 16:17
 */
@Service
public class Runner {
    public void run() {
        System.out.println("abc".hashCode());
    }
}
