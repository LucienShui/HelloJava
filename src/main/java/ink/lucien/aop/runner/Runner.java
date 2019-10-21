package ink.lucien.aop.runner;

import ink.lucien.aop.annotation.Permission;
import org.springframework.stereotype.Component;

/**
 * Created by qingyuan.sqy on 2019/10/21 14:58
 */
@Component
public class Runner {

    @Permission
    public String toUpper(String str) {
        return str.toUpperCase();
    }

    @Permission("Hello")
    public String toLower(String str) {
        return str.toLowerCase();
    }
}
