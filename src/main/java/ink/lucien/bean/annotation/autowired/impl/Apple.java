package ink.lucien.bean.annotation.autowired.impl;

import ink.lucien.bean.annotation.autowired.inter.Fruit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("apple") // https://blog.csdn.net/lovin_fang/article/details/78537547
public class Apple implements Fruit {

    @Override
    public String toString() {
        return "Apple";
    }
}
