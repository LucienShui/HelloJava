package ink.lucien.aop.runner;

import ink.lucien.aop.annotation.Logging;
import ink.lucien.aop.annotation.Timer;
import org.springframework.stereotype.Component;

/**
 * Created by Lucien on 2019/10/21 14:58
 */
@Component
public class Runner {

    @Timer
    @Logging
    public String toUpper(String str) {
        return str.toUpperCase();
    }

    @Timer
    @Logging
    public String toLower(String str) {
        return str.toLowerCase();
    }
}
