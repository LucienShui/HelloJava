package ink.lucien.bean.annotation.qualifier;

import ink.lucien.bean.annotation.qualifier.inter.Fruit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Store {

    private final Fruit fruit;

    // 通过 Qualifier 指定特定的 Bean
    public Store(@Qualifier("banana") Fruit fruit) {
        this.fruit = fruit;
    }

    public String toString() {
        return fruit.toString();
    }
}
