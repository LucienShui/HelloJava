package ink.lucien.bean.annotation.qualifier.impl;

import ink.lucien.bean.annotation.qualifier.inter.Fruit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("banana")
public class Banana implements Fruit {

    @Override
    public String toString() {
        return "Banana";
    }
}
