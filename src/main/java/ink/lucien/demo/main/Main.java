package ink.lucien.demo.main;

import ink.lucien.demo.model.Runner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lucien on 2019/10/24 14:54
 */
@Slf4j
@Service
public class Main {

    @Autowired
    Runner runner;

    private void test(Integer param, Map<String, String> map) {
        String flag;
        if (param.compareTo(0) > 0) {
            flag = "positive";
        } else if (param.compareTo(0) < 0) {
            flag = "negative";
        } else {
            flag = "zero";
        }
        map.put("key", flag);
    }

    public void main() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "Hello World!");
        log.warn("flag = {}", map);
        test(1, map);
        log.warn("flag = {}", map);

        runner.run();
    }
}
