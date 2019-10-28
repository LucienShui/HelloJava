package ink.lucien.aop.runner;

import ink.lucien.aop.annotation.Logging;
import org.springframework.stereotype.Component;

/**
 * Created by Lucien on 2019/10/21 14:58
 */
@Component
public class Runner {

    @Logging
    public String toUpper(String str) {
        return str.toUpperCase();
    }

    @Logging
    public String toLower(String str) {
        return str.toLowerCase();
    }
}
